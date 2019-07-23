package com.simpleApp.controller;

import com.simpleApp.model.Servers;
import com.simpleApp.model.ServersForm;
import com.simpleApp.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class ServersRest {
    @Autowired
    private ServerService serverService;

    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/server/list";
    }
    @RequestMapping({"/server/list", "/server"})
    public String listServers(Model model){
        model.addAttribute("servers", serverService.getAll());
        return "server/list";
    }

    @RequestMapping("/server/show/{id}")
    public String getServer(@PathVariable String id, Model model){
        model.addAttribute("server", serverService.getById(Long.valueOf(id)));
        return "server/show";
    }

    @RequestMapping("/server/new")
    public String newServer(Model model){
        model.addAttribute("serverForm", new ServersForm());
        return "server/serverform";
    }

    @RequestMapping(value = "/server", method = RequestMethod.POST)
    public String saveOrUpdateServer(@Valid ServersForm serverForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "server/serverform";
        }

        Servers savedServers = serverService.saveOrUpdateServersForm(serverForm);

        return "redirect:/server/show/" + savedServers.getId();
    }

    @RequestMapping("/server/delete/{id}")
    public String delete(@PathVariable String id){
        serverService.delete(Long.valueOf(id));
        return "redirect:/server/list";
    }

    /*@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Servers> getServers(@PathVariable("id") Long serversId) {
        if (serversId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Servers servers = this.serverService.getById(serversId);

        if (servers == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(servers, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Servers> saveServers(@RequestBody @Valid Servers servers) {
        HttpHeaders headers = new HttpHeaders();

        if (servers == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.serverService.save(servers);
        return new ResponseEntity<>(servers, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Servers> updateServers(@RequestBody @Valid Servers servers, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (servers == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.serverService.save(servers);

        return new ResponseEntity<>(servers, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Servers> deleteServers(@PathVariable("id") Long id) {
        Servers servers = this.serverService.getById(id);

        if (servers == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.serverService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Servers>> getAllServers() {
        List<Servers> servers = this.serverService.getAll();

        if (servers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(servers, HttpStatus.OK);
    }

    @RequestMapping("/findall")
    public String findAll(){
        String result = "<html>";

        for(Servers cust : serverService.getAll()){
            result += "<div>" + cust.toString() + "</div>";
        }

        return result + "</html>";
    }

    @RequestMapping("/findbyid")
    public String findById(@RequestParam("id") long id){
        String result = "";
        result = serverService.getById(id).toString();
        return result;
    }*/
}
