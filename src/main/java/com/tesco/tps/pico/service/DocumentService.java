package com.tesco.tps.pico.service;

import com.tesco.tps.pico.domain.Document;

/**
 * @author shashi
 *
 */
public interface DocumentService {

	public Document getDocumentByName(String name);

	public Document createDocument(Document doc);
}
