//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.07.12 at 01:39:24 PM EAT 
//


package com.alookatsoapapisinspringboot.school;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.*;


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
 *         &lt;element name="UploadStudentResponse" type="{http://www.alookatSOAPAPIsInSpringBoot.com/school}UploadStudentInfo" maxOccurs="unbounded"/>
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
    "uploadStudentResponse"
})
@XmlRootElement(namespace="http://www.alookatSOAPAPIsInSpringBoot.com/school",name = "getAllStudentResponse")
public class GetAllStudentResponse {

    @XmlElement(name = "UploadStudentResponse", required = true)
    protected List<UploadStudentInfo> uploadStudentResponse;

    /**
     * Gets the value of the uploadStudentResponse property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the uploadStudentResponse property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUploadStudentResponse().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UploadStudentInfo }
     * 
     * 
     */
    public List<UploadStudentInfo> getUploadStudentResponse() {
        if (uploadStudentResponse == null) {
            uploadStudentResponse = new ArrayList<UploadStudentInfo>();
        }
        return this.uploadStudentResponse;
    }

}