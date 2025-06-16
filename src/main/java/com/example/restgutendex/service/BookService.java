package com.example.restgutendex.service;

import com.example.restgutendex.dto.GutenbergBookDTO;
import com.example.restgutendex.entity.Book;
import com.example.restgutendex.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

private BookRepository bookRepository;
private RestTemplate restTemplate;

public BookService(BookRepository bookRepository){
    this.bookRepository = bookRepository;
    this.restTemplate= new RestTemplate();
}

// Buscar libros en la pagina  y guardarlos en la base de datos

public List<Book> fetchAndSaveBooks(){

    String url = "https://gutendex.com/books/?page=1";
    GutenbergBookDTO response = restTemplate.getForObject(url, GutenbergBookDTO.class);


    List<Book> books = response.getResults().stream()
            .map(dto-> Book.builder().id(dto.getId()).title(dto.getTitle()).
                    author(dto.getAuthors().isEmpty() ? "Unknown" : dto.getAuthors().get(0).getName())
                    .build()).collect(Collectors.toList());

    return  bookRepository.saveAll(books);

}

//Obtener los libros que se guardaron en la base de datos
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Guardar libro buscado por titulo
    public Book fetchAndSaveBookByTitle(String title) {
        String url = "https://gutendex.com/books/?search=" + title;
        GutenbergBookDTO response = restTemplate.getForObject(url, GutenbergBookDTO.class);

        if (response != null && !response.getResults().isEmpty()) {
            GutenbergBookDTO.BookItem dto = response.getResults().stream()
                    .filter(b -> b.getTitle().toLowerCase().contains(title.toLowerCase()))
                    .findFirst()
                    .orElse(null);

            if (dto == null) return null;

            Book book = Book.builder()
                    .id(dto.getId())
                    .title(dto.getTitle())
                    .author(dto.getAuthors().isEmpty() ? "Unknown" : dto.getAuthors().get(0).getName())
                    .build();

            return bookRepository.save(book);
        }

        return null;
    }





}
