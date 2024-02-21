package com.pdf.pdfGenerator.controller;

import java.io.ByteArrayInputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdf.pdfGenerator.service.PdfService;

@RestController
@CrossOrigin
public class PdfController {
	@Autowired
	PdfService pdfService;
	
	@GetMapping("/createpdf")
	public ResponseEntity<InputStreamResource> createPdf(HttpServletRequest httpServletRequest) {
	
		ByteArrayInputStream createdPdf = pdfService.createPdf();
		HttpHeaders http =  new HttpHeaders();
		http.add(" Content-Disposition", "inline;file = test.pdf");
		return ResponseEntity.ok().headers(http).contentType
				(MediaType.APPLICATION_PDF).body(new InputStreamResource(createdPdf));
	}
}
