package com.codejam.demo.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codejam.demo.exceptions.ResourceExistException;
import com.codejam.demo.exceptions.ResourceNotFoundException;
import com.codejam.demo.pojo.PersonalInformation;
import com.codejam.demo.repo.PersonalInfoRepository;
import com.codejam.demo.service.PersonalInfoService;

@Service
public class PersonalInfoServiceImpl implements PersonalInfoService {

    @Autowired
    private PersonalInfoRepository personalInfoRepository;
    
    @Override
    public PersonalInformation findById(Integer id) {
    	PersonalInformation idolPersonalInfo = personalInfoRepository.findById(id).orElse(null);
        if (idolPersonalInfo == null) throw new ResourceNotFoundException("Idol Personal Information", "id", id);
        return idolPersonalInfo;
    }

    @Override
    public PersonalInformation savePersonalInfo(PersonalInformation personalInfo) {
    	PersonalInformation dbPersonalInfo = personalInfoRepository.findIdolPersonalInfoByIdolName(personalInfo.getIdol_name()).orElse(null);
        if (dbPersonalInfo != null)
            throw new ResourceExistException("Idol Personal Information", "idol_name", personalInfo.getIdol_name());
        return personalInfoRepository.save(personalInfo);
    }
    

    @Override
    public void deletePersonalInfo(Integer id) {
    	PersonalInformation idolPersonalInfo = personalInfoRepository.findById(id)
                .orElse(null);
        if (idolPersonalInfo == null) throw new ResourceNotFoundException("Idol Personal Information", "id", id);
        personalInfoRepository.deleteById(id);
    }

    @Override
    public PersonalInformation updatePersonalInfo(PersonalInformation personalInfo) {
    	PersonalInformation dbPersonalInfo = personalInfoRepository.findById(personalInfo.getId()).orElse(null);
        if (dbPersonalInfo == null)
            throw new ResourceNotFoundException("Idol Personal Information", "id", personalInfo.getId());
        return personalInfoRepository.save(personalInfo);
    }



    @Override
    public PersonalInformation getRandomPersonalInfo() {

        return personalInfoRepository.getRandomPersonalInfo().orElse(null);
    }
}
