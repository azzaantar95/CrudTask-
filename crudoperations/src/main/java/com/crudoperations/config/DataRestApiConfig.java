package com.crudoperations.config;

import com.crudoperations.model.Employee;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;


@Configuration
public class DataRestApiConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        HttpMethod[] preventMethods = {HttpMethod.PUT, HttpMethod.DELETE, HttpMethod.GET, HttpMethod.POST};
        disableHttpMethods(Employee.class, config, preventMethods);
    }

    private void disableHttpMethods(Class className, RepositoryRestConfiguration config, HttpMethod[] preventMethods) {
        config.getExposureConfiguration()
                .forDomainType(className)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(preventMethods)))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(preventMethods));
    }
}
