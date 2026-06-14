package com.paperintelligence;

import java.io.IOException;

import com.paperintelligence.model.ResearchPaper;
import com.paperintelligence.parsers.XMLPaperParser;

public class PaperProcessingPipeline {

    public ResearchPaper processXml(String xmlFilePath) throws IOException {
        return XMLPaperParser.parseXmlFile(xmlFilePath);
    }
}