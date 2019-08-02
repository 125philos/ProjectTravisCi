package com.simpleApp.service;

import com.simpleApp.model.Applications;
import com.simpleApp.model.Servers;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationServiceTest {
    private Applications applications;
    @Before
    public void setUp() {
        applications = new Applications();
        applications.setNameApplication("App12");
        applications.setNextApplication("App24");
        applications.setPreviousApplication("App71");
    }

    @Test
    public void getById() throws InterruptedException {
       //
    }

    @Test
    public void saveOrUpdate() throws InterruptedException {
        //
    }

    @Test
    public void saveOrUpdateApplicationForm() throws InterruptedException {
        //
    }

    @Test
    public void getAll() throws InterruptedException {
        List<Applications> applicationsList = new ArrayList<>();

        //then
        assertThat(applicationsList.size()).isEqualTo(6);
        assertThat(applicationsList.get(1)).isEqualTo(applications);
    }

}
