package com.pdf.pdfGenerator.service;

import java.io.ByteArrayInputStream;

import org.springframework.stereotype.Service;
@Service
public interface PdfService {
	 public ByteArrayInputStream createPdf();
}
