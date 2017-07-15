package com.tesco.tps.pico.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.datastax.driver.core.utils.UUIDs;
import com.tesco.tps.pico.dao.DocumentDao;
import com.tesco.tps.pico.domain.Document;
import com.tesco.tps.pico.repository.DocumentRepository;

/**
 * @author shashi
 *
 */
public class DocumentDaoImpl implements DocumentDao {

	@Autowired
	private DocumentRepository repository;

	/**
	 * @return the repository
	 */
	public DocumentRepository getRepository() {
		return repository;
	}

	public Document getDocumentByName(String name) {
		return getRepository().findByDocumentName(name);
	}

	public Document createDocument(Document doc) {
		doc.setId(UUIDs.timeBased());
		return getRepository().save(doc);
	}

}
