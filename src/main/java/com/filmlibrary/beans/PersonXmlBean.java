package com.filmlibrary.beans;
import generated.Result;
import org.xml.sax.SAXException;

import javax.ejb.Stateless;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

@Stateless
public class PersonXmlBean implements XmlBean  {

    public Result fromXmlToObject(String filePath) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Result.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            return (Result) un.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void convertObjectToXml(Result result, String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(Result.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(result, new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    private static boolean checkXMLforXSD(String pathXml, String pathXsd) throws IOException, SAXException {

        File xml = new File(pathXml);
        File xsd = new File(pathXsd);

        if (!xml.exists()) {
            System.out.println("Не найден XML " + pathXml);      //Проверяем на существование путей
        }

        if (!xsd.exists()) {
            System.out.println("Не найден XSD " + pathXsd);
        }

        if (!xml.exists() || !xsd.exists()) {
            return false;
        }

        SchemaFactory factory = SchemaFactory
                .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); //Инициализация состояния
        Schema schema = factory.newSchema(new StreamSource(pathXsd));  //Загружаем нашу схему xsd
        Validator validator = schema.newValidator();       //создаем валидатор
        validator.validate(new StreamSource(pathXml));       //Проверяем, если что то не так прокинет ошибку
        return true;

    }
}
