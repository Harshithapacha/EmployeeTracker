package com.tracking.model;

public class Emp {
    private int id;
    private String name;
    private String email;
    private String password;
    private String role;
    private String joinDate;
    private String phone;
    private String address;
    private String department;

    public Emp(String name, String email, String password, String role, String joinDate, String phone, String address, String department) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.joinDate = joinDate;
        this.phone = phone;
        this.address = address;
        this.department = department;
    }

    public Emp(int id, String name, String email, String password, String role, String joinDate, String phone, String address, String department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.joinDate = joinDate;
        this.phone = phone;
        this.address = address;
        this.department = department;
    }

    // Getters and setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
