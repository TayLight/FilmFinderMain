
package generated;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for serialType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="serialType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="serialId" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yearStart" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="yearFinish" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="numEpisodes" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numSeasons" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="imdb" type="{http://www.w3.org/2001/XMLSchema}double"/>
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
@XmlType(name = "serialType", namespace = "http://foobar.com", propOrder = {
    "serialId",
    "title",
    "yearStart",
    "yearFinish",
    "numEpisodes",
    "numSeasons",
    "imdb",
    "table",
    "countColumns",
    "columns"
})
public class SerialType {

    @XmlElement(namespace = "http://foobar.com", required = true)
    protected BigInteger serialId;
    @XmlElement(namespace = "http://foobar.com", required = true)
    protected String title;
    @XmlElement(namespace = "http://foobar.com", required = true)
    protected BigInteger yearStart;
    @XmlElement(namespace = "http://foobar.com", required = true)
    protected BigInteger yearFinish;
    @XmlElement(namespace = "http://foobar.com", required = true)
    protected String numEpisodes;
    @XmlElement(namespace = "http://foobar.com", required = true)
    protected String numSeasons;
    @XmlElement(namespace = "http://foobar.com")
    protected double imdb;
    @XmlElement(namespace = "http://foobar.com", required = true)
    protected String table;
    @XmlElement(namespace = "http://foobar.com", required = true)
    protected BigInteger countColumns;
    @XmlElement(namespace = "http://foobar.com", required = true)
    protected ColumnsType columns;

    /**
     * Gets the value of the serialId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSerialId() {
        return serialId;
    }

    /**
     * Sets the value of the serialId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSerialId(BigInteger value) {
        this.serialId = value;
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
     * Gets the value of the yearStart property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getYearStart() {
        return yearStart;
    }

    /**
     * Sets the value of the yearStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setYearStart(BigInteger value) {
        this.yearStart = value;
    }

    /**
     * Gets the value of the yearFinish property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getYearFinish() {
        return yearFinish;
    }

    /**
     * Sets the value of the yearFinish property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setYearFinish(BigInteger value) {
        this.yearFinish = value;
    }

    /**
     * Gets the value of the numEpisodes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumEpisodes() {
        return numEpisodes;
    }

    /**
     * Sets the value of the numEpisodes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumEpisodes(String value) {
        this.numEpisodes = value;
    }

    /**
     * Gets the value of the numSeasons property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumSeasons() {
        return numSeasons;
    }

    /**
     * Sets the value of the numSeasons property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumSeasons(String value) {
        this.numSeasons = value;
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

}
