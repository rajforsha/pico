package com.tesco.tps.pico.beanconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tesco.tps.pico.dao.DocumentDao;
import com.tesco.tps.pico.daoImpl.DocumentDaoImpl;

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

}
