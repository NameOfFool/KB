package com.fool.knowledge_base.controller;


import com.fool.knowledge_base.exception.ResouceNotFoundException;
import com.fool.knowledge_base.domain.model.Section;
import com.fool.knowledge_base.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api/sections/{sectionId}")
@CrossOrigin(origins = "http://localhost:8000")
@RestController
public class SectionController {
    @Autowired
    private SectionRepository sectionRepository;

    @GetMapping("/all")
    public @ResponseBody Iterable<Section> getAllsections(){
        return sectionRepository.findAll();
    }
    @PostMapping("/add")
    public @ResponseBody Section createsection(@RequestBody Section section){
        return sectionRepository.save(section);
    }
    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Section> getsectionById(@PathVariable Integer id){
        Section s = sectionRepository.findById(id).orElseThrow(() -> new ResouceNotFoundException("Section doesn't exists"));
        return ResponseEntity.ok(s);
    }
    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<Map<String,Boolean>> deletesection(@PathVariable Integer id){
        Section s = sectionRepository.findById(id).orElseThrow(() -> new ResouceNotFoundException("Section doesn't exists"));
        sectionRepository.delete(s);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{id}")
    public @ResponseBody ResponseEntity<Section> updatesection(@PathVariable Integer id, @RequestBody Section sectionData){
        Section s = sectionRepository.findById(id).orElseThrow(() -> new ResouceNotFoundException("Section doesn't exists"));
        s.setName(sectionData.getName());
        s.setDescription(sectionData.getDescription());

        Section response = sectionRepository.save(s);

        return ResponseEntity.ok(response);
    }
}
