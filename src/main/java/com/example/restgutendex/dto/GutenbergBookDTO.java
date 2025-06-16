package com.example.restgutendex.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



import java.util.List;





@JsonIgnoreProperties(ignoreUnknown = true) // anotacion para ignorar campos no mapeados solicitados a Gutendex
public class GutenbergBookDTO {


    private List<BookItem> results;

    public List<BookItem> getResults() {
        return results;
    }

    public void setResults(List<BookItem> results) {
        this.results = results;
    }

    // Clase interna para cada libro
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BookItem {
        private Long id;
        private String title;
        private List<Author> authors;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<Author> getAuthors() {
            return authors;
        }

        public void setAuthors(List<Author> authors) {
            this.authors = authors;
        }
    }

    // Clase interna para cada autor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Author {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
