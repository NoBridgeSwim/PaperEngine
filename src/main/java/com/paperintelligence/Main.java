package com.paperintelligence;

import java.io.IOException;

import com.paperintelligence.model.ResearchPaper;
import com.paperintelligence.parsers.PaperParser;
import com.paperintelligence.parsers.PdfToStr;
import com.paperintelligence.parsers.PlainTextParser;
import com.paperintelligence.parsers.TextNormalizer;

//stores parsing logic, beggining with PaperParser
public class Main {
    public static void main(String[] args) throws IOException {

        String rawText = PdfToStr.extractPDFText();

        // Temporary console logs
        // System.out.println("===== RAW PDF TEXT START =====");
        // System.out.println(rawText);
        // System.out.println("===== RAW PDF TEXT END =====");

        String cleanText = TextNormalizer.removeFootMetaData(rawText, "OPEN ACCESS", "Resource");

        // Temporary console logs
        System.out.println("===== CLEAN TEXT START =====");
        System.out.println(cleanText);
        System.out.println("===== CLEAN TEXT END =====");
        PaperParser parser = new PlainTextParser();
        ResearchPaper paper = parser.parse(cleanText);

        System.out.println("Sections found:");
        System.out.println(paper);
        paper.getSections().forEach(section -> System.out.println(section.getName()));

    }

}
