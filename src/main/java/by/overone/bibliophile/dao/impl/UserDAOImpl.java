package by.overone.bibliophile.dao.impl;

import by.overone.bibliophile.dao.UserDAO;
import by.overone.bibliophile.dao.exception.DAOException;
import by.overone.bibliophile.dao.exception.DAONotFoundException;
import by.overone.bibliophile.model.Role;
import by.overone.bibliophile.model.Status;
import by.overone.bibliophile.model.User;
import by.overone.bibliophile.util.constant.UserConstant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UserDAOImpl implements UserDAO {

    private final static String GET_ALL_USER_SQL = "SELECT * FROM users";
    private final static String GET_USER_BY_STATUS_SQL = "SELECT * FROM users WHERE user_status = ?";
    private final static String GET_ROLE_USER_SQL = "???";
    private final static String GET_ALL_BOOKS_SQL = "SELECT * FROM books WHERE ";

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
    public List<User> getAllUser() throws DAOException, DAONotFoundException {
        List<User> users;
        User user;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(GET_ALL_USER_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            users = new ArrayList<>();

            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong(UserConstant.ID));
                user.setLogin(resultSet.getString(UserConstant.LOGIN));
                user.setPassword(resultSet.getString(UserConstant.PASSWORD));
                user.setEmail(resultSet.getString(UserConstant.EMAIL));
                user.setRole(Role.valueOf(resultSet.getString(UserConstant.ROLE).toUpperCase(Locale.ROOT)));
                user.setStatus(Status.valueOf(resultSet.getString(UserConstant.STATUS).toUpperCase(Locale.ROOT)));
                users.add(user);
            }
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            throw new DAOException("Not found");
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("not connection");
            }
        }
        return users;
    }

    @Override
    public List<User> getUsersByStatus(Status status) throws DAOException {
        List<User> users = new ArrayList<>();
        User user;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_STATUS_SQL);
            preparedStatement.setString(1, status.toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong(UserConstant.ID));
                user.setLogin(resultSet.getString(UserConstant.LOGIN));
                user.setPassword(resultSet.getString(UserConstant.PASSWORD));
                user.setEmail(resultSet.getString(UserConstant.EMAIL));
                user.setRole(Role.valueOf(resultSet.getString(UserConstant.ROLE).toUpperCase(Locale.ROOT)));
                user.setStatus(Status.valueOf(resultSet.getString(UserConstant.STATUS).toUpperCase(Locale.ROOT)));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new DAOException("not found");
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("not connection");
            }
        }
        return users;
    }
}
