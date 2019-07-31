package com.simpleApp.repository;

import com.simpleApp.model.Applications;
import com.simpleApp.service.ApplicationService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ApplicationRepositoryTest {

    private static final String NAME_APPLICATION = "Application 1";
    private static final String PREV_APPLICATION = "Application 15";
    private static final String NEXT_APPLICATION = "Application 11";

    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private ApplicationRepository applicationRepository;

    @Test
    public void applicationsTest() {
        // Given information table Server
        Applications applications = new Applications();
        applications.setNameApplication(NAME_APPLICATION);
        applications.setPreviousApplication(PREV_APPLICATION);
        applications.setNextApplication(NEXT_APPLICATION);

        // Save information table
        applicationRepository.save(applications);

        // Compare
        Assert.assertNotNull(applications.getId());
        Applications newApplications = applicationRepository.findOne(applications.getId());
        Assert.assertEquals((Long) 1L, newApplications.getId());
        Assert.assertEquals(NAME_APPLICATION, newApplications.getNameApplication());
        Assert.assertEquals(PREV_APPLICATION, newApplications.getPreviousApplication());
        Assert.assertEquals(NEXT_APPLICATION, newApplications.getNextApplication());
    }
}
