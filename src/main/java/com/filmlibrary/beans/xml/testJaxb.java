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
import java.util.LinkedList;
import java.util.List;


/**
 * Тестовый бин, для конвертации объектов из xml и наоборот
 */
public class testJaxb {
    /**
     * Адрес файла с xml
     */
    private static String filePath = "test.xml";
    /**
     * Адрес файла xsd, по которому будет проходить проверку xml
     */
    private static String filePathXsd = "src\\main\\java\\com\\filmlibrary\\beans\\xml\\entity.xsd";

    public static void main(String[] arg) throws DatatypeConfigurationException {
        EntityFactory ef = new EntityFactory();
        ObjectFactory of = new ObjectFactory();
        PersonType person = ef      //создаем типы через фабрику, чтобы каждый раз не задавать колонки, их количество итп
                .createPerson(1,"Иван","Петров", LocalDate.now(),"США");
                //заносим в оболочку result объект
        convertObjectToXml(person,filePath);
        Result personType = fromXmlToObject(filePath);
        assert personType != null;
        System.out.println(personType.getPerson().getFirstName());
        PersonType personType1 = ef
                .createPerson(2,"Петр","Иванов",LocalDate.now(),"Россия");
        LinkedList<PersonType> types = new LinkedList<>();
        types.add(personType1);
        types.add(person);
        PersonListType personListType = of.createPersonListType();
        personListType.setPerson(types);
        convertObjectToXml(personListType,filePath);
        Result result = fromXmlToObject(filePath);
        personListType=result.getPersons();
        System.out.println(personListType.getPerson().get(0).getFirstName());
    }

    private static Result fromXmlToObject(String filePath) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Result.class); //Инициализация контекста, где указываем наш корневой элемент в xml
            Unmarshaller un = jaxbContext.createUnmarshaller();//Unmarshaller аналог парсера у JSON
            checkXMLforXSD(filePath,filePathXsd); //Проверяем правильность xml
            return (Result) un.unmarshal(new File(filePath));      //Umarshaller распарсивает
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Ошибка потоков");
            e.printStackTrace();
        } catch (SAXException e) {
            System.out.println("Ошибка валидации");       // будет выкидываться если в xml, что то неправильно вбито
            e.printStackTrace();
        }
        return null;
    }

    private static void convertObjectToXml(EntityXml entityXML, String filePath) {
        try {
            Result result = new Result();
            result.setCode(CodeType.OK);
            result.setEntity(entityXML);
            JAXBContext context = JAXBContext.newInstance(Result.class); //Тут все так же
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); //Не до конца понимаю

            marshaller.marshal(result, new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkXMLforXSD(String pathXml, String pathXsd) throws IOException, SAXException {

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
