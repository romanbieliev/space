package org.belev.demo;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Tourist implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String description;
    private String gender;
    private String country;
    private String dateOfBirth;
    @Transient
    private Long shipIdentifier;
    // cascade = CascadeType.ALL
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ship_id")
    @JsonBackReference
    private Ship ship = null;

    private Tourist() {}

    public Tourist(String firstName, String lastName, String description, String gender, String country, String dateOfBirth, long shipIdentifier, Ship ship) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.gender = gender;
        this.country = country;
        this.dateOfBirth = dateOfBirth;
        this.shipIdentifier = shipIdentifier;
        this.ship = ship;
    }

    public Tourist(String firstName, String lastName, String description, String gender, String country, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.gender = gender;
        this.country = country;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tourist tourist = (Tourist) o;
        return Objects.equals(id, tourist.id) &&
                Objects.equals(firstName, tourist.firstName) &&
                Objects.equals(lastName, tourist.lastName) &&
                Objects.equals(description, tourist.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, description);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Ship getShip() {
        return this.ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public Long getShipIdentifier() {
        return this.shipIdentifier;
    }

    public void setShipIdentifier(long shipId) {
        this.shipIdentifier = shipId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id = " + id +
                ", firstName = " + firstName + '\'' +
                ", lastName = " + lastName + '\'' +
                ", description = " + description + '\'' +
                ", ship = " + ship + " " +
                '}';
    }


}
