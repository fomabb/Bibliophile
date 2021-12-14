package by.overone.bibliophile.dao.impl;

import by.overone.bibliophile.dao.UserDAO;
import by.overone.bibliophile.dao.exception.DAOException;
import by.overone.bibliophile.dao.exception.DAONotFoundException;
import by.overone.bibliophile.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private final static String GET_ALL_USER_SQL = "SELECT * FROM users WHERE = user_role = ?";

    String url = "jdbc:mysql://localhost:3306/internetshop";
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
    public List<User> getAllUserRole() throws DAOException, DAONotFoundException {
        List<User> users;
        User user;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(GET_ALL_USER_SQL);
        } catch (SQLException e) {
            throw new DAOException("Not connect");
        }
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            users = new ArrayList<>();

            while (resultSet.next()) {
                user = new User();
                user.setUserId(resultSet.getLong());
            }
        } catch (SQLException e) {
           throw new DAONotFoundException("Not users");
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error: [" + e + "]");
            }
        }

        return null;
    }
}
