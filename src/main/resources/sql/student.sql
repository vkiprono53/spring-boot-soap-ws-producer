--Creating student table:

CREATE TABLE students(
                         student_id NOT NULL,
                         adm_no VARCHAR(50) NOT NULL,
                         first_name VARCHAR(100) NOT NULL,
                         last_name VARCHAR(100) NOT NULL,
                         course VARCHAR(50) NOT NULL,
                         age INTEGER NOT NULL,
                         gender VARCHAR(20) NOT NULL,
                         PRIMARY KEY(student_id)
);

---CREATE SEQUENCE

CREATE SEQUENCE students_seq
    START 1
  MINVALUE 1
  MAXVALUE 99999999999
  INCREMENT 1
  CACHE 1


-- Sample student Data

  INSERT INTO students(student_id,adm_no, first_name, last_name, course,age,gender)
VALUES((select nextval('students_seq')),'CS001', 'Kiki', 'Alan','Computer Science', 20,'Male'),
      ((select nextval('students_seq')),'CS002','Michal', 'John', 'Computer Science', 21, 'Male'),
      ((select nextval('students_seq')),'CS003','Jane', 'Mary', 'Computer Science', 20, 'Female'),
      ((select nextval('students_seq')),'LL002','Vicky', 'Bill', 'Law', 21, 'Female'),
      ((select nextval('students_seq')),'AC010','Mary', 'Jay', 'Acturial Science', 22, 'Female');

