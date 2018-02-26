package com.praktos.tikoLuceneSearch.index;

import com.praktos.entity.Sources;
import com.praktos.repository.SourcesRepository;
import org.apache.lucene.document.Document;
import org.apache.tika.exception.TikaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManualIndexer {
    @Autowired
    private static SourcesRepository sourcesRepository;
    public static void main(String[] args) throws IOException, TikaException, SAXException {
        List<Sources> sources = sourcesRepository.findSourcesByName("Проблемы создание многоуровневой системы распознавания речи");
        List<Document> documents = new ArrayList<>();
        documents.add(FileToLuceneDocument.createWith(sources.get(0)));
        sources.clear();
        sources = sourcesRepository.findSourcesByName("Speech And Audio Signal Processing");
        documents.add(FileToLuceneDocument.createWith(sources.get(0)));
        DocumentIndexer indexer = new DocumentIndexer();
        indexer.index(true, documents);
    }
}
