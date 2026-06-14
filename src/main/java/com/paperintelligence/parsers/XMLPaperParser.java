package com.paperintelligence.parsers;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import com.paperintelligence.model.PaperSection;
import com.paperintelligence.model.ResearchPaper;

public class XMLPaperParser {
    public static ResearchPaper parseXmlFile(String xmlFilePath) throws IOException {
        if (xmlFilePath == null || xmlFilePath.isBlank()) {
            throw new IllegalArgumentException("XML file path is missing or empty");
        }

        File file = new File(xmlFilePath);

        if (!file.exists()) {
            throw new IOException("XML file not found:" + file.getAbsolutePath());
        }

        Document doc = Jsoup.parse(file, "UTF-8", "", Parser.xmlParser());

        ResearchPaper paper = new ResearchPaper();

        Elements sections = doc.select("body > sec");

        for (Element sec : sections) {
            Element titleElement = sec.selectFirst("title");

            String sectionName = titleElement != null ? titleElement.text() : "UNKNOWN";

            sec.select("fig, table-wrap, ref-list").remove();

            String sectionText = sec.select("p").text();

            paper.addSection(new PaperSection(sectionName, sectionText));
        }

        return paper;

    }
}
