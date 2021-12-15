package by.overone.bibliophile.dao.impl;

import by.overone.bibliophile.dao.UserDAO;
import by.overone.bibliophile.dao.exception.DAOException;
import by.overone.bibliophile.dao.exception.DAONotFoundException;
import by.overone.bibliophile.model.Role;
import by.overone.bibliophile.model.User;
import by.overone.bibliophile.util.constant.UserConstant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UserDAOImpl implements UserDAO {

    private final static String GET_ALL_USER_SQL = "SELECT * FROM users";
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
                user.setUserId(resultSet.getLong(UserConstant.ID));
                user.setUserLogin(resultSet.getString(UserConstant.LOGIN));
                user.setUserPassword(resultSet.getString(UserConstant.PASSWORD));
                user.setUserEmail(resultSet.getString(UserConstant.EMAIL));
                user.setUserRole(Role.valueOf(resultSet.getString(UserConstant.ROLE).toUpperCase(Locale.ROOT)));
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
    public List<User> getRoleUser() throws DAOException {
        List<User> users = new ArrayList<>();
        User user = new User();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ROLE_USER_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next() && resultSet.equals(getRoleUser())) {

                while (resultSet.next()) {
                    user.setUserId(resultSet.getLong(UserConstant.ID));
                    user.setUserLogin(resultSet.getString(UserConstant.LOGIN));
                    user.setUserPassword(resultSet.getString(UserConstant.PASSWORD));
                    user.setUserEmail(resultSet.getString(UserConstant.EMAIL));
                    user.setUserRole(Role.valueOf(resultSet.getString(UserConstant.ROLE).toUpperCase(Locale.ROOT)));
                    users.add(user);
                }
            } else {
                throw new DAOException("Not found");
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
