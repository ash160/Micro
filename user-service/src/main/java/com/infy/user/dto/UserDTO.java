package com.infy.user.dto;

import java.util.Objects;

public class UserDTO {
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private Long departmentId;
    private DepartmentDTO departments;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public DepartmentDTO getDepartments() {
        return departments;
    }

    public void setDepartments(DepartmentDTO departments) {
        this.departments = departments;
    }

    public UserDTO(Long userId, String firstName, String lastName, String email, Long departmentId, DepartmentDTO departments) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.departmentId = departmentId;
        this.departments = departments;
    }

    public UserDTO() {
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", departmentId=" + departmentId +
                ", departments=" + departments +
                '}';
    }

}
