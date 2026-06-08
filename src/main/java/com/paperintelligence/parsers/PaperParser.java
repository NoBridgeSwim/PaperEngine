package com.paperintelligence.parsers;
import com.paperintelligence.model.ResearchPaper;

public interface PaperParser {
    ResearchPaper parse(String input);

}
