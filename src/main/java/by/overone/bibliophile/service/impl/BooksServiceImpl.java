package by.overone.bibliophile.service.impl;

import by.overone.bibliophile.dao.BookDAO;
import by.overone.bibliophile.dao.exception.DAOException;
import by.overone.bibliophile.dao.impl.BooksDAOImpl;
import by.overone.bibliophile.dto.BookDataDTO;
import by.overone.bibliophile.model.Books;
import by.overone.bibliophile.service.BooksService;
import by.overone.bibliophile.service.exception.ServiceException;

import java.util.List;
import java.util.stream.Collectors;

public class BooksServiceImpl implements BooksService {
    BookDAO bookDAO = new BooksDAOImpl();

    @Override
    public List<BookDataDTO> getAllBooks() throws ServiceException {
        List<BookDataDTO> bookDataDTOS;
        try {
            List<Books> books = bookDAO.getAllBook();
            bookDataDTOS = books.stream()
                    .map(books1 -> new BookDataDTO(books1.getIdBook(), books1.getTitleBook(), books1.getGenreBook(),
                            books1.getAuthor(), books1.getPrice()))
                    .collect(Collectors.toList());
        } catch (DAOException e) {
            throw new ServiceException();
        }
        return bookDataDTOS;
    }
}
