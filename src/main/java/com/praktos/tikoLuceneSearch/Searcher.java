package com.praktos.tikoLuceneSearch;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
public class Searcher {
    private static final String teaserTitle = "Привет, Влад и Ксюша!";

    public void search
    public static void main(String[] args) throws IOException, ParseException, TikaException, SAXException {
        Teaser teaser = new Teaser();
        String teaserBody = teaser.parseAnything("/Users/manti/1.pdf");
        final Document teaserDoc = MessageToDocument.createWith(teaserTitle, teaserBody);
        final MessageIndexer indexer = new MessageIndexer("/tmp/teaser_index");
        indexer.index(true, teaserDoc);

        final BasicSearchExamples search = new BasicSearchExamples(indexer.readIndex());

        final Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.print("Введите запрос:\t");
        final String toSearch = reader.nextLine(); // Scans the next token

        search.fuzzySearch(toSearch);
    }

    public String parseAnything(String path) throws IOException, SAXException, TikaException {
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        FileInputStream fileInputStream = new FileInputStream(new File(path));
        ParseContext parseContext = new ParseContext();

        //parsing the document using PDF parser
        PDFParser pdfparser = new PDFParser();
        pdfparser.parse(fileInputStream, handler, metadata, parseContext);

        //getting the content of the document
        System.out.println("Contents of the PDF :" + handler.toString());

        //getting metadata of the document
        System.out.println("Metadata of the PDF:");
        String[] metadataNames = metadata.names();

        for(String name : metadataNames) {
            System.out.println(name+ " : " + metadata.get(name));
        }
        return handler.toString();
    }
}
