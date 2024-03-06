package com.demo.SpringBootDemo.entity;
import jakarta.persistence.*;
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aid;
    private String city;
    private String country;
    @Column(name="pincode")
    private String zipcode;

    @OneToOne
    @JoinColumn(name="empid")
    private Employee employee;

    public Address() {
    }

    public Address(int aid, String city, String country, String zipcode) {
        this.aid = aid;
        this.city = city;
        this.country = country;
        this.zipcode = zipcode;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "aid=" + aid +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

