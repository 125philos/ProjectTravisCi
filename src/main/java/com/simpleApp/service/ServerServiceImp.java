package com.simpleApp.service;

import lombok.extern.slf4j.Slf4j;
import com.simpleApp.model.Servers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.simpleApp.repository.ServerRepository;

import java.util.List;

@Slf4j
@Service
public class ServerServiceImp implements ServerService  {

    @Autowired
    ServerRepository serverRepository;
    @Override
    public Servers getById(Long id) {
        //log.info("IN CustomerServiceImpl getById {}", id);
        return serverRepository.findOne(id);
    }

    @Override
    public void save(Servers servers) {
        //log.info("IN CustomerServiceImpl save {}", servers);
        serverRepository.save(servers);
    }

    @Override
    public void delete(Long id) {
        //log.info("IN CustomerServiceImpl delete {}", id);
        serverRepository.delete(id);
    }

    @Override
    public List<Servers> getAll() {
        //log.info("IN CustomerServiceImpl getAll");
        return serverRepository.findAll();
    }
}
