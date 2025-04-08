package com.fool.knowledge_base.repository;

import com.fool.knowledge_base.domain.model.Domain;
import org.springframework.data.repository.CrudRepository;

public interface DomainRepository  extends CrudRepository<Domain,Integer> {

}
