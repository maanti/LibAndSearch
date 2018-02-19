package com.praktos.tikoLuceneSearch;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Parser {
    public String parse(String path) throws IOException, SAXException, TikaException {
        BodyContentHandler handler = new BodyContentHandler(-1);
        Metadata metadata = new Metadata();
        ParseContext parseContext = new ParseContext();

        AutoDetectParser autoDetectParser = new AutoDetectParser();
        try (FileInputStream fileInputStream = new FileInputStream(new File(path))) {
            autoDetectParser.parse(fileInputStream, handler, metadata, parseContext);
            return handler.toString();
        }
    }
}
