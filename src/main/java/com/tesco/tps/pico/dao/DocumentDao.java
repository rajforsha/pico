package com.tesco.tps.pico.dao;

import com.tesco.tps.pico.domain.Document;

/**
 * @author shashi
 *
 */
public interface DocumentDao {

	public Document getDocumentByName(String name);

	public Document createDocument(Document doc);

}
