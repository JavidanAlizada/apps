package dms.model;

import dms.model.sub.Address;
import java.io.Serializable;
import java.sql.Date;
import javax.management.relation.Role;

/**
 *
 * @author Javidan
 */
public class Account implements Serializable {

    private int id;
    private String name;
    private String surname;
    private String password;
    private String phoneNumber;
    private int age;
    private Address address;
    private boolean isActive;
    private Role role;
    private Date registeredAt;
    private Date deletedAt;

    public Account(int id, String name, String surname, String password, String phoneNumber, int age, Address address, boolean isActive, Role role, Date registeredAt, Date deletedAt) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.address = address;
        this.isActive = isActive;
        this.role = role;
        this.registeredAt = registeredAt;
        this.deletedAt = deletedAt;
    }

    
    
    public Account() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Date getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(Date registeredAt) {
        this.registeredAt = registeredAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    
    
    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", password=" + password + ", phoneNumber=" + phoneNumber + ", age=" + age + ", address=" + address + ", isActive=" + isActive + ", role=" + role + ", registeredAt=" + registeredAt + ", deletedAt=" + deletedAt + '}';
    }

    
}
