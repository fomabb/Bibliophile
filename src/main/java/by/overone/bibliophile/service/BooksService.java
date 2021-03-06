package by.overone.bibliophile.service;

import by.overone.bibliophile.dto.BookDataDTO;
import by.overone.bibliophile.service.exception.ServiceException;
import by.overone.bibliophile.service.exception.ServiceNotFoundException;

import java.util.List;

public interface BooksService {

    List<BookDataDTO> getAllBooks() throws ServiceException;

    BookDataDTO getBooksById(long booksId) throws ServiceException, ServiceNotFoundException;
}
