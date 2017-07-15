package com.tesco.tps.pico.repository;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tesco.tps.pico.domain.Document;

/**
 * @author shashi
 *
 */
public interface DocumentRepository extends CrudRepository<Document, String> {

	@Query("Select * from DOCUMENT where documentName=?0   allow filtering")
	public Document findByDocumentName(String firstName);

	@Query("Select * from DOCUMENT where id=?0")
	public Document findById(String lastName);

}
