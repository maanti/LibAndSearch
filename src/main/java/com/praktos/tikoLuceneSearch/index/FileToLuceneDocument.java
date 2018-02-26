package com.praktos.tikoLuceneSearch.index;

import com.praktos.entity.Sources;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.index.IndexOptions;
import com.praktos.tikoLuceneSearch.Parser;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import java.io.IOException;

/**
 * We will use this class to convert messages to Lucene documents
 */
public class FileToLuceneDocument {

    /**
     * Creates Lucene Document using two strings: body and title
     *
     * @return resulted document
     */
    public static Document createWith(Sources source) throws TikaException, SAXException, IOException {
        Document document = new Document();

        FieldType textIndexedType = new FieldType();
        textIndexedType.setStored(true);
        textIndexedType.setIndexOptions(IndexOptions.DOCS);
        textIndexedType.setTokenized(true);

        Field id = new Field("id", source.getId().toString(), textIndexedType);
        Field name = new Field("name", source.getName(), textIndexedType);
        Field author = new Field("author", source.getAuthor(), textIndexedType);
        Field publisher = new Field("publisher", source.getPublisher(), textIndexedType);
        Field year = new Field("year", source.getYear(), textIndexedType);
        Field type = new Field("type", source.getType(), textIndexedType);
        Field link = new Field("link", source.getLink(), textIndexedType);
        Field tags = new Field("tags", source.getTags(), textIndexedType);
        Field path = new Field("path", source.getPath(), textIndexedType);
        Parser parser = new Parser();
        Field text = new Field("text", parser.parse(source.getPath()), textIndexedType);

        document.add(id);
        document.add(name);
        document.add(author);
        document.add(publisher);
        document.add(year);
        document.add(type);
        document.add(link);
        document.add(tags);
        document.add(path);
        document.add(text);

        return document;
    }
}
