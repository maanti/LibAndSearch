package com.praktos.tikoLuceneSearch;
import com.praktos.entity.Sources;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Searcher {
    private IndexReader reader;

    public Searcher(IndexReader reader) { this.reader = reader; }

    /**
     * Search using FuzzyQuery.
     *
     * @param request    string to search
     * @param searchField field where to search. We have "body" and "title" fields
     * @param limit       how many results to return
     * @throws IOException
     */
    public List<Sources> fuzzySearch(String request, String searchField, int limit) throws IOException {
        IndexSearcher indexSearcher = new IndexSearcher(reader);

        Term term = new Term(searchField, request);

        int maxEdits = 2; // This is very important variable. It regulates fuzziness of the query
        Query query = new FuzzyQuery(term, maxEdits);
        TopDocs search = indexSearcher.search(query, limit);
        ScoreDoc[] hits = search.scoreDocs;
        return getHits(hits);
    }

    /**
     * Wrapper to fuzzySearch function.
     * It executed fuzzySearch with default limit and body field as target field
     *
     * @param request string to search
     * @throws IOException
     * @throws ParseException
     */
    public List<Sources> fuzzySearch(String request) throws IOException {
        int DEFAULT_LIMIT = 50;
        return fuzzySearch(request, "text", DEFAULT_LIMIT);
    }

    /**
     * @param hits
     * @return ArrayList of results (names of documents)
     * @throws IOException
     */
    private List<Sources> getHits(ScoreDoc[] hits) throws IOException {
        List<Sources> results = new ArrayList<>();
        List<Integer> alreadyInList = new ArrayList<>();
//        if (hits.length == 0) {
//            results.clear();
//            results.add("Ничего не найдено");
//            return results;
//        }
        // Search results
        for (ScoreDoc hit : hits) {
            String id = reader.document(hit.doc).get("id");
            if (alreadyInList.contains(Integer.parseInt(id))){
                continue;
            }
            alreadyInList.add(Integer.parseInt(id));
            String name = reader.document(hit.doc).get("name");
            String author = reader.document(hit.doc).get("author");
            String publisher = reader.document(hit.doc).get("publisher");
            String year = reader.document(hit.doc).get("year");
            String type = reader.document(hit.doc).get("type");
            String link = reader.document(hit.doc).get("link");
            String tags = reader.document(hit.doc).get("tags");
            String path = reader.document(hit.doc).get("path");

            Sources source = new Sources();
            source.setId(Integer.parseInt(id));
            source.setName(name);
            source.setAuthor(author);
            source.setPublisher(publisher);
            source.setYear(year);
            source.setType(type);
            source.setLink(link);
            source.setTags(tags);
            source.setPath(path);

            results.add(source);
        }
        return results;
    }
}
