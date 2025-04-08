package com.example.knowledge_base.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "domains")
public class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @OneToMany(mappedBy = "domain",cascade = {
            CascadeType.ALL
    })
    private List<Section> sections;

    public Domain(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public Domain(){

    }

    public Integer getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public List<Section> getSections(){
        return sections;
    }

    public void setId(Integer id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setSections(List<Section> sections){
        this.sections = sections;
    }
}
