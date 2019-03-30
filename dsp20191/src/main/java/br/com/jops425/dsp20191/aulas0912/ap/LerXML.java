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
        gerar(nodes);
    }

    public static List<Node> ler(final String caminho, final String tags) {
        List<Node> nodes = null;
        Node node = null;
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

    public static void gerar(List<Node> nodes) {
        try {
            Document document = null;
            for (Node no : nodes) {
                if (no.selectSingleNode("matricula").getText().equals("201602498")) {
                    document = DocumentHelper.createDocument();
                    Element root = document.addElement( "class" );
                    Element studentElement = root.addElement("students");

                    studentElement.addElement("matricula").addText(no.selectSingleNode("matricula").getText());
                    studentElement.addElement("firstname").addText(no.selectSingleNode("firstname").getText());
                    studentElement.addElement("lastname").addText(no.selectSingleNode("lastname").getText());
                    studentElement.addElement("nickname").addText(no.selectSingleNode("nickname").getText());

                    Element frequencyElement = studentElement.addElement("frequencia");

                    List<Node> subnode = no.selectNodes("frequencia/aulas");
                    for (Node subno : subnode) {
                        frequencyElement.addElement("aulas")
                            .addAttribute("numero", subno.valueOf("@numero"))
                            .addText(subno.getText());
                    }
                }
            }

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
