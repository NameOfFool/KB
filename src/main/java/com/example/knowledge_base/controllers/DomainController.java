package com.example.knowledge_base.controllers;

import com.example.knowledge_base.exception.ResouceNotFoundException;
import com.example.knowledge_base.models.Domain;
import com.example.knowledge_base.repositories.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/domains")
@CrossOrigin(origins = "http://localhost:8000")
@RestController
public class DomainController {
    @Autowired
    private DomainRepository domainRepository;

    @GetMapping("/all")
    public @ResponseBody Iterable<Domain> getAllDomains(){
        return domainRepository.findAll();
    }
    @PostMapping("/add")
    public @ResponseBody Domain createDomain(@RequestBody Domain domain){
        return domainRepository.save(domain);
    }
    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Domain> getDomainById(@PathVariable Integer id){
        Domain d = domainRepository.findById(id).orElseThrow(() -> new ResouceNotFoundException("Domain doesn't exists"));
        return ResponseEntity.ok(d);
    }
    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<Map<String,Boolean>> deleteDomain(@PathVariable Integer id){
        Domain d = domainRepository.findById(id).orElseThrow(() -> new ResouceNotFoundException("Domain doesn't exists"));
        domainRepository.delete(d);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{id}")
    public @ResponseBody ResponseEntity<Domain> updateDomain(@PathVariable Integer id, @RequestBody Domain domainData){
        Domain d = domainRepository.findById(id).orElseThrow(() -> new ResouceNotFoundException("Domain doesn't exists"));
        d.setName(domainData.getName());
        d.setDescription(domainData.getDescription());

        Domain response = domainRepository.save(d);

        return ResponseEntity.ok(response);
    }
}
