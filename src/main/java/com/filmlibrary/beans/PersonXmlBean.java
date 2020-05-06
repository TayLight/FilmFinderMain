package com.filmlibrary.beans;
import criteriongenerated.Criterion;
import criteriongenerated.CriterionListType;
import criteriongenerated.ObjectCriterion;
import generated.CodeType;
import generated.EntityFactory;
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

    public Result fromXmlToObject(File file) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Result.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            if(!checkEntityXMLforXSD(file)) throw new SAXException();
            return (Result) un.unmarshal(file);
        } catch (JAXBException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public File convertEntityToXml(EntityXml entity) {
        try {
            File fileXml = new File(pathToXmlEntity);
            Result result = new Result();
            result.setEntity(entity);
            result.setCode(CodeType.OK);
            JAXBContext context = JAXBContext.newInstance(Result.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(result, fileXml);
            return fileXml;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }


    private boolean checkEntityXMLforXSD(File file) throws IOException, SAXException {

        File xsd = new File(pathToXsdEntity);

        if (!xsd.exists()) {
            System.out.println("Не найден XSD " + pathToXsdEntity);
        }

        if (!file.exists() || !xsd.exists()) {
            return false;
        }

        SchemaFactory factory = SchemaFactory
                .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); //Инициализация состояния
        Schema schema = factory.newSchema(new StreamSource(pathToXsdEntity));  //Загружаем нашу схему xsd
        Validator validator = schema.newValidator();       //создаем валидатор
        validator.validate(new StreamSource(file));       //Проверяем, если что то не так прокинет ошибку
        return true;
    }

    private boolean checkCriterionXMLforXSD(File file) throws IOException, SAXException {

        File xsd = new File(pathToXsdCriterion);

        if (!xsd.exists()) {
            System.out.println("Не найден XSD " + pathToXsdCriterion);
        }

        if (!file.exists() || !xsd.exists()) {
            return false;
        }

        SchemaFactory factory = SchemaFactory
                .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); //Инициализация состояния
        Schema schema = factory.newSchema(new StreamSource(pathToXsdCriterion));  //Загружаем нашу схему xsd
        Validator validator = schema.newValidator();       //создаем валидатор
        validator.validate(new StreamSource(file));       //Проверяем, если что то не так прокинет ошибку
        return true;
    }

    public ObjectCriterion fromXmlToCriterion(File file) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ObjectCriterion.class);
            if(!checkCriterionXMLforXSD(file)) throw new SAXException();
            Unmarshaller un = jaxbContext.createUnmarshaller();
            return (ObjectCriterion) un.unmarshal(file);
        } catch (JAXBException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return null;
    }

    public File convertCriterionToXml(List<Criterion> criterionList, String type) {
        try {
            CriterionListType criterionListType = new CriterionListType();
            File xmlFile = new File(pathToXmlCriterion);
            criterionListType.setPerson(criterionList);
            ObjectCriterion objectCriterion = new ObjectCriterion();
            objectCriterion.setType(type);
            objectCriterion.setCriterions(criterionListType);
            JAXBContext context = JAXBContext.newInstance(ObjectCriterion.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(objectCriterion, xmlFile);
            return xmlFile;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
