package generated;

import com.filmlibrary.entities.Serial;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;

public class EntityFactory {
    String personTable = "person";

    public PersonType createPerson(int id, String firstName, String secondName, LocalDate birtday, String country){
        try {
            PersonType person = new PersonType();
            XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar();
            xmlGregorianCalendar.setYear(birtday.getYear());
            xmlGregorianCalendar.setMonth(birtday.getMonthValue());
            xmlGregorianCalendar.setDay(birtday.getDayOfMonth());
            person.setPersonId(BigInteger.valueOf(id));
            person.setFirstName(firstName);
            person.setSecondName(secondName);
            person.setBirthday(xmlGregorianCalendar);
            person.setCountry(country);
            person.setTable(personTable);
            person.setCountColumns(BigInteger.valueOf(5));
            person.setColumns(insertColumnsPerson());
            return person;
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public PersonType createPerson(){
        PersonType person = new PersonType();
        person.setTable("person");
        person.setCountColumns(BigInteger.valueOf(5));
        person.setColumns(insertColumnsPerson());
        return person;
    }

    public FilmType createFilm(int id, String title, int issueYear, double imdb, int length){
        FilmType filmType = new FilmType();
        filmType.setTitle(title);
        filmType.setFilmId(BigInteger.valueOf(id));
        filmType.setIssueYear(BigInteger.valueOf(issueYear));
        filmType.setImdb(imdb);
        filmType.setLength(BigInteger.valueOf(length));
        filmType.setTable("film");
        filmType.setCountColumns(BigInteger.valueOf(5));
        filmType.setColumns(insertColumnsFilm());
        return filmType;
    }

    public FilmType createFilm(){
        FilmType filmType = new FilmType();
        filmType.setTable("film");
        filmType.setCountColumns(BigInteger.valueOf(5));
        filmType.setColumns(insertColumnsFilm());
        return filmType;
    }

    public SerialType createSerial(int id, String title, int yearStart, int yearFinish, int numEpisodes, int numSeasons, double imdb){
        SerialType serialType = new SerialType();
        serialType.setSerialId(BigInteger.valueOf(id));
        serialType.setTitle(title);
        serialType.setYearStart(BigInteger.valueOf(yearStart));
        serialType.setYearFinish(BigInteger.valueOf(yearFinish));
        serialType.setNumEpisodes(BigInteger.valueOf(numEpisodes));
        serialType.setNumSeasons(BigInteger.valueOf(numSeasons));
        serialType.setImdb(imdb);
        serialType.setTable("serial");
        serialType.setCountColumns(BigInteger.valueOf(7));
        serialType.setColumns(insertColumnsSerial());
        return serialType;
    }

    public SerialType createSerial(){
        SerialType serialType = new SerialType();
        serialType.setTable("serial");
        serialType.setCountColumns(BigInteger.valueOf(7));
        serialType.setColumns(insertColumnsSerial());
        return serialType;
    }

    private ColumnsType insertColumnsFilm(){
        ArrayList<String> columns = new ArrayList<>();
        columns.add("id_film");
        columns.add("title");
        columns.add("issue_year");
        columns.add("imdb");
        columns.add("length");
        ColumnsType columnsType =new ColumnsType();
        columnsType.setColumn(columns);
        return columnsType;
    }

    private ColumnsType insertColumnsPerson(){
        ArrayList<String> columns = new ArrayList<>();
        columns.add("id_person");
        columns.add("first_name");
        columns.add("second_name");
        columns.add("birthday");
        columns.add("country");
        ColumnsType columnsType =new ColumnsType();
        columnsType.setColumn(columns);
        return columnsType;
    }

    private ColumnsType insertColumnsSerial(){
        ArrayList<String> columns = new ArrayList<>();
        columns.add("id_serial");
        columns.add("title");
        columns.add("year_start");
        columns.add("year_finish");
        columns.add("num_of_episodes");
        columns.add("num_of_seasons");
        columns.add("imdb");
        ColumnsType columnsType =new ColumnsType();
        columnsType.setColumn(columns);
        return columnsType;
    }
}
