package com.filmlibrary.beans;

import com.filmlibrary.DAO;
import criteriongenerated.Criterion;
import criteriongenerated.CriterionListType;
import criteriongenerated.ObjectCriterion;
import generated.*;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.ejb.Stateless;
import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

@Stateless
public class PersonXmlBean implements XmlBean {
    private static String pathToXmlEntity = "src\\main\\webapp\\WEB-INF\\entity.xml";
    private static String pathToXmlCriterion = "src\\main\\webapp\\WEB-INF\\criterion.xml";
    private static String pathToXsdCriterion = "src\\main\\java\\criteriongenerated\\criterion.xsd";
    private static String pathToXsdEntity = "src\\main\\java\\generated\\entity.xsd";

    public Result fromXmlFileToEntity(File file) {
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

    public File convertEntityToXmlFile(Result result) {
        try {
            File fileXml = new File(pathToXmlEntity);
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

    public ObjectCriterion fromXmlFileToCriterion(File file) {
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

    public File convertCriterionToXmlFile(ObjectCriterion objectCriterion) {
        try {
            File xmlFile = new File(pathToXmlCriterion);
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

    public Document convertCriterionToNode(ObjectCriterion objectCriterion){
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            JAXBContext context = JAXBContext.newInstance(ObjectCriterion.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(objectCriterion,doc);
            return doc;
        } catch (JAXBException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ObjectCriterion fromNodeToCriterion(Document doc){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ObjectCriterion.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            return (ObjectCriterion) un.unmarshal(doc);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Result fromXmlNodeToEntity(Document doc) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Result.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            return (Result) un.unmarshal(doc);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Document convertEntityToNode(Result result) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            JAXBContext context = JAXBContext.newInstance(Result.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(result, doc);
            return doc;
        } catch (JAXBException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void  main(String[] arg){
       /* PersonXmlBean personXmlBean = new PersonXmlBean();
        Result result = new Result();
        EntityFactory ef = new EntityFactory();
        PersonType pt = ef.createPerson(1,"Иван", "Васильевич", LocalDate.now(),"Russian");
        LinkedList<EntityXml> personTypes = new LinkedList<>();
        personTypes.add(pt);
        PersonListType personListType = new PersonListType();
        personListType.setArray(personTypes);
        result.setPersons(personListType);
        personXmlBean.convertEntityToXmlFile(result);

        */
       PersonXmlBean personXmlBean = new PersonXmlBean();
       Criterion criterion = new Criterion();
       criterion.setNameCriterion("country");
       criterion.setValue("США");
       LinkedList<Criterion> criteria = new LinkedList<>();
       criteria.add(criterion);
        DAO dao = new DAO();
        ObjectCriterion objectCriterion = new ObjectCriterion();
        CriterionListType criterionListType = new CriterionListType();
        criterionListType.setPerson(criteria);
        objectCriterion.setCriterions(criterionListType);
        objectCriterion.setType("person");
        Document document= dao.searchEntityByCriterion(personXmlBean.convertCriterionToNode(objectCriterion));
        Result result = personXmlBean.fromXmlNodeToEntity(document);
        personXmlBean.convertEntityToXmlFile(result);
    }
}
