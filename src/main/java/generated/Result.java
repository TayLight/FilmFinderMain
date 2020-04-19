
package generated;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


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
 *           &lt;element name="personList" type="{http://foobar.com}personListType" minOccurs="0"/>
 *           &lt;element name="person" type="{http://foobar.com}personType" minOccurs="0"/>
 *           &lt;element name="personId" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
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
    "personList",
    "person",
    "personId"
})
@XmlRootElement(name = "result", namespace = "http://foobar.com")
public class Result {

    @XmlElement(namespace = "http://foobar.com", required = true)
    @XmlSchemaType(name = "string")
    protected CodeType code;
    @XmlElement(namespace = "http://foobar.com")
    protected PersonListType personList;
    @XmlElement(namespace = "http://foobar.com")
    protected PersonType person;
    @XmlElement(namespace = "http://foobar.com")
    protected BigInteger personId;

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
     * Gets the value of the personList property.
     * 
     * @return
     *     possible object is
     *     {@link PersonListType }
     *     
     */
    public PersonListType getPersonList() {
        return personList;
    }

    /**
     * Sets the value of the personList property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonListType }
     *     
     */
    public void setPersonList(PersonListType value) {
        this.personList = value;
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

}
