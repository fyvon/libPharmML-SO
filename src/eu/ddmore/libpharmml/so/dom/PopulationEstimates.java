/*******************************************************************************
 * Copyright (c) 2014 European Molecular Biology Laboratory,
 * Heidelberg, Germany.
 *
 * Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of
 * the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on 
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY 
 * KIND, either express or implied. See the License for the 
 * specific language governing permissions and limitations 
 * under the License.
 *******************************************************************************/
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.10.17 at 04:00:02 PM BST 
//


package eu.ddmore.libpharmml.so.dom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.dataset.DataSet;


/**
 * Type defining the population estimates.
 * 
 * <p>Java class for PopulationEstimatesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PopulationEstimatesType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="MLE" type="{http://www.pharmml.org/2013/08/Dataset}DataSetType" minOccurs="0"/>
 *         &lt;element name="Bayesian" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *                 &lt;sequence>
 *                   &lt;element name="PosteriorMean" type="{http://www.pharmml.org/2013/08/Dataset}DataSetType" minOccurs="0"/>
 *                   &lt;element name="PosteriorMedian" type="{http://www.pharmml.org/2013/08/Dataset}DataSetType" minOccurs="0"/>
 *                   &lt;element name="PosteriorMode" type="{http://www.pharmml.org/2013/08/Dataset}DataSetType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PopulationEstimatesType", propOrder = {
    "mle",
    "bayesian"
})
public class PopulationEstimates
    extends PharmMLRootType
{

    @XmlElement(name = "MLE")
    protected DataSet mle;
    @XmlElement(name = "Bayesian")
    protected PopulationEstimates.Bayesian bayesian;

    /**
     * Gets the value of the mle property.
     * 
     * @return
     *     possible object is
     *     {@link DataSet }
     *     
     */
    public DataSet getMLE() {
        return mle;
    }

    /**
     * Sets the value of the mle property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataSet }
     *     
     */
    public void setMLE(DataSet value) {
        this.mle = value;
    }

    /**
     * Gets the value of the bayesian property.
     * 
     * @return
     *     possible object is
     *     {@link PopulationEstimatesType.Bayesian }
     *     
     */
    public PopulationEstimates.Bayesian getBayesian() {
        return bayesian;
    }

    /**
     * Sets the value of the bayesian property.
     * 
     * @param value
     *     allowed object is
     *     {@link PopulationEstimatesType.Bayesian }
     *     
     */
    public void setBayesian(PopulationEstimates.Bayesian value) {
        this.bayesian = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
     *       &lt;sequence>
     *         &lt;element name="PosteriorMean" type="{http://www.pharmml.org/2013/08/Dataset}DataSetType" minOccurs="0"/>
     *         &lt;element name="PosteriorMedian" type="{http://www.pharmml.org/2013/08/Dataset}DataSetType" minOccurs="0"/>
     *         &lt;element name="PosteriorMode" type="{http://www.pharmml.org/2013/08/Dataset}DataSetType" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "posteriorMean",
        "posteriorMedian",
        "posteriorMode"
    })
    public static class Bayesian
        extends PharmMLRootType
    {

        @XmlElement(name = "PosteriorMean")
        protected DataSet posteriorMean;
        @XmlElement(name = "PosteriorMedian")
        protected DataSet posteriorMedian;
        @XmlElement(name = "PosteriorMode")
        protected DataSet posteriorMode;

        /**
         * Gets the value of the posteriorMean property.
         * 
         * @return
         *     possible object is
         *     {@link DataSet }
         *     
         */
        public DataSet getPosteriorMean() {
            return posteriorMean;
        }

        /**
         * Sets the value of the posteriorMean property.
         * 
         * @param value
         *     allowed object is
         *     {@link DataSet }
         *     
         */
        public void setPosteriorMean(DataSet value) {
            this.posteriorMean = value;
        }

        /**
         * Gets the value of the posteriorMedian property.
         * 
         * @return
         *     possible object is
         *     {@link DataSet }
         *     
         */
        public DataSet getPosteriorMedian() {
            return posteriorMedian;
        }

        /**
         * Sets the value of the posteriorMedian property.
         * 
         * @param value
         *     allowed object is
         *     {@link DataSet }
         *     
         */
        public void setPosteriorMedian(DataSet value) {
            this.posteriorMedian = value;
        }

        /**
         * Gets the value of the posteriorMode property.
         * 
         * @return
         *     possible object is
         *     {@link DataSet }
         *     
         */
        public DataSet getPosteriorMode() {
            return posteriorMode;
        }

        /**
         * Sets the value of the posteriorMode property.
         * 
         * @param value
         *     allowed object is
         *     {@link DataSet }
         *     
         */
        public void setPosteriorMode(DataSet value) {
            this.posteriorMode = value;
        }
        
        /**
         * Creates a new empty {@link DataSet} posteriorMean element, adds it to the current object and returns it.
         * @return The created {@link DataSet} object.
         */
        public DataSet createPosteriorMean(){
        	DataSet el = new DataSet();
        	this.posteriorMean = el;
        	return el;
        }

        /**
         * Creates a new empty {@link DataSet} posteriorMedian element, adds it to the current object and returns it.
         * @return The created {@link DataSet} object.
         */
        public DataSet createPosteriorMedian(){
        	DataSet el = new DataSet();
        	this.posteriorMedian = el;
        	return el;
        }

        /**
         * Creates a new empty {@link DataSet} posteriorMode element, adds it to the current object and returns it.
         * @return The created {@link DataSet} object.
         */
        public DataSet createPosteriorMode(){
        	DataSet el = new DataSet();
        	this.posteriorMode = el;
        	return el;
        }


    }
    
    /**
     * Creates a new empty {@link DataSet} mle element, adds it to the current object and returns it.
     * @return The created {@link DataSet} object.
     */
    public DataSet createMle(){
    	DataSet el = new DataSet();
    	this.mle = el;
    	return el;
    }

    /**
     * Creates a new empty {@link PopulationEstimates.Bayesian} bayesian element, adds it to the current object and returns it.
     * @return The created {@link PopulationEstimates.Bayesian} object.
     */
    public PopulationEstimates.Bayesian createBayesian(){
    	PopulationEstimates.Bayesian el = new PopulationEstimates.Bayesian();
    	this.bayesian = el;
    	return el;
    }


}
