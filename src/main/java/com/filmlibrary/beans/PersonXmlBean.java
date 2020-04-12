package com.filmlibrary.beans;

import com.filmlibrary.Criterion;
import com.filmlibrary.entities.Person;

import javax.ejb.Stateless;
import java.io.File;
import java.time.LocalDate;
import java.util.LinkedList;

@Stateless
public class PersonXmlBean implements XmlBean {

    @Override
    public void createXML(LinkedList<Criterion> criteria, LinkedList<Person> peoples) {
        LinkedList<Person> newPeople = new LinkedList<>();
        for (Person people : peoples) {
            for (Criterion criterion : criteria) {
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
    }

    @Override
    public void importXML(File xml) {

    }
}
