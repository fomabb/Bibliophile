package by.overone.bibliophile.service;

import by.overone.bibliophile.dto.BookDataDTO;
import by.overone.bibliophile.model.Books;
import by.overone.bibliophile.service.exception.ServiceException;

import java.util.List;

public interface BooksService {

    List<BookDataDTO> getAllBooks() throws ServiceException;
}
