package com.vkiprono.api.studentws.services;

import com.vkiprono.api.studentws.entities.Student;

import java.util.List;

/**
 * @author vkiprono
 * @created 3/2/23
 */

public interface StudentServiceI {
    Student findStudentByAdmNo(String admNo);

    List<Student> getAllStudents();

    Student addStudent(Student student);

    Student updateStudent(Student student);

    Long deleteStudentByAdmNo(String admNo);



}
