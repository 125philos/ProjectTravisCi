package com.simpleApp.repository;

import com.simpleApp.model.Servers;
import com.simpleApp.service.ApplicationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ServerRepositoryTest {

    private static final String NAME_SERVRR = "Server 5";
    private static final String DESCRIPTION = "description description";

    @Autowired
    private ServerRepository serverRepository;
    private ApplicationService applicationService;

    @Test
    public void serversTest() {
        // Given information table Server
        Servers servers = new Servers();
        servers.setNameServer(NAME_SERVRR);
        servers.setIdApplication(applicationService.getById((long) 1));
        servers.setDescription(DESCRIPTION);

        // Save information table
        serverRepository.save(servers);

        // Compare
        Assert.assertNotNull(servers.getId());
        Servers newServers = serverRepository.findOne(servers.getId());
        Assert.assertEquals((Long) 1L, newServers.getId());
        Assert.assertEquals(NAME_SERVRR, newServers.getNameServer());
        Assert.assertEquals(newServers.getIdApplication(), (long) 1);
        Assert.assertEquals(DESCRIPTION, newServers.getDescription());
    }
}
