package com.filmlibrary.beans;
import criteriongenerated.Criterion;
import criteriongenerated.CriterionListType;
import criteriongenerated.ObjectCriterion;
import generated.EntityXml;
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
import java.util.List;

@Stateless
public class PersonXmlBean implements XmlBean  {
    private String pathToXmlEntity = "src\\main\\java\\com\\filmlibrary\\beans\\xml\\entity.xml";
    private String pathToXmlCriterion = "src\\main\\java\\com\\filmlibrary\\beans\\xml\\criterion.xml";
    private String pathToXsdCriterion = "src\\main\\java\\com\\filmlibrary\\beans\\xml\\criterion.xsd";
    private String pathToXsdEntity = "src\\main\\java\\com\\filmlibrary\\beans\\xml\\entity.xsd";

    public Result fromXmlToObject() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Result.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            if(!checkEntityXMLforXSD(pathToXmlEntity)) throw new SAXException();
            return (Result) un.unmarshal(new File(pathToXmlEntity));
        } catch (JAXBException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void convertEntityToXml(EntityXml entity) {
        try {
            Result result = new Result();
            result.setEntity(entity);
            JAXBContext context = JAXBContext.newInstance(Result.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(result, new File(pathToXmlEntity));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    private boolean checkEntityXMLforXSD(String pathXml) throws IOException, SAXException {

        File xml = new File(pathXml);
        File xsd = new File(pathToXsdEntity);

        if (!xml.exists()) {
            System.out.println("Не найден XML " + pathXml);      //Проверяем на существование путей
        }

        if (!xsd.exists()) {
            System.out.println("Не найден XSD " + pathToXsdEntity);
        }

        if (!xml.exists() || !xsd.exists()) {
            return false;
        }

        SchemaFactory factory = SchemaFactory
                .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); //Инициализация состояния
        Schema schema = factory.newSchema(new StreamSource(pathToXsdEntity));  //Загружаем нашу схему xsd
        Validator validator = schema.newValidator();       //создаем валидатор
        validator.validate(new StreamSource(pathXml));       //Проверяем, если что то не так прокинет ошибку
        return true;
    }

    private boolean checkCriterionXMLforXSD(String pathXml) throws IOException, SAXException {

        File xml = new File(pathXml);
        File xsd = new File(pathToXsdCriterion);

        if (!xml.exists()) {
            System.out.println("Не найден XML " + pathXml);      //Проверяем на существование путей
        }

        if (!xsd.exists()) {
            System.out.println("Не найден XSD " + pathToXsdCriterion);
        }

        if (!xml.exists() || !xsd.exists()) {
            return false;
        }

        SchemaFactory factory = SchemaFactory
                .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); //Инициализация состояния
        Schema schema = factory.newSchema(new StreamSource(pathToXsdCriterion));  //Загружаем нашу схему xsd
        Validator validator = schema.newValidator();       //создаем валидатор
        validator.validate(new StreamSource(pathXml));       //Проверяем, если что то не так прокинет ошибку
        return true;
    }

    public ObjectCriterion fromXmlToCriterion() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ObjectCriterion.class);
            if(!checkCriterionXMLforXSD(pathToXmlCriterion)) throw new SAXException();
            Unmarshaller un = jaxbContext.createUnmarshaller();
            return (ObjectCriterion) un.unmarshal(new File(pathToXmlCriterion));
        } catch (JAXBException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void convertCriterionToXml(List<Criterion> criterionList, String type) {
        try {
            CriterionListType criterionListType = new CriterionListType();
            criterionListType.setPerson(criterionList);
            ObjectCriterion objectCriterion = new ObjectCriterion();
            objectCriterion.setType(type);
            objectCriterion.setCriterions(criterionListType);
            JAXBContext context = JAXBContext.newInstance(ObjectCriterion.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(objectCriterion, new File(pathToXmlCriterion));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
