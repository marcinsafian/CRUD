package com.crud.tasks.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class CompanyConfig {

    @Value("${info.company.name}")
    private String companyName;

//    @Value("${info.company.address.street}")
//    private String companyAddressStreet;
//
//    @Value("${info.company.address.number}")
//    private String companyAddressNumber;

    @Value("${info.company.email}")
    private String companyEmail;

    @Value("${info.company.phone}")
    private String companyPhone;

    @Value("${info.company.goal}")
    private String companyGoal;

    @Value("${info.app.owner.name}")
    private String ownerName;

    @Value("${info.app.owner.surname}")
    private String ownerSurname;

//    public String getAddress() {
//        return String.format("%1$s %2$s", companyAddressStreet, companyAddressNumber);
//    }

    public String getOwner() {
        return String.format("%1$s %2$s", ownerName, ownerSurname);
    }
}
