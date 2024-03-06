package com.demo.SpringBootDemo.entity;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int eid;
    @Column(nullable = true)
    private String ename;
    private String email;
    private String phone;

    private String password;

    @OneToOne(mappedBy = "employee" , cascade = {CascadeType.REMOVE})
    private Address address;

    public Employee() {
    }

    public Employee(int eid, String ename, String email, String phone, String password, Address address) {
        this.eid = eid;
        this.ename = ename;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.address = address;
    }
// getters and setters
    // constructor

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

