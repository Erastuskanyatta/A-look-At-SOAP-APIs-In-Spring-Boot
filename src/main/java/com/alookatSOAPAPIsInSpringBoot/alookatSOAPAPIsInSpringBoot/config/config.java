package com.alookatSOAPAPIsInSpringBoot.alookatSOAPAPIsInSpringBoot.config;


import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import java.util.logging.Logger;

@EnableWs
@Configuration
public class config extends WsConfigurerAdapter {

    Logger logger = Logger.getLogger(String.valueOf(WsConfigurerAdapter.class));
    @Bean
    public ServletRegistrationBean servletRegistrationBean(ApplicationContext applicationContext) {
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(applicationContext);
        messageDispatcherServlet.setTransformSchemaLocations(true);
        return new ServletRegistrationBean<>(messageDispatcherServlet, "/service/*");
    }

    @Bean
    public DefaultWsdl11Definition studentDetailsWsdl(XsdSchema countriesSchema) {

        DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
        defaultWsdl11Definition.setPortTypeName("StudentDetailsPort");
        defaultWsdl11Definition.setLocationUri("/uploadStudents");
        defaultWsdl11Definition.setTargetNamespace("http://www.howtodoinjava.com/xml/school");
        defaultWsdl11Definition.setSchema(countriesSchema);
        return defaultWsdl11Definition;
    }

    @Bean
    public XsdSchema countriesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("school.xsd"));
    }

}
