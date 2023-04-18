package com.vkiprono.api.studentws.configs;

import com.vkiprono.api.studentws.constants.ConfigConstants;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.security.xwss.XwsSecurityInterceptor;
import org.springframework.ws.soap.security.xwss.callback.SimplePasswordValidationCallbackHandler;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import java.util.Collections;
import java.util.List;

/**
 * @author vkiprono
 * @created 2/28/23
 */

@EnableWs
@Configuration
public class StudentWSConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> servletRegistrationBean(ApplicationContext applicationContext) {

        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(applicationContext);
        messageDispatcherServlet.setTransformWsdlLocations(true);

        return new ServletRegistrationBean<MessageDispatcherServlet>(messageDispatcherServlet, "/soapws/*");

    }

    @Bean(name = "students")
    public DefaultWsdl11Definition wsdl11Definition(XsdSchema xsdSchema) {
        DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
        defaultWsdl11Definition.setPortTypeName("StudentsPort");
        defaultWsdl11Definition.setLocationUri("/soapws");
        defaultWsdl11Definition.setTargetNamespace("http://vkiprono.com/api/studentws/studentdetails");
        defaultWsdl11Definition.setSchema(xsdSchema);

        return defaultWsdl11Definition;
    }

    @Bean
    public XsdSchema xsdSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsds/student.xsd"));
    }



    //Security config
    @Bean
    public XwsSecurityInterceptor securityInterceptor(){
        XwsSecurityInterceptor xwsSecurityInterceptor = new XwsSecurityInterceptor();
        xwsSecurityInterceptor.setCallbackHandler(callBackHandler());
        xwsSecurityInterceptor.setPolicyConfiguration(new ClassPathResource("security/securityPolicy.xml"));

        return xwsSecurityInterceptor;
    }

    //Add securityInterceptor to list of interceptors
    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        interceptors.add(securityInterceptor());
    }


    //Callbackhandler
    @Bean
    public SimplePasswordValidationCallbackHandler callBackHandler(){
        SimplePasswordValidationCallbackHandler callbackHandler = new SimplePasswordValidationCallbackHandler();
        callbackHandler.setUsersMap(Collections.singletonMap(ConfigConstants.BASIC_SECURITY_USERNAME,
                ConfigConstants.BASIC_SECURITY_PASSWORD));

        return callbackHandler;
    }

}
