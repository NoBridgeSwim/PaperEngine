package com.paperintelligence.parsers;

import java.io.File;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfToStr {
    public static String extractPDFText() {

        String pdfFilePath = System.getenv("PDF_FILEPATH");

        // Path check first
        if (pdfFilePath == null || pdfFilePath.isBlank()) {
            System.out.println("PDF_FILEPATH not found. End of run.");
            return "";

        }

        try {
            File file = new File(pdfFilePath);
            try (PDDocument document = Loader.loadPDF(file)) {
                PDFTextStripper stripper = new PDFTextStripper();

                return stripper.getText(document);

            }

        } catch (Exception e) {
            System.out.println("PDF not found.");
            e.printStackTrace();
            System.out.println("End of run.");
            return "";

        }

    }

}
