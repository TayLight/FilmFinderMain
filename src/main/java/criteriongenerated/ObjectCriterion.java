
package criteriongenerated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


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
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="criterions" type="{http://foobar.com}criterionListType"/>
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
    "type",
    "criterions"
})
@XmlRootElement(name = "objectCriterion", namespace = "http://foobar.com")
public class ObjectCriterion  implements Serializable {

    @XmlElement(namespace = "http://foobar.com", required = true)
    protected String type;
    @XmlElement(namespace = "http://foobar.com", required = true)
    protected CriterionListType criterions;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the criterions property.
     * 
     * @return
     *     possible object is
     *     {@link CriterionListType }
     *     
     */
    public CriterionListType getCriterions() {
        return criterions;
    }

    /**
     * Sets the value of the criterions property.
     * 
     * @param value
     *     allowed object is
     *     {@link CriterionListType }
     *     
     */
    public void setCriterions(CriterionListType value) {
        this.criterions = value;
    }

}
