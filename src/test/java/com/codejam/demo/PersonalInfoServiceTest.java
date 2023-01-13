package com.codejam.demo;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import com.codejam.demo.pojo.PersonalInformation;
import com.codejam.demo.service.PersonalInfoService;
import com.codejam.demo.serviceImpl.PersonalInfoServiceImpl;


@DataJpaTest
@Import(PersonalInfoServiceImpl.class)
public class PersonalInfoServiceTest {

    @Autowired
    private PersonalInfoService personalInfoService;

    @BeforeEach
    public void addUsers() {
    	PersonalInformation personalInfo = new PersonalInformation();
    	personalInfo.setIdol_status("INACTIVE");
    	personalInfo.setIdol_name("Sandy");
    	personalInfo.setAddress("Pune");
    	personalInfo.setReal_name("Sandeep Khamkar");
    	personalInfoService.savePersonalInfo(personalInfo);//Adds user into db
    }

    @Test
    public void getRandomPersonalInfo() throws Exception {
    	PersonalInformation personalInfo = personalInfoService.getRandomPersonalInfo();
        BDDAssertions.assertThat(personalInfo).isNotNull();//checks if the output is null or not
        BDDAssertions.assertThat(personalInfo.getIdol_status()).isEqualTo("ACTIVE");//checks if status is active
    }
}
