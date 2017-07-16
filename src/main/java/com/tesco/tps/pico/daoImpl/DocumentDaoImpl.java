package com.tesco.tps.pico.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.tesco.tps.pico.dao.DocumentDao;
import com.tesco.tps.pico.domain.Document;
import com.tesco.tps.pico.repository.DocumentCassandraRepository;
import com.tesco.tps.pico.util.AsyncDataReplication;

/**
 * @author shashi
 *
 */
public class DocumentDaoImpl implements DocumentDao {

	@Autowired
	private DocumentCassandraRepository repository;

	/**
	 * @return the repository
	 */
	public DocumentCassandraRepository getRepository() {
		return repository;
	}

	public Document getDocumentByName(String name) {
		return getRepository().findByDocumentName(name);
	}

	public Document createDocument(Document doc) {
		try {
			AsyncDataReplication.queue.put(doc);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getRepository().save(doc);
	}

}
