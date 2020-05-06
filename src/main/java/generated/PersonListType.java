
package generated;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for personListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="personListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="person" type="{http://foobar.com}personType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "personListType", namespace = "http://foobar.com", propOrder = {
    "person"
})
public class PersonListType implements EntityXml {

    @XmlElement(namespace = "http://foobar.com", required = true)
    protected List<PersonType> person;

    /**
     * Gets the value of the person property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the person property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPerson().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonType }
     * 
     * 
     */
    public List<PersonType> getPerson() {
        if (person == null) {
            person = new ArrayList<PersonType>();
        }
        return this.person;
    }

    public void setArray(List<EntityXml> entityXml) {
        this.person = new ArrayList<>();
        for (EntityXml entity : entityXml) {
            this.person.add((PersonType) entity);
        }
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
    public PreparedStatement setDataAdd(PreparedStatement preparedStatement) throws SQLException {
        return null;
    }

    @Override
    public PreparedStatement setDataUpdate(PreparedStatement preparedStatement) throws SQLException {
        return null;
    }

    @Override
    public EntityXml getEntity(ResultSet resultSet) {
        return null;
    }
}
