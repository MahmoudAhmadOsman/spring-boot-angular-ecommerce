package com.ecommerce.config;

import com.ecommerce.entity.Product;
import com.ecommerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

//READ ONLY

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

        // HttP methods
        HttpMethod[] theUnsupportedActions ={HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};


        //Now, disable HTTP methods for Product PUT, POTS & Delete
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withAssociationExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions) )
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));


        //Now, disable HTTP methods for ProductCategory PUT, POTS & Delete
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withAssociationExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions) )
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

    }

}
