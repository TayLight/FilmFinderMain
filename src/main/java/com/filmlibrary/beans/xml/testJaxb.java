package com.filmlibrary.beans.xml;

import generated.PersonType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import java.io.File;

import java.math.BigInteger;

public class testJaxb {
    private static String filePath = "test.xml";

    public static void main(String[] arg) throws DatatypeConfigurationException {
        XMLGregorianCalendar birtday = DatatypeFactory.newInstance().newXMLGregorianCalendar();
        birtday.setYear(2020);
        birtday.setMonth(5);
        birtday.setDay(22);
        PersonType person = new PersonType();
        person.setFirstName("Мэттью");
        person.setSecondName("МакКонахи");
        person.setBirthday(birtday);
        person.setPersonId(BigInteger.valueOf(1));
        person.setCountry("Ирландия");
        convertObjectToXml(person,filePath);
    }

    private static PersonType fromXmlToObject(String filePath) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(PersonType.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            return (PersonType) un.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void convertObjectToXml(PersonType person, String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(PersonType.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(person, new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
