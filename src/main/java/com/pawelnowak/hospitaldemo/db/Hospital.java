package com.pawelnowak.hospitaldemo.db;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "Hospitals")
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "Name is mandatory")
    @Column(unique = true, nullable = false)
    private String name;
    private String country;
    private String town;
    private String street;
    private String postalCode;
    private String phone;
    private String faxNumber;
    private Integer numberOfAmbulances;
    private boolean helicopterAccess;
    private boolean teachingHospital;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public Integer getNumberOfAmbulances() {
        return numberOfAmbulances;
    }

    public void setNumberOfAmbulances(Integer numberOfAmbulances) {
        this.numberOfAmbulances = numberOfAmbulances;
    }

    public boolean isHelicopterAccess() {
        return helicopterAccess;
    }

    public void setHelicopterAccess(boolean helicopterAccess) {
        this.helicopterAccess = helicopterAccess;
    }

    public boolean isTeachingHospital() {
        return teachingHospital;
    }

    public void setTeachingHospital(boolean teachingHospital) {
        this.teachingHospital = teachingHospital;
    }
}
