package com.mvc.demo.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.List;

public class StudentDto implements Serializable {
    private Long id;
    @NotNull(message = "First name is mandatory.")
    @NotBlank(message = "First Name must have a value.")
    private String firstName;
    @NotNull(message = "Last Name is mandatory.")
    @NotBlank(message = "Last Name must have a value.")
    private String lastName;
    @NotNull(message = "Age is mandatory.")
    @Min(value = 19, message = "Min age is 19.")
    @Max(value = 25, message = "Max age is 25.")
    private Integer age;
    @NotNull(message = "Sore is manadatory.")
    @Min(value = 1, message = "Score can be min 1.")
    @Max(value = 10, message = "Score can be max 10.")
    private Integer score;

    private AddressDto address;

    private List<CourseDto> courses;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public List<CourseDto> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDto> courses) {
        this.courses = courses;
    }
}
