package com.tesco.tps.pico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesco.tps.pico.domain.Document;
import com.tesco.tps.pico.service.DocumentService;

/**
 * @author shashi
 *
 */
@RestController
public class DocumentController {

	@Autowired
	private DocumentService documentService;

	/**
	 * @return the docDao
	 */
	public DocumentService getDocumentService() {
		return documentService;
	}

	@RequestMapping("/getDocument/{name}")
	@GetMapping
	public Document getDocuemntById(@PathVariable String name) {
		return getDocumentService().getDocumentByName(name);
	}

	@RequestMapping("/createDocument")
	@PostMapping
	public Document getDocuemnt(@RequestBody Document doc) {
		return getDocumentService().createDocument(doc);
	}
}
