package by.overone.bibliophile.dao.impl;

import by.overone.bibliophile.dao.BookDAO;
import by.overone.bibliophile.dao.exception.DAOException;
import by.overone.bibliophile.dao.exception.DAONotFoundException;
import by.overone.bibliophile.model.Books;
import by.overone.bibliophile.model.Genre;
import by.overone.bibliophile.model.Status;
import by.overone.bibliophile.util.constant.BooksConstant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BooksDAOImpl implements BookDAO {

    private final static String GET_ALL_BOOKS_SQL = "SELECT * FROM bibliophile.books";
    private final static String GET_BOOKS_BY_ID_SQL = "SELECT * FROM books WHERE book_id = ?";

    String url = "jdbc:mysql://localhost:3306/bibliophile";
    String dbUser = "root";
    String password = "5203251";

    Connection connection;

    {
        try {
            connection = DriverManager.getConnection(url, dbUser, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Books> getAllBook() throws DAOException {
        List<Books> books;
        Books books1;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_BOOKS_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            books = new ArrayList<>();

            while (resultSet.next()) {
                books1 = new Books();
                books1.setIdBook(resultSet.getLong(BooksConstant.ID));
                books1.setTitleBook(resultSet.getString(BooksConstant.TITLE));
                books1.setGenreBook(Genre.valueOf(resultSet.getString(BooksConstant.GENRE).toUpperCase(Locale.ROOT)));
                books1.setAuthor(resultSet.getString(BooksConstant.AUTHOR));
                books1.setPrice(resultSet.getLong(BooksConstant.PRICE));
                books1.setStatus(Status.valueOf(resultSet.getString(BooksConstant.STATUS)));
                books.add(books1);
            }
        } catch (SQLException e) {
            throw new DAOException("not connection");
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return books;
    }

    @Override
    public Books getBooksById(long bookId) throws DAOException, DAONotFoundException {
        Books books = new Books();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_BOOKS_BY_ID_SQL);
            preparedStatement.setLong(1, bookId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                books.setIdBook(resultSet.getLong(BooksConstant.ID));
                books.setTitleBook(resultSet.getString(BooksConstant.TITLE));
                books.setGenreBook(Genre.valueOf(resultSet.getString(BooksConstant.GENRE).toUpperCase(Locale.ROOT)));
                books.setAuthor(resultSet.getString(BooksConstant.AUTHOR));
                books.setPrice(resultSet.getLong(BooksConstant.PRICE));
                books.setStatus(Status.valueOf(resultSet.getString(BooksConstant.STATUS).toUpperCase(Locale.ROOT)));
            } else {
                throw new DAONotFoundException("not books");
            }
        } catch (SQLException e) {
            throw new DAOException("not connection");
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return books;
    }
}
