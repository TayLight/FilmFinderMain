package com.filmlibrary.beans.xml;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import generated.*;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import java.io.File;

import java.io.IOException;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

public class testJaxb {
    private static String filePath = "test.xml";
    private static String filePathXsd = "C:\\Users\\Dogore\\Documents\\NetCracker\\MainFilmFinder\\FilmFinder\\src\\main\\java\\com\\filmlibrary\\beans\\xml\\entity.xsd";

    public static void main(String[] arg) throws DatatypeConfigurationException {
        EntityFactory ef = new EntityFactory();
        ObjectFactory of = new ObjectFactory();
        Result result = of.createResult();
        result.setCode(CodeType.OK);
        PersonType person = ef
                .createPerson(1,"Иван","Петров", LocalDate.now(),"США");
        result.setPerson(person);
        convertObjectToXml(result,filePath);
        Result personType = fromXmlToObject(filePath);
        assert personType != null;
        System.out.println(personType.getPerson().getFirstName());
    }

    private static Result fromXmlToObject(String filePath) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Result.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            checkXMLforXSD(filePath,filePathXsd);
            return (Result) un.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Ошибка потоков");
            e.printStackTrace();
        } catch (SAXException e) {
            System.out.println("Ошибка валидации");
            e.printStackTrace();
        }
        return null;
    }

    private static void convertObjectToXml(Result person, String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(Result.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.marshal(person, new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkXMLforXSD(String pathXml, String pathXsd) throws IOException, SAXException {

        File xml = new File(pathXml);
        File xsd = new File(pathXsd);

        if (!xml.exists()) {
            System.out.println("Не найден XML " + pathXml);
        }

        if (!xsd.exists()) {
            System.out.println("Не найден XSD " + pathXsd);
        }

        if (!xml.exists() || !xsd.exists()) {
            return false;
        }

        SchemaFactory factory = SchemaFactory
                .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(new StreamSource(pathXsd));
        Validator validator = schema.newValidator();
        validator.validate(new StreamSource(pathXml));
        return true;

    }
}
