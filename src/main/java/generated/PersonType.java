
package generated;

import com.filmlibrary.entities.EntityDB;
import com.filmlibrary.entities.Person;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for personType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="personType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="personId" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="secondName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="birthday" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="table" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="countColumns" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="columns" type="{http://foobar.com}columnsType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "personType", namespace = "http://foobar.com", propOrder = {
    "personId",
    "firstName",
    "secondName",
    "birthday",
    "country",
    "table",
    "countColumns",
    "columns"
})
public class PersonType implements EntityXml {

    @XmlElement(namespace = "http://foobar.com", required = true)
    protected BigInteger personId;
    @XmlElement(namespace = "http://foobar.com", required = true)
    protected String firstName;
    @XmlElement(namespace = "http://foobar.com", required = true)
    protected String secondName;
    @XmlElement(namespace = "http://foobar.com", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar birthday;
    @XmlElement(namespace = "http://foobar.com", required = true)
    protected String country;
    @XmlElement(namespace = "http://foobar.com", required = true)
    protected String table;
    @XmlElement(namespace = "http://foobar.com", required = true)
    protected BigInteger countColumns;
    @XmlElement(namespace = "http://foobar.com", required = true)
    protected ColumnsType columns;

    /**
     * Gets the value of the personId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPersonId() {
        return personId;
    }

    /**
     * Sets the value of the personId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPersonId(BigInteger value) {
        this.personId = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the secondName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * Sets the value of the secondName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecondName(String value) {
        this.secondName = value;
    }

    /**
     * Gets the value of the birthday property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBirthday() {
        return birthday;
    }

    /**
     * Sets the value of the birthday property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBirthday(XMLGregorianCalendar value) {
        this.birthday = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the table property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTable() {
        return table;
    }

    /**
     * Sets the value of the table property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTable(String value) {
        this.table = value;
    }

    /**
     * Gets the value of the countColumns property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCountColumns() {
        return countColumns;
    }

    /**
     * Sets the value of the countColumns property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCountColumns(BigInteger value) {
        this.countColumns = value;
    }

    /**
     * Gets the value of the columns property.
     * 
     * @return
     *     possible object is
     *     {@link ColumnsType }
     *     
     */
    public ColumnsType getColumns() {
        return columns;
    }

    public EntityXml getEntity(ResultSet resultSet) {
        EntityFactory ef = new EntityFactory();
        PersonType person = ef.createPerson();
        try {
            person.setPersonId(BigInteger.valueOf(resultSet.getInt("id_person")));
            person.setFirstName(resultSet.getString("first_name"));
            person.setSecondName(resultSet.getString("second_name"));
            Date date = resultSet.getDate("birthday");
            XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar();
            LocalDate localDate = date.toLocalDate();
            xmlGregorianCalendar.setYear(localDate.getYear());
            xmlGregorianCalendar.setMonth(localDate.getMonthValue());
            xmlGregorianCalendar.setDay(localDate.getDayOfMonth());
            person.setBirthday(xmlGregorianCalendar);
            person.setCountry(resultSet.getString("country"));
        } catch (SQLException | DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        return person;
    }

    public PreparedStatement setDataAdd(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, secondName);
        preparedStatement.setDate(3, Date.valueOf(String.valueOf(birthday)));
        preparedStatement.setString(4, country);
        return preparedStatement;
    }

    @Override
    public PreparedStatement setDataUpdate(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, getFirstName());
        preparedStatement.setString(2, getSecondName());
        preparedStatement.setDate(3, Date.valueOf(getBirthday().toString()));
        preparedStatement.setString(4, getCountry());
        preparedStatement.setInt(5, Integer.parseInt(String.valueOf(getPersonId())));
        return preparedStatement;
    }

    @Override
    public void setArray(List<EntityXml> entity) {

    }

    /**
     * Sets the value of the columns property.
     * 
     * @param value
     *     allowed object is
     *     {@link ColumnsType }
     *     
     */
    public void setColumns(ColumnsType value) {
        this.columns = value;
    }

}
