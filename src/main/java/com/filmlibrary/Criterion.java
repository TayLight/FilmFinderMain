package com.filmlibrary;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Criterion {

    private String criterion;
    private String value;

    public Criterion(String criterion, String value) {
        this.criterion = criterion;
        this.value = value;
    }

    public String getCriterion() {
        return criterion;
    }

    public void setCriterion(String criterion) {
        this.criterion = criterion;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static void main(String[] args) {
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = null;
        try (FileWriter fileWriter = new FileWriter("myoutput.xml")) {
            writer = factory.createXMLStreamWriter(fileWriter);
            writer.writeStartDocument();
            writer.writeStartElement("mydocument");

            writer.writeStartElement("myelement");
            writer.writeCharacters("myvalue");
            writer.writeEndElement();

            writer.writeStartElement("myelement2");
            writer.writeCData("MyCData<#@*&H(@N(#B(UBNOW#PUN$:JKNU ");
            writer.writeEndElement();

            writer.writeEndElement();
            writer.writeEndDocument();

            writer.flush();
            writer.close();
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
    }
}
