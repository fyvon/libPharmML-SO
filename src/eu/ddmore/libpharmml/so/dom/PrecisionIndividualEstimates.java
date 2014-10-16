//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.10.16 at 04:24:00 PM BST 
//


package eu.ddmore.libpharmml.so.dom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.dataset.DataSetType;


/**
 * Type defining the precision individual estimates.
 * 
 * <p>Java class for PrecisionIndividualEstimatesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PrecisionIndividualEstimatesType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="PosteriorDistributionIndividualEstimates" type="{http://www.pharmml.org/2013/08/Dataset}DataSetType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrecisionIndividualEstimatesType", propOrder = {
    "posteriorDistributionIndividualEstimates"
})
public class PrecisionIndividualEstimates
    extends PharmMLRootType
{

    @XmlElement(name = "PosteriorDistributionIndividualEstimates")
    protected DataSetType posteriorDistributionIndividualEstimates;

    /**
     * Gets the value of the posteriorDistributionIndividualEstimates property.
     * 
     * @return
     *     possible object is
     *     {@link DataSetType }
     *     
     */
    public DataSetType getPosteriorDistributionIndividualEstimates() {
        return posteriorDistributionIndividualEstimates;
    }

    /**
     * Sets the value of the posteriorDistributionIndividualEstimates property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataSetType }
     *     
     */
    public void setPosteriorDistributionIndividualEstimates(DataSetType value) {
        this.posteriorDistributionIndividualEstimates = value;
    }

}
