import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;

public class MainXmlTest {
    public static void main(String[] args) {
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        try {
//            DocumentBuilder builder = factory.newDocumentBuilder();
//            Document document = builder.parse(new File("D:/IdeaProjects/test2/src/main/resources/request.xml"));
//
//            Schema schema = null;
//            try {
//                String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
//                SchemaFactory factorys = SchemaFactory.newInstance(language);
//                schema = factorys.newSchema(new File("D:/IdeaProjects/test2/src/main/resources/request.xml"));
//            } catch (Exception e) {
//            }
//            Validator validator = schema.newValidator();
//            validator.validate(new DOMSource(document));
//        } catch (ParserConfigurationException e) {
//            e.printStackTrace();
//        } catch (SAXException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //Get Document Builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File("D:/IdeaProjects/test2/src/main/resources/request.xml"));

            document.getDocumentElement().normalize();

            Element soapenvEnvelope = document.getDocumentElement();
            System.out.println(soapenvEnvelope.getNodeName());

            Element soapenvBody = (Element)soapenvEnvelope.getElementsByTagName("soapenv:Body").item(0);
            System.out.println(soapenvBody.getTagName());

            Element vmsQuery = (Element) soapenvBody.getElementsByTagName("vms:query").item(0);
            System.out.println(vmsQuery.getTagName());

            Element vmsService =  (Element) vmsQuery.getElementsByTagName("vms:Service").item(0);

            System.out.println(vmsService.getNodeValue());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
