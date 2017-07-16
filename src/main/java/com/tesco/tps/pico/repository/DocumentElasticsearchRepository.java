package com.tesco.tps.pico.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.tesco.tps.pico.domain.Domain;

/**
 * @author shashi
 *
 */
public interface DocumentElasticsearchRepository extends ElasticsearchRepository<Domain, String> {

}
