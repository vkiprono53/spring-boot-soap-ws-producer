package com.vkiprono.api.studentws.repositories;

import com.vkiprono.api.studentws.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @author vkiprono
 * @created 2/28/23
 */

@Repository
@Transactional
public interface StudentRepositoryI extends JpaRepository<Student, Long> {
     Student findStudentByAdmNo(String admNo);
     Long deleteStudentByAdmNo(String admNo);
}
