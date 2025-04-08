package com.fool.knowledge_base;

import org.springframework.boot.SpringApplication;

public class TestKnowledgeBaseApplication {

	public static void main(String[] args) {
		SpringApplication.from(KnowledgeBaseApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
