package com.tesco.tps.pico.beanconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tesco.tps.pico.dao.DocumentDao;
import com.tesco.tps.pico.daoImpl.DocumentDaoImpl;
import com.tesco.tps.pico.service.DocumentService;
import com.tesco.tps.pico.serviceImpl.DocumentServiceImpl;

/**
 * @author shashi
 *
 */
@Configuration
public class DocumentConfig {

	@Bean
	public DocumentDao documentDao() {
		return new DocumentDaoImpl();
	}

	@Bean
	public DocumentService documentService() {
		return new DocumentServiceImpl();
	}

}
