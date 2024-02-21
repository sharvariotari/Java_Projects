package com.pdf.pdfGenerator.serviceImpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Service;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.pdf.pdfGenerator.service.PdfService;


@Service
public class PdfServiceImpl implements PdfService {
	@Override
	public ByteArrayInputStream createPdf() {

		String title = "Testing pdf generator";
		String content = "this is for testing purpose";

		ByteArrayOutputStream outPut = new ByteArrayOutputStream();
		Document document = new Document();

		PdfWriter.getInstance(document, outPut);
		document.open();
		Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 25);
		Paragraph paragrah = new Paragraph(title, titleFont);
		paragrah.setAlignment(Element.ALIGN_CENTER);
		document.add(paragrah);

		Font contentFont = FontFactory.getFont(FontFactory.HELVETICA, 18);
		Paragraph paragrahContent = new Paragraph(content, contentFont);
		paragrahContent.add(new Chunk("This is loooking amazing"));
		document.add(paragrahContent);

		document.close();

		return new ByteArrayInputStream(outPut.toByteArray());
	}
}
