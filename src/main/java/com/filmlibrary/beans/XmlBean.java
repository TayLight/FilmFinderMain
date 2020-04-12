package com.filmlibrary.beans;

import com.filmlibrary.Criterion;
import com.filmlibrary.entities.Person;

import java.io.File;
import java.util.LinkedList;

public interface XmlBean {

    void createXML(LinkedList<Criterion> criteria, LinkedList<Person> peoples);

    void importXML(File xml);
}
