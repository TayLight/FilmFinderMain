package com.filmlibrary.beans;

import com.filmlibrary.Criterion;
import com.filmlibrary.entities.EntityDB;
import com.filmlibrary.entities.Person;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.ejb.Stateless;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.time.LocalDate;
import java.util.LinkedList;

@Stateless
public class PersonXmlBean implements XmlBean {

    @Override
    public void createXML(LinkedList<Criterion> criteria, LinkedList<EntityDB> peoples) throws ParserConfigurationException, TransformerException {
        LinkedList<Person> newPeople = new LinkedList<>();
        for (EntityDB entity : peoples) {
            for (Criterion criterion : criteria) {
                Person people = (Person) entity;
                switch (criterion.getCriterion()) {
                    case ("id"):
                        if (people.getId() == Integer.parseInt(criterion.getValue()))
                            newPeople.addLast(people);
                    case ("firstName"):
                        if (people.getFirstName().equals(criterion.getValue()))
                            newPeople.addLast(people);
                    case ("lastName"):
                        if (people.getLastName().equals(criterion.getValue()))
                            newPeople.addLast(people);
                    case ("birthday"):
                        if (people.getBirthday().toString().equals(criterion.getValue()))
                            newPeople.addLast(people);
                    case ("country"):
                        if (people.getCountry().equals(criterion.getValue()))
                            newPeople.addLast(people);
                }
            }
        }
        //TODO: тут преобразование списка в xml
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        Document doc = factory.newDocumentBuilder().newDocument();
        Element root = doc.createElement("persons");
       // root.setAttribute("type", "Person");
        root.getAttributeNode("Person");
        doc.appendChild(root);
        File file = new File("src//main//java//com//filmlibrary//beans//xml//test.xml");

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(doc), new StreamResult(file));
    }

    @Override
    public void importXML(File xml) {

    }

    public static void main(String[] arg) throws TransformerException, ParserConfigurationException {
        Criterion criterion1= new Criterion("id", "1");
        Person person = new Person(1,"Стив","Куб", LocalDate.of(2002,8,12),"США");
        LinkedList<Criterion> criteria = new LinkedList<>();
        criteria.add(criterion1);
        LinkedList<EntityDB> people = new LinkedList<>();
        people.add(person);
        PersonXmlBean personXmlBean = new PersonXmlBean();
        personXmlBean.createXML(criteria,people);
    }
}
