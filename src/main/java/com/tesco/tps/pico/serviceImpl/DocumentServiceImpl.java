package com.tesco.tps.pico.serviceImpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.tesco.tps.pico.dao.DocumentDao;
import com.tesco.tps.pico.domain.Document;
import com.tesco.tps.pico.service.DocumentService;

/**
 * @author shashi
 *
 */
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentDao documentDao;

	public DocumentDao getDocumentDao() {
		return documentDao;
	}

	@Override
	public Document getDocumentByName(String name) {
		return getDocumentDao().getDocumentByName(name);
	}

	@Override
	public Document createDocument(Document doc) {
		doc.setId(UUID.randomUUID().toString());// need to fix cassandra 16 bit
		return getDocumentDao().createDocument(doc);
	}

}
