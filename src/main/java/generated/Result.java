
package generated;

import com.filmlibrary.entities.Person;
import com.filmlibrary.entities.Serial;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="code" type="{http://foobar.com}codeType"/>
 *         &lt;choice>
 *           &lt;element name="persons" type="{http://foobar.com}personListType" minOccurs="0"/>
 *           &lt;element name="films" type="{http://foobar.com}filmListType" minOccurs="0"/>
 *           &lt;element name="serials" type="{http://foobar.com}serialListType" minOccurs="0"/>
 *           &lt;element name="person" type="{http://foobar.com}personType" minOccurs="0"/>
 *           &lt;element name="serial" type="{http://foobar.com}serialType" minOccurs="0"/>
 *           &lt;element name="film" type="{http://foobar.com}filmType" minOccurs="0"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "code",
    "persons",
    "films",
    "serials",
    "person",
    "serial",
    "film"
})
@XmlRootElement(name = "result", namespace = "http://foobar.com")
public class Result implements EntityXml {

    @XmlElement(namespace = "http://foobar.com", required = true)
    @XmlSchemaType(name = "string")
    protected CodeType code;
    @XmlElement(namespace = "http://foobar.com")
    protected PersonListType persons;
    @XmlElement(namespace = "http://foobar.com")
    protected FilmListType films;
    @XmlElement(namespace = "http://foobar.com")
    protected SerialListType serials;
    @XmlElement(namespace = "http://foobar.com")
    protected PersonType person;
    @XmlElement(namespace = "http://foobar.com")
    protected SerialType serial;
    @XmlElement(namespace = "http://foobar.com")
    protected FilmType film;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setCode(CodeType value) {
        this.code = value;
    }

    /**
     * Gets the value of the persons property.
     * 
     * @return
     *     possible object is
     *     {@link PersonListType }
     *     
     */
    public PersonListType getPersons() {
        return persons;
    }

    /**
     * Sets the value of the persons property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonListType }
     *     
     */
    public void setPersons(PersonListType value) {
        this.persons = value;
    }

    /**
     * Gets the value of the films property.
     * 
     * @return
     *     possible object is
     *     {@link FilmListType }
     *     
     */
    public FilmListType getFilms() {
        return films;
    }

    /**
     * Sets the value of the films property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilmListType }
     *     
     */
    public void setFilms(FilmListType value) {
        this.films = value;
    }

    /**
     * Gets the value of the serials property.
     * 
     * @return
     *     possible object is
     *     {@link SerialListType }
     *     
     */
    public SerialListType getSerials() {
        return serials;
    }

    public void setEntity(EntityXml entity){
        if (FilmType.class.equals(entity.getClass())) {
            FilmType filmType = (FilmType) entity;
            setFilm(filmType);
        }
        else if(SerialType.class.equals(entity.getClass())){
            SerialType serialType = (SerialType) entity;
            setSerial(serialType);
        }
        else if(PersonType.class.equals(entity.getClass())){
            PersonType personType = (PersonType) entity;
            setPerson(personType);
        }
        else if(FilmListType.class.equals(entity.getClass())){
            FilmListType filmListType = (FilmListType) entity;
            setFilms(filmListType);
        }
        else if(SerialListType.class.equals(entity.getClass())){
            SerialListType serialListType = (SerialListType) entity;
            setSerials(serialListType);
        }
        else if(PersonListType.class.equals(entity.getClass())){
            PersonListType personListType = (PersonListType) entity;
            setPersons(personListType);
        }
    }

    /**
     * Sets the value of the serials property.
     * 
     * @param value
     *     allowed object is
     *     {@link SerialListType }
     *     
     */
    public void setSerials(SerialListType value) {
        this.serials = value;
    }

    /**
     * Gets the value of the person property.
     * 
     * @return
     *     possible object is
     *     {@link PersonType }
     *     
     */
    public PersonType getPerson() {
        return person;
    }

    /**
     * Sets the value of the person property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonType }
     *     
     */
    public void setPerson(PersonType value) {
        this.person = value;
    }

    /**
     * Gets the value of the serial property.
     * 
     * @return
     *     possible object is
     *     {@link SerialType }
     *     
     */
    public SerialType getSerial() {
        return serial;
    }

    /**
     * Sets the value of the serial property.
     * 
     * @param value
     *     allowed object is
     *     {@link SerialType }
     *     
     */
    public void setSerial(SerialType value) {
        this.serial = value;
    }

    /**
     * Gets the value of the film property.
     * 
     * @return
     *     possible object is
     *     {@link FilmType }
     *     
     */
    public FilmType getFilm() {
        return film;
    }

    /**
     * Sets the value of the film property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilmType }
     *     
     */
    public void setFilm(FilmType value) {
        this.film = value;
    }

    @Override
    public String getTable() {
        return null;
    }

    @Override
    public BigInteger getCountColumns() {
        return null;
    }

    @Override
    public ColumnsType getColumns() {
        return null;
    }

    @Override
    public EntityXml getEntity(ResultSet resultSet) {
        return null;
    }

    @Override
    public void setArray(List<EntityXml> entity) {

    }
}
