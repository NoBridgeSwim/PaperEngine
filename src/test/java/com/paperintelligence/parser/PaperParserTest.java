package com.paperintelligence.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.paperintelligence.model.ResearchPaper;
import com.paperintelligence.parsers.XMLPaperParser;

class PaperParserTest {

    @Test
    void parsesKnownSections() throws IOException {
        ResearchPaper paper = XMLPaperParser.parseXmlFile(
                "src/test/java/com/resources/sample.xml");

        assertEquals(3, paper.getSections().size());
        assertEquals("Introduction", paper.getSections().get(0).getName());
        assertTrue(paper.getSections().get(0).getContent().contains("introduction text"));
    }
}