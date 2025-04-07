package com.example.knowledge_base.models;

import jakarta.persistence.*;

@Entity
@Table(name = "sections")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="domain_id", referencedColumnName = "id")
    private Domain domain;

    public Section(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public Section(){

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
    public Domain getDomain(){
        return domain;
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
    public void setDomain(Domain domain){
        this.domain = domain;
    }
}
