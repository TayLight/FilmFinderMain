
package generated;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for filmListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="filmListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="film" type="{http://foobar.com}filmType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "filmListType", namespace = "http://foobar.com", propOrder = {
    "film"
})
public class FilmListType  implements EntityXml {

    @XmlElement(namespace = "http://foobar.com", required = true)
    protected List<FilmType> film;

    /**
     * Gets the value of the film property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the film property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFilm().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FilmType }
     * 
     * 
     */
    public List<FilmType> getFilm() {
        if (film == null) {
            film = new ArrayList<FilmType>();
        }
        return this.film;
    }

    public void setArray(List<EntityXml> entityXml){
        film = new ArrayList<>();
        for (EntityXml entity: entityXml) {
            film.add((FilmType) entity);
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
    public EntityXml getEntity(ResultSet resultSet) {
        return null;
    }
}
