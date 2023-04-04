package com.vkiprono.api.studentws.endpoints;

import com.vkiprono.api.studentws.constants.ServiceStatusConstant;
import com.vkiprono.api.studentws.entities.Student;
import com.vkiprono.api.studentws.services.StudentServiceI;
import com.vkiprono.api.studentws.studentdetails.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vkiprono
 * @created 2/28/23
 */

@Endpoint
public class StudentEndpoint {
    private final String TARGET_NAMESPACE = "http://vkiprono.com/api/studentws/studentdetails";
    private final StudentServiceI studentServiceI;

    private static Logger logger = LoggerFactory.getLogger(StudentEndpoint.class);

    @Autowired
    public StudentEndpoint(StudentServiceI studentServiceI) {
        this.studentServiceI = studentServiceI;
    }

    /**
     * Get student by admNo
     *
     * @param getStudentByAdmRequest
     * @return
     */

    @PayloadRoot(namespace = TARGET_NAMESPACE, localPart = "GetStudentByAdmRequest")
    @ResponsePayload
    public GetStudentByAdmResponse findStudentByAdmNo(@RequestPayload GetStudentByAdmRequest getStudentByAdmRequest) {
        logger.info("Entry:::::StudentEndpoint.findStudentByAdmNo():::::");
        Student student = new Student();
        GetStudentByAdmResponse getStudentByAdmResponse = new GetStudentByAdmResponse();


        student = studentServiceI.findStudentByAdmNo(getStudentByAdmRequest.getAdmNo());

        logger.info(":::::Student1:::::" + student.getFirstName());
        logger.info(":::::Student2:::::" + student.getLastName());

        com.vkiprono.api.studentws.studentdetails.Student student1 = new com.vkiprono.api.studentws.studentdetails.Student();

        BeanUtils.copyProperties(student, student1);
        getStudentByAdmResponse.setStudent(student1);

        logger.info("Exit:::::StudentEndpoint.findStudentByAdmNo():::::");

        return getStudentByAdmResponse;
    }

    /**
     * Get all students
     *
     * @return
     */
    @PayloadRoot(namespace = TARGET_NAMESPACE, localPart = "GetAllStudentsRequest")
    @ResponsePayload
    public GetAllStudentsResponse getAllStudentsResponse() {
        logger.info("Entry:::::StudentEndpoint.getAllStudentsResponse():::::");

        GetAllStudentsResponse allStudentsResponse = new GetAllStudentsResponse();

        List<Student> studentList = new ArrayList<>();
        studentList = studentServiceI.getAllStudents();

        logger.info("studentList size :::::" + studentList.size());

        List<com.vkiprono.api.studentws.studentdetails.Student> studentList1 = new ArrayList<>();

        for (Student student : studentList) {
            com.vkiprono.api.studentws.studentdetails.Student student1 = new com.vkiprono.api.studentws.studentdetails.Student();

            BeanUtils.copyProperties(student, student1);
            studentList1.add(student1);
        }

        allStudentsResponse.getStudent().addAll(studentList1);
        logger.info("Exit:::::StudentEndpoint.getAllStudentsResponse():::::");

        return allStudentsResponse;

    }

    /**
     * Adding student
     *
     * @param addStudentRequest
     * @return
     */
    @PayloadRoot(namespace = TARGET_NAMESPACE, localPart = "AddStudentRequest")
    @ResponsePayload
    public AddStudentResponse addStudentResponse(@RequestPayload AddStudentRequest addStudentRequest) {
        logger.info("Entry:::::StudentEndpoint.addStudentResponse():::::");

        AddStudentResponse addStudentResponse = new ObjectFactory().createAddStudentResponse();

        ServiceStatus serviceStatus = new ServiceStatus();
        Student student = new Student();
        com.vkiprono.api.studentws.studentdetails.Student student1 = new com.vkiprono.api.studentws.studentdetails.Student();

        student.setFirstName(addStudentRequest.getFirstName());
        student.setLastName(addStudentRequest.getLastName());
        student.setAdmNo(addStudentRequest.getAdmNo());
        student.setAge(addStudentRequest.getAge());
        student.setCourse(addStudentRequest.getCourse());
        student.setGender(addStudentRequest.getGender());

        student = studentServiceI.addStudent(student);

        logger.info(":::::studentId is:::::" + student.getStudentId());

        if (student.getStudentId() != null) {
            BeanUtils.copyProperties(student, student1);
            student1.setStudentId(student.getStudentId());
            serviceStatus.setStatusCode(ServiceStatusConstant.STATUS_SUCCESS);
            serviceStatus.setMessage(ServiceStatusConstant.MSG_ADD_OK);
            addStudentResponse.setStudent(student1);
        } else {
            serviceStatus.setStatusCode(ServiceStatusConstant.STATUS_FAIL);
            serviceStatus.setMessage(ServiceStatusConstant.MSG_ADD_FAIL);
        }

        addStudentResponse.setServiceStatus(serviceStatus);

        logger.info("Exit:::::StudentEndpoint.addStudentResponse():::::");

        return addStudentResponse;
    }

    /**
     * Updating student
     *
     * @param updateStudentRequest
     * @return
     */
    @PayloadRoot(namespace = TARGET_NAMESPACE, localPart = "UpdateStudentRequest")
    @ResponsePayload
    public UpdateStudentResponse updateStudent(@RequestPayload UpdateStudentRequest updateStudentRequest) {

        logger.info("Entry:::::StudentEndpoint.updateStudent():::::");

        UpdateStudentResponse studentResponse = new UpdateStudentResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        Student student = new Student();

        BeanUtils.copyProperties(updateStudentRequest.getStudent(), student);

        student = studentServiceI.updateStudent(student);

        if (student != null) {
            serviceStatus.setStatusCode(ServiceStatusConstant.STATUS_SUCCESS);
            serviceStatus.setMessage(ServiceStatusConstant.MSG_UPDATE_OK);
        } else {
            serviceStatus.setStatusCode(ServiceStatusConstant.STATUS_FAIL);
            serviceStatus.setMessage(ServiceStatusConstant.MSG_UPDATE_FAIL);
        }
        studentResponse.setServiceStatus(serviceStatus);


        logger.info("Exit:::::StudentEndpoint.updateStudent():::::");

        return studentResponse;

    }

    /**
     * delete student
     *
     * @param deleteStudentRequest
     * @return
     */
    @PayloadRoot(namespace = TARGET_NAMESPACE, localPart = "DeleteStudentRequest")
    @ResponsePayload
    public DeleteStudentResponse deleteStudentResponse(@RequestPayload DeleteStudentRequest deleteStudentRequest) {
        logger.info("Entry:::::StudentEndpoint.deleteStudentResponse():::::");

        DeleteStudentResponse deleteStudentResponse = new DeleteStudentResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        Long isDeleted = null;
        isDeleted = studentServiceI.deleteStudentByAdmNo(deleteStudentRequest.getAdmNo());

        logger.info(":::::isDeleted = " + isDeleted);

        if (isDeleted == 1) {
            serviceStatus.setStatusCode(ServiceStatusConstant.STATUS_SUCCESS);
            serviceStatus.setMessage(ServiceStatusConstant.MSG_DELETE_OK);
        } else {
            serviceStatus.setStatusCode(ServiceStatusConstant.STATUS_FAIL);
            serviceStatus.setMessage(ServiceStatusConstant.MSG_DELETE_FAIL);
        }

        deleteStudentResponse.setServiceStatus(serviceStatus);

        logger.info("Exit:::::StudentEndpoint.deleteStudentResponse():::::");

        return deleteStudentResponse;

    }

   /* private JAXBElement<GetStudentByAdmResponse> createResponseJaxbElement(GetStudentByAdmResponse object, Class clazz) {

        return new JAXBElement<GetStudentByAdmResponse>(new QName(TARGET_NAMESPACE, clazz.getSimpleName()), clazz, object);

    }*/
}