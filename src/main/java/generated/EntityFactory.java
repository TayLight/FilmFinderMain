package generated;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;

public class EntityFactory {
    String personTable = "person";
    ArrayList<String> columnsPerson = new ArrayList<>();
    {
        columnsPerson.add("id");
        columnsPerson.add("firstName");
        columnsPerson.add("secondName");
        columnsPerson.add("birthday");
        columnsPerson.add("Country");
    }

    public PersonType createPerson(int id, String firstName, String secondName, LocalDate birtday, String country){
        try {
            PersonType person = new PersonType();
            XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar();
            ColumnsType columnsType = new ColumnsType();
            xmlGregorianCalendar.setYear(birtday.getYear());
            xmlGregorianCalendar.setMonth(birtday.getMonthValue());
            xmlGregorianCalendar.setDay(birtday.getDayOfMonth());
            person.setPersonId(BigInteger.valueOf(id));
            person.setFirstName(firstName);
            person.setSecondName(secondName);
            person.setBirthday(xmlGregorianCalendar);
            person.setCountry(country);
            person.setTable(personTable);
            person.setCountColumns(BigInteger.valueOf(columnsPerson.size()));
            columnsType.setColumn(columnsPerson);
            person.setColumns(columnsType);
            return person;
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
