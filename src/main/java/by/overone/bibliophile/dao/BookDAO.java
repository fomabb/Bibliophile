package by.overone.bibliophile.dao;

import by.overone.bibliophile.dao.exception.DAOException;
import by.overone.bibliophile.dao.exception.DAONotFoundException;
import by.overone.bibliophile.model.Books;

import java.util.List;

public interface BookDAO {

    List<Books> getAllBook() throws DAOException;

    Books getBooksById(long bookId) throws DAOException, DAONotFoundException;
}
