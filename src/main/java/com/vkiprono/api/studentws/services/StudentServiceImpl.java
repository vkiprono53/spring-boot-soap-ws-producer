package com.vkiprono.api.studentws.services;

import com.vkiprono.api.studentws.entities.Student;
import com.vkiprono.api.studentws.repositories.StudentRepositoryI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author vkiprono
 * @created 2/28/23
 */

@Service
public class StudentServiceImpl implements StudentServiceI{

    private final StudentRepositoryI studentRepository;

    private static final  Logger logger= LoggerFactory.getLogger(StudentServiceImpl.class);

     @Autowired
    public StudentServiceImpl(StudentRepositoryI studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student findStudentByAdmNo(String admNo){
        logger.info("Entry:::::StudentEndpoint.findStudentByAdmNo():::::admNo==" + admNo);

        if (admNo != null){
            return studentRepository.findStudentByAdmNo(admNo);
        }

        logger.info("Exit:::::StudentEndpoint.findStudentByAdmNo():::::");

        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    @Override
    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student){
        return studentRepository.save(student);
    }

    @Override
    public Long deleteStudentByAdmNo(String admNo){
        logger.info("Entry:::::StudentEndpoint.findStudentByAdmNo():::::admNo==" + admNo);

        Long isDeleted = null;

        if (admNo != null) {
            isDeleted =  studentRepository.deleteStudentByAdmNo(admNo);
        }
        return isDeleted;
    }

}
