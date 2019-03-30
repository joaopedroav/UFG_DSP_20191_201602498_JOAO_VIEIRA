package br.com.jops425.dsp20191.aulas0912.ap;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.DocumentHelper;
import org.dom4j.io.SAXReader;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;


/**
 * Created by aluno on 28/03/19.
 */
public class LerXML {

    public static void main(String[] args) {
        final String caminho = "src/main/resources/students.xml";
        final String tags = "/class/student";
        List<Node> nodes = ler(caminho, tags);
        imprimir(nodes);
        gerar();
    }

    public static List<Node> ler(final String caminho, final String tags) {
        List<Node> nodes = null;
        try {
            File file = new File(caminho);
            SAXReader sax = new SAXReader();
            Document document = sax.read(file);

            Element element = document.getRootElement();

            nodes = document.selectNodes(tags);

        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return nodes;
    }

    public static void imprimir(List<Node> nodes) {
        for (Node no : nodes) {
            if (no.selectSingleNode("matricula").getText().equals("201602498")) {
                System.out.println(no.selectSingleNode("matricula").getText());
                System.out.println(no.selectSingleNode("firstname").getText());
                System.out.println(no.selectSingleNode("lastname").getText());
                System.out.println(no.selectSingleNode("nickname").getText());
                List<Node> subnode = no.selectNodes("frequencia/aulas");
                for (Node subno : subnode) {
                    System.out.printf("Aulas %s: %s\n", subno.valueOf("@numero"), subno.getText());
                }
            }
        }
    }

    public static void gerar() {
        try {
            Document document = DocumentHelper.createDocument();
            Element root = document.addElement( "class" );
            Element studentElement = root.addElement("students");

            studentElement.addElement("matricula").addText("201602498");
            studentElement.addElement("firstname").addText("JOÃO PEDRO");
            studentElement.addElement("lastname").addText("VIEIRA");
            studentElement.addElement("nickname").addText("joao.vieira");

            Element frequencyElement = studentElement.addElement("frequencia");

            frequencyElement.addElement("aulas")
                    .addAttribute("numero", "0104")
                    .addText("P");

            frequencyElement.addElement("aulas")
                    .addAttribute("numero", "0508")
                    .addText("P");

            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter writer;
            writer = new XMLWriter( System.out, format );
            writer.write( document );
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
