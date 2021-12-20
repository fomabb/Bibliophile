package by.overone.bibliophile.dao.impl;

import by.overone.bibliophile.dao.BookDAO;
import by.overone.bibliophile.dao.exception.DAOException;
import by.overone.bibliophile.model.Books;
import by.overone.bibliophile.model.Genre;
import by.overone.bibliophile.util.constant.BooksConstant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BooksDAOImpl implements BookDAO {

    private final static String GET_ALL_BOOKS = "SELECT * FROM bibliophile.books";

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
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_BOOKS);
            ResultSet resultSet = preparedStatement.executeQuery();
            books = new ArrayList<>();

            while (resultSet.next()) {
                books1 = new Books();
                books1.setIdBook(resultSet.getLong(BooksConstant.ID));
                books1.setTitleBook(resultSet.getString(BooksConstant.TITLE));
                books1.setGenreBook(Genre.valueOf(resultSet.getString(BooksConstant.GENRE).toUpperCase(Locale.ROOT)));
                books1.setAuthor(resultSet.getString(BooksConstant.AUTOR));
                books1.setPrice(resultSet.getLong(BooksConstant.PRICE));
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
}
