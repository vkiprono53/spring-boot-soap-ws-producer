# spring-boot-soap-ws-producer
Spring Boot SOAP web service - Producer

<h5>Technologies and Tools used</h5>
<ul>
 <li>Springboot 2.5.5</li>
 <li>Java 1.8</li>
  <li>Maven</li>
 <li>jaxb2-maven-plugin 3.1.0</li>
  <li>Spring security</li>
 <li>PostgreSQL 12.8</li>
 <li>Intellij IDEA</li>
 <li>SOAP UI 5.7</li>
 </ul>
 <br>
<b>XSD file</b>
<br>
<b>Location : </b>  ${project.basedir}/resources/xsds/student.xsd 
<br>

```xsd
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema"
           xmlns:tns = "http://vkiprono.com/api/studentws/studentdetails"
           targetNamespace="http://vkiprono.com/api/studentws/studentdetails">

<xs:element name="GetStudentByAdmRequest">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="admNo" type="xs:string"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>

    <xs:element name="GetStudentByAdmResponse">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="student" type="tns:student"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>


    <xs:complexType name="student">
        <xs:sequence>
            <xs:element name="studentId" type="xs:long"/>
            <xs:element name="admNo" type="xs:string"/>
            <xs:element name="firstName" type="xs:string"/>
            <xs:element name="lastName" type="xs:string"/>
            <xs:element name="course" type="xs:string"/>
            <xs:element name="age" type="xs:int"/>
            <xs:element name="gender" type="xs:string"/>
        </xs:sequence>
    </xs:complexType>

    <xs:element name="GetAllStudentsRequest">
        <xs:complexType/>

    </xs:element>

    <xs:element name="GetAllStudentsResponse">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="student" type="tns:student" maxOccurs="unbounded">
                </xs:element>
            </xs:sequence>
        </xs:complexType>
    </xs:element>

    <xs:element name="AddStudentRequest">
    <xs:complexType >
        <xs:sequence>
            <xs:element name="admNo" type="xs:string"/>
            <xs:element name="firstName" type="xs:string"/>
            <xs:element name="lastName" type="xs:string"/>
            <xs:element name="course" type="xs:string"/>
            <xs:element name="age" type="xs:int"/>
            <xs:element name="gender" type="xs:string"/>
        </xs:sequence>
    </xs:complexType>
    </xs:element>

    <xs:element name="AddStudentResponse">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="student" type="tns:student"/>
                <xs:element name="serviceStatus" type="tns:ServiceStatus"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>

    <xs:element name="UpdateStudentRequest">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="student" type="tns:student"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>

    <xs:element name="UpdateStudentResponse">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="serviceStatus" type="tns:ServiceStatus"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>

    <xs:element name="DeleteStudentRequest">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="admNo" type="xs:string"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>

    <xs:element name="DeleteStudentResponse">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="serviceStatus" type="tns:ServiceStatus"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>

    <xs:complexType name="ServiceStatus">
        <xs:sequence>
            <xs:element name="statusCode" type="xs:string"/>
            <xs:element name="message" type="xs:string"/>
        </xs:sequence>
    </xs:complexType>
</xs:schema>
```

<b>WSDL</b>
<b>Link : </b>
http://localhost:9002/soapws/students.wsdl
<br>
<b>Location : </b>
${project.basedir}/resources/wsdl/students.wsdl

```xml
<wsdl:definitions xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns:sch="http://vkiprono.com/api/studentws/studentdetails" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:tns="http://vkiprono.com/api/studentws/studentdetails" targetNamespace="http://vkiprono.com/api/studentws/studentdetails">
    <wsdl:types>
        <xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema" targetNamespace="http://vkiprono.com/api/studentws/studentdetails">
            <xs:element name="GetStudentByAdmRequest">
                <xs:complexType>
                    <xs:sequence>
                        <xs:element name="admNo" type="xs:string"/>
                    </xs:sequence>
                </xs:complexType>
            </xs:element>
            <xs:element name="GetStudentByAdmResponse">
                <xs:complexType>
                    <xs:sequence>
                        <xs:element name="student" type="tns:student"/>
                    </xs:sequence>
                </xs:complexType>
            </xs:element>
            <xs:complexType name="student">
                <xs:sequence>
                    <xs:element name="studentId" type="xs:long"/>
                    <xs:element name="admNo" type="xs:string"/>
                    <xs:element name="firstName" type="xs:string"/>
                    <xs:element name="lastName" type="xs:string"/>
                    <xs:element name="course" type="xs:string"/>
                    <xs:element name="age" type="xs:int"/>
                    <xs:element name="gender" type="xs:string"/>
                </xs:sequence>
            </xs:complexType>
            <xs:element name="GetAllStudentsRequest">
                <xs:complexType/>
            </xs:element>
            <xs:element name="GetAllStudentsResponse">
                <xs:complexType>
                    <xs:sequence>
                        <xs:element maxOccurs="unbounded" name="student" type="tns:student"> </xs:element>
                    </xs:sequence>
                </xs:complexType>
            </xs:element>
            <xs:element name="AddStudentRequest">
                <xs:complexType>
                    <xs:sequence>
                        <xs:element name="admNo" type="xs:string"/>
                        <xs:element name="firstname" type="xs:string"/>
                        <xs:element name="lastname" type="xs:string"/>
                        <xs:element name="course" type="xs:string"/>
                        <xs:element name="age" type="xs:int"/>
                        <xs:element name="gender" type="xs:string"/>
                    </xs:sequence>
                </xs:complexType>
            </xs:element>
            <xs:element name="AddStudentResponse">
                <xs:complexType>
                    <xs:sequence>
                        <xs:element name="student" type="tns:student"/>
                        <xs:element name="serviceStatus" type="tns:ServiceStatus"/>
                    </xs:sequence>
                </xs:complexType>
            </xs:element>
            <xs:element name="UpdateStudentRequest">
                <xs:complexType>
                    <xs:sequence>
                        <xs:element name="student" type="tns:student"/>
                    </xs:sequence>
                </xs:complexType>
            </xs:element>
            <xs:element name="UpdateStudentResponse">
                <xs:complexType>
                    <xs:sequence>
                        <xs:element name="serviceStatus" type="tns:ServiceStatus"/>
                    </xs:sequence>
                </xs:complexType>
            </xs:element>
            <xs:element name="DeleteStudentRequest">
                <xs:complexType>
                    <xs:sequence>
                        <xs:element name="admNo" type="xs:string"/>
                    </xs:sequence>
                </xs:complexType>
            </xs:element>
            <xs:element name="DeleteStudentResponse">
                <xs:complexType>
                    <xs:sequence>
                        <xs:element name="serviceStatus" type="tns:ServiceStatus"/>
                    </xs:sequence>
                </xs:complexType>
            </xs:element>
            <xs:complexType name="ServiceStatus">
                <xs:sequence>
                    <xs:element name="statusCode" type="xs:string"/>
                    <xs:element name="message" type="xs:string"/>
                </xs:sequence>
            </xs:complexType>
        </xs:schema>
    </wsdl:types>
    <wsdl:message name="AddStudentResponse">
        <wsdl:part element="tns:AddStudentResponse" name="AddStudentResponse"> </wsdl:part>
    </wsdl:message>
    <wsdl:message name="DeleteStudentRequest">
        <wsdl:part element="tns:DeleteStudentRequest" name="DeleteStudentRequest"> </wsdl:part>
    </wsdl:message>
    <wsdl:message name="GetStudentByAdmResponse">
        <wsdl:part element="tns:GetStudentByAdmResponse" name="GetStudentByAdmResponse"> </wsdl:part>
    </wsdl:message>
    <wsdl:message name="GetAllStudentsRequest">
        <wsdl:part element="tns:GetAllStudentsRequest" name="GetAllStudentsRequest"> </wsdl:part>
    </wsdl:message>
    <wsdl:message name="GetStudentByAdmRequest">
        <wsdl:part element="tns:GetStudentByAdmRequest" name="GetStudentByAdmRequest"> </wsdl:part>
    </wsdl:message>
    <wsdl:message name="GetAllStudentsResponse">
        <wsdl:part element="tns:GetAllStudentsResponse" name="GetAllStudentsResponse"> </wsdl:part>
    </wsdl:message>
    <wsdl:message name="AddStudentRequest">
        <wsdl:part element="tns:AddStudentRequest" name="AddStudentRequest"> </wsdl:part>
    </wsdl:message>
    <wsdl:message name="UpdateStudentRequest">
        <wsdl:part element="tns:UpdateStudentRequest" name="UpdateStudentRequest"> </wsdl:part>
    </wsdl:message>
    <wsdl:message name="UpdateStudentResponse">
        <wsdl:part element="tns:UpdateStudentResponse" name="UpdateStudentResponse"> </wsdl:part>
    </wsdl:message>
    <wsdl:message name="DeleteStudentResponse">
        <wsdl:part element="tns:DeleteStudentResponse" name="DeleteStudentResponse"> </wsdl:part>
    </wsdl:message>
    <wsdl:portType name="StudentsPort">
        <wsdl:operation name="AddStudent">
            <wsdl:input message="tns:AddStudentRequest" name="AddStudentRequest"> </wsdl:input>
            <wsdl:output message="tns:AddStudentResponse" name="AddStudentResponse"> </wsdl:output>
        </wsdl:operation>
        <wsdl:operation name="DeleteStudent">
            <wsdl:input message="tns:DeleteStudentRequest" name="DeleteStudentRequest"> </wsdl:input>
            <wsdl:output message="tns:DeleteStudentResponse" name="DeleteStudentResponse"> </wsdl:output>
        </wsdl:operation>
        <wsdl:operation name="GetStudentByAdm">
            <wsdl:input message="tns:GetStudentByAdmRequest" name="GetStudentByAdmRequest"> </wsdl:input>
            <wsdl:output message="tns:GetStudentByAdmResponse" name="GetStudentByAdmResponse"> </wsdl:output>
        </wsdl:operation>
        <wsdl:operation name="GetAllStudents">
            <wsdl:input message="tns:GetAllStudentsRequest" name="GetAllStudentsRequest"> </wsdl:input>
            <wsdl:output message="tns:GetAllStudentsResponse" name="GetAllStudentsResponse"> </wsdl:output>
        </wsdl:operation>
        <wsdl:operation name="UpdateStudent">
            <wsdl:input message="tns:UpdateStudentRequest" name="UpdateStudentRequest"> </wsdl:input>
            <wsdl:output message="tns:UpdateStudentResponse" name="UpdateStudentResponse"> </wsdl:output>
        </wsdl:operation>
    </wsdl:portType>
    <wsdl:binding name="StudentsPortSoap11" type="tns:StudentsPort">
        <soap:binding style="document" transport="http://schemas.xmlsoap.org/soap/http"/>
        <wsdl:operation name="AddStudent">
            <soap:operation soapAction=""/>
            <wsdl:input name="AddStudentRequest">
                <soap:body use="literal"/>
            </wsdl:input>
            <wsdl:output name="AddStudentResponse">
                <soap:body use="literal"/>
            </wsdl:output>
        </wsdl:operation>
        <wsdl:operation name="DeleteStudent">
            <soap:operation soapAction=""/>
            <wsdl:input name="DeleteStudentRequest">
                <soap:body use="literal"/>
            </wsdl:input>
            <wsdl:output name="DeleteStudentResponse">
                <soap:body use="literal"/>
            </wsdl:output>
        </wsdl:operation>
        <wsdl:operation name="GetStudentByAdm">
            <soap:operation soapAction=""/>
            <wsdl:input name="GetStudentByAdmRequest">
                <soap:body use="literal"/>
            </wsdl:input>
            <wsdl:output name="GetStudentByAdmResponse">
                <soap:body use="literal"/>
            </wsdl:output>
        </wsdl:operation>
        <wsdl:operation name="GetAllStudents">
            <soap:operation soapAction=""/>
            <wsdl:input name="GetAllStudentsRequest">
                <soap:body use="literal"/>
            </wsdl:input>
            <wsdl:output name="GetAllStudentsResponse">
                <soap:body use="literal"/>
            </wsdl:output>
        </wsdl:operation>
        <wsdl:operation name="UpdateStudent">
            <soap:operation soapAction=""/>
            <wsdl:input name="UpdateStudentRequest">
                <soap:body use="literal"/>
            </wsdl:input>
            <wsdl:output name="UpdateStudentResponse">
                <soap:body use="literal"/>
            </wsdl:output>
        </wsdl:operation>
    </wsdl:binding>
    <wsdl:service name="StudentsPortService">
        <wsdl:port binding="tns:StudentsPortSoap11" name="StudentsPortSoap11">
            <soap:address location="http://localhost:9002/soapws"/>
        </wsdl:port>
    </wsdl:service>
</wsdl:definitions>
```

<br>
<b>Sample Data : </b>
<br/>
<b>Location: </b> ${project.basedir}/resources/sql/student.sql
<br>
<br>

```sql

--Creating students table:
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


```
<br>
<b>Sample Requests and Responses</b>
<br>
<b>Add Student Request</b>
<br>

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:stud="http://vkiprono.com/api/studentws/studentdetails">
    <soapenv:Header>
        <wsse:Security xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd" mustUnderstand="1">
            <wsse:UsernameToken>
                <wsse:Username>bug</wsse:Username>
                <wsse:Password>bugDev</wsse:Password>
            </wsse:UsernameToken>
        </wsse:Security>
    </soapenv:Header>
    <soapenv:Body>
        <stud:AddStudentRequest>
            <admNo>BC001</admNo>
            <firstName>June</firstName>
            <lastName>Bo</lastName>
            <course>Economics</course>
            <age>23</age>
            <gender>Female</gender>
        </stud:AddStudentRequest>
    </soapenv:Body>
</soapenv:Envelope>
```

<br>
<b>Add Student Response</b>
<br>

 ```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header />
    <SOAP-ENV:Body>
        <ns3:AddStudentResponse xmlns:ns3="http://vkiprono.com/api/studentws/studentdetails">
            <student>
                <studentId>11</studentId>
                <admNo>BC001</admNo>
                <firstName>June</firstName>
                <lastName>Bo</lastName>
                <course>Economics</course>
                <age>23</age>
                <gender>Female</gender>
            </student>
            <serviceStatus>
                <statusCode>SUCCESS</statusCode>
                <message>Successfully added student's details</message>
            </serviceStatus>
        </ns3:AddStudentResponse>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

<br>
<b>GetStudentByAdm Request</b>
<br>

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:stud="http://vkiprono.com/api/studentws/studentdetails">
    <soapenv:Header>
        <wsse:Security xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd" mustUnderstand="1">
            <wsse:UsernameToken>
                <wsse:Username>bug</wsse:Username>
                <wsse:Password>bugDev</wsse:Password>
            </wsse:UsernameToken>
        </wsse:Security>
    </soapenv:Header>
    <soapenv:Body>
        <stud:GetStudentByAdmRequest>
            <admNo>CS001</admNo>
        </stud:GetStudentByAdmRequest>
    </soapenv:Body>
</soapenv:Envelope>
```

<br>
<b>GetStudentByAdm Response</b>
<br>

```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header />
    <SOAP-ENV:Body>
        <ns3:GetStudentByAdmResponse xmlns:ns3="http://vkiprono.com/api/studentws/studentdetails">
            <student>
                <studentId>4</studentId>
                <admNo>CS001</admNo>
                <firstName>Kiki</firstName>
                <lastName>Alan</lastName>
                <course>Computer Science</course>
                <age>20</age>
                <gender>Male</gender>
            </student>
        </ns3:GetStudentByAdmResponse>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

 <br>
<b>How to run the project</b>
<ul>
<li>Download and unzip the project or clone using : </li>
git clone git@github.com:vkiprono53/spring-boot-soap-ws-producer.git
<li>cd to spring-boot-soap-ws-producer folder </li>
<li>run : ./mvnw spring-boot:run</li>

</ul>
<br>
