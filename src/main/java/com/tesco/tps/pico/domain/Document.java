package com.tesco.tps.pico.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

/**
 * @author shashi
 *
 */
@Table("DOCUMENT")
@org.springframework.data.elasticsearch.annotations.Document(indexName = "documentName", type = "documents")
public class Document implements Domain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 570309081437163453L;

	@PrimaryKey
	@Id
	private String id;

	private String documentName;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the documentName
	 */
	public String getDocumentName() {
		return documentName;
	}

	/**
	 * @param documentName
	 *            the documentName to set
	 */
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Document [id=" + id + ", documentName=" + documentName + "]";
	}

}
