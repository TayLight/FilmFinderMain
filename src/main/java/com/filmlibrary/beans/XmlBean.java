package com.filmlibrary.beans;

import com.filmlibrary.Criterion;
import com.filmlibrary.entities.EntityDB;
import com.filmlibrary.entities.Person;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.util.LinkedList;

public interface XmlBean {

    void createXML(LinkedList<Criterion> criteria, LinkedList<EntityDB> entity) throws ParserConfigurationException, TransformerException;

    void importXML(File xml);
}
