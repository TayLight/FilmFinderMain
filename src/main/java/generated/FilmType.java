
package generated;

import com.filmlibrary.entities.EntityDB;
import com.filmlibrary.entities.Film;
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
import javax.persistence.criteria.CriteriaBuilder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for filmType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="filmType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="filmId" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="issueYear" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="imdb" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="length" type="{http://www.w3.org/2001/XMLSchema}integer"/>
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
@XmlType(name = "filmType", namespace = "http://foobar.com", propOrder = {
    "filmId",
    "title",
    "issueYear",
    "imdb",
    "length",
    "table",
    "countColumns",
    "columns"
})
public class FilmType implements EntityXml {

    @XmlElement(namespace = "http://foobar.com", required = true)
    protected BigInteger filmId;
    @XmlElement(namespace = "http://foobar.com", required = true)
    protected String title;
    @XmlElement(namespace = "http://foobar.com", required = true)
    protected BigInteger issueYear;
    @XmlElement(namespace = "http://foobar.com")
    protected double imdb;
    @XmlElement(namespace = "http://foobar.com", required = true)
    protected BigInteger length;
    @XmlElement(namespace = "http://foobar.com", required = true)
    protected String table;
    @XmlElement(namespace = "http://foobar.com", required = true)
    protected BigInteger countColumns;
    @XmlElement(namespace = "http://foobar.com", required = true)
    protected ColumnsType columns;

    /**
     * Gets the value of the filmId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFilmId() {
        return filmId;
    }

    /**
     * Sets the value of the filmId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFilmId(BigInteger value) {
        this.filmId = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the issueYear property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIssueYear() {
        return issueYear;
    }

    /**
     * Sets the value of the issueYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIssueYear(BigInteger value) {
        this.issueYear = value;
    }

    /**
     * Gets the value of the imdb property.
     * 
     */
    public double getImdb() {
        return imdb;
    }

    /**
     * Sets the value of the imdb property.
     * 
     */
    public void setImdb(double value) {
        this.imdb = value;
    }

    /**
     * Gets the value of the length property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLength() {
        return length;
    }

    /**
     * Sets the value of the length property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLength(BigInteger value) {
        this.length = value;
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

    public EntityXml getEntity(ResultSet resultSet) {
        EntityFactory ef = new EntityFactory();
        FilmType film = ef.createFilm();
        try {
            film.setFilmId(BigInteger.valueOf(resultSet.getInt("id_film")));
            film.setTitle(resultSet.getString("title"));
            film.setIssueYear(BigInteger.valueOf(resultSet.getInt("issue_year")));
            film.setImdb(resultSet.getInt("imdb"));
            film.setLength(BigInteger.valueOf(resultSet.getInt("length")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return film;
    }

    public PreparedStatement setDataAdd(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, title);
        preparedStatement.setInt(2, Integer.parseInt(String.valueOf(issueYear)));
        preparedStatement.setDouble(3, imdb);
        preparedStatement.setInt(4, Integer.parseInt(String.valueOf(length)));
        return preparedStatement;
    }

    @Override
    public PreparedStatement setDataUpdate(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, title);
        preparedStatement.setInt(2, Integer.parseInt(String.valueOf(issueYear)));
        preparedStatement.setDouble(3, imdb);
        preparedStatement.setInt(4, Integer.parseInt(String.valueOf(length)));
        preparedStatement.setInt(5, Integer.parseInt(String.valueOf(filmId)));
        return preparedStatement;
    }

    @Override
    public void setArray(List<EntityXml> entity) {

    }

}
