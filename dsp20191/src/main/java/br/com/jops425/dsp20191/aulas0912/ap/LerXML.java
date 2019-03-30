package br.com.jops425.dsp20191.aulas0912.ap;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/**
 * Created by aluno on 28/03/19.
 */
public class LerXML {

    public static void main(String[] args) {
        final String caminho = "src/main/resources/students.xml";
        final String tags = "/class/student";
        ler(caminho, tags);
    }

    public static void ler(final String caminho, final String tags) {
        try {
            File file = new File(caminho);
            SAXReader sax = new SAXReader();
            Document document = sax.read(file);

            Element element = document.getRootElement();

            List<Node> nodes = document.selectNodes(tags);

            for (Node no : nodes) {
                if (no.selectSingleNode("matricula").getText().equals("201602498")) {
                    System.out.println(no.selectSingleNode("matricula").getText());
                    System.out.println(no.selectSingleNode("firstname").getText());
                    System.out.println(no.selectSingleNode("lastname").getText());
                    System.out.println(no.selectSingleNode("nickname").getText());
                    List<Node> subnode = no.selectNodes("frequencia/aulas");
                    for (Node subno : subnode) {
//                    System.out.println(subno.valueOf("@numero"));
//                    System.out.println(subno.getText());
                        System.out.printf("Aulas %s: %s\n", subno.valueOf("@numero"), subno.getText());
                    }
                    System.out.println();
                    System.out.println("\n");
                }
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
