package com.vkiprono.api.studentws.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author vkiprono
 * @created 2/28/23
 */

@Entity
@Table(name = "students")
@SequenceGenerator(name = "students_seq", sequenceName = "students_seq", allocationSize = 1)
public class Student implements Serializable {

    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,  generator = "students_seq")
    private Long studentId;
    @Column(name = "adm_no")
    private String admNo;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "course")
    private String course;
    @Column(name = "age")
    private int age;
    @Column(name = "gender")
    private String gender;

    public Student() {
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getAdmNo() {
        return admNo;
    }

    public void setAdmNo(String admNo) {
        this.admNo = admNo;
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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
