package by.overone.bibliophile.dao.impl;

import by.overone.bibliophile.dao.UserDAO;
import by.overone.bibliophile.dao.exception.DAOException;
import by.overone.bibliophile.dao.exception.DAOExistException;
import by.overone.bibliophile.dao.exception.DAONotFoundException;
import by.overone.bibliophile.dto.UserAllInfoDTO;
import by.overone.bibliophile.dto.UserDataDTO;
import by.overone.bibliophile.dto.UserDetailsDTO;
import by.overone.bibliophile.dto.UserRegistrationDTO;
import by.overone.bibliophile.model.Role;
import by.overone.bibliophile.model.Status;
import by.overone.bibliophile.model.User;
import by.overone.bibliophile.util.constant.UserConstant;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Repository
@AllArgsConstructor
public class UserDAOImpl implements UserDAO {

    private final static String GET_ALL_USER_SQL = "SELECT * FROM users";
    private final static String GET_USER_BY_STATUS_SQL = "SELECT * FROM users WHERE user_status = ?";
    private final static String GET_USER_BY_ID_SQL = "SELECT * FROM users WHERE user_id = ?";
    private final static String REGISTRATION_USER_SQL = "INSERT INTO users VALUE(0, ?, ?, ?, ?, ?)";
    private final static String GET_USER_DETAILS_BY_ID = "SELECT * FROM user_details WHERE users_user_id = ?";
    private final static String ADD_USER_DETAILS_ID_SQL = "INSERT INTO user_details(users_user_id) VALUE(?)";
    private final static String GET_INFO_SQL = "SELECT * FROM users JOIN user_details ON user_id = users_user_id WHERE user_id = ?";
    private final static String UPDATE_USER_STATUS_SQL = "UPDATE user SET status =(?) WHERE id=(?)";
    private final static String ADD_USER_DETAILS_SQL = "UPDATE user_details SET user_details_name=?, " +
            "user_detail_surname=?, user_detail_address=?, user_detail_phone=? WHERE users_user_id=?";
    private final static String DELETE_USER_SQL = "UPDATE users SET user_status=? WHERE user_id=?";
    private final static String GET_ALL_BOOKS_SQL = "SELECT * FROM books WHERE ";

    private final JdbcTemplate jdbcTemplate;

//    String url = "jdbc:mysql://localhost:3306/bibliophile";
//    String dbUser = "root";
//    String password = "5203251";
//
//    Connection connection;
//
//    {
//        try {
//            connection = DriverManager.getConnection(url, dbUser, password);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public List<User> getAllUser() throws DAOException, DAONotFoundException {
        List<User> users = jdbcTemplate.query(GET_ALL_USER_SQL, new BeanPropertyRowMapper<>(User.class));
        return users;

//        List<User> users;
//        User user;
//        PreparedStatement preparedStatement;
//        try {
//            preparedStatement = connection.prepareStatement(GET_ALL_USER_SQL);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            users = new ArrayList<>();
//
//            while (resultSet.next()) {
//                user = new User();
//                user.setId(resultSet.getLong(UserConstant.ID));
//                user.setLogin(resultSet.getString(UserConstant.LOGIN));
//                user.setPassword(resultSet.getString(UserConstant.PASSWORD));
//                user.setEmail(resultSet.getString(UserConstant.EMAIL));
//                user.setRole(Role.valueOf(resultSet.getString(UserConstant.ROLE).toUpperCase(Locale.ROOT)));
//                user.setStatus(Status.valueOf(resultSet.getString(UserConstant.STATUS).toUpperCase(Locale.ROOT)));
//                users.add(user);
//            }
//            preparedStatement.close();
//            resultSet.close();
//        } catch (SQLException e) {
//            throw new DAOException("Not found", e);
//        } finally {
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                System.out.println("not connection");
//            }
//        }
//        return users;
    }

//    @Override
//    public List<User> getUsersByStatus(Status status) throws DAOException {
//        List<User> users = new ArrayList<>();
//        User user;
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_STATUS_SQL);
//            preparedStatement.setString(1, status.toString());
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                user = new User();
//                user.setId(resultSet.getLong(UserConstant.ID));
//                user.setLogin(resultSet.getString(UserConstant.LOGIN));
//                user.setPassword(resultSet.getString(UserConstant.PASSWORD));
//                user.setEmail(resultSet.getString(UserConstant.EMAIL));
//                user.setRole(Role.valueOf(resultSet.getString(UserConstant.ROLE).toUpperCase(Locale.ROOT)));
//                user.setStatus(Status.valueOf(resultSet.getString(UserConstant.STATUS).toUpperCase(Locale.ROOT)));
//                users.add(user);
//            }
//            preparedStatement.close();
//            resultSet.close();
//        } catch (SQLException e) {
//            throw new DAOException("not found");
//        } finally {
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                System.out.println("not connection");
//            }
//        }
//        return users;
//    }
//
//    @Override
//    public User getUserById(long id) throws DAONotFoundException, DAOException {
//        User user = new User();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_ID_SQL);
//            preparedStatement.setLong(1, id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//
//            if (resultSet.next()) {
//                user.setId(resultSet.getLong(UserConstant.ID));
//                user.setLogin(resultSet.getString(UserConstant.LOGIN));
//                user.setPassword(resultSet.getString(UserConstant.PASSWORD));
//                user.setEmail(resultSet.getString(UserConstant.EMAIL));
//                user.setRole(Role.valueOf(resultSet.getString(UserConstant.ROLE).toUpperCase(Locale.ROOT)));
//                user.setStatus(Status.valueOf(resultSet.getString(UserConstant.STATUS).toUpperCase(Locale.ROOT)));
//            } else {
//                throw new DAONotFoundException("not users");
//            }
//            preparedStatement.close();
//            resultSet.close();
//        } catch (SQLException e) {
//            throw new DAOException("not connect");
//        } finally {
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return user;
//    }
//
//    @Override
//    public User addUser(User user) throws DAOException {
//        try {
//            connection.setAutoCommit(false);
//            PreparedStatement preparedStatement = connection.prepareStatement(REGISTRATION_USER_SQL, Statement.RETURN_GENERATED_KEYS);
//            preparedStatement.setString(1, user.getLogin());
//            preparedStatement.setString(2, user.getPassword());
//            preparedStatement.setString(3, user.getEmail());
//            preparedStatement.setString(4, Role.CUSTOMERS.toString());
//            preparedStatement.setString(5, Status.ACTIVE.toString());
//            preparedStatement.executeUpdate();
//
//            ResultSet resultSet = preparedStatement.getGeneratedKeys();
//
//            while (resultSet.next()) {
//                user.setId(resultSet.getLong(1));
//                preparedStatement = connection.prepareStatement(ADD_USER_DETAILS_ID_SQL);
//                preparedStatement.setLong(1, user.getId());
//                preparedStatement.executeUpdate();
//            }
//            connection.commit();
//            connection.setAutoCommit(true);
//        } catch (SQLException e) {
//            try {
//                try {
//                    connection.rollback();
//                } catch (SQLException ex) {
//                    ex.printStackTrace();
//                }
//                throw new DAOException("Error", e);
//            } finally {
//                try {
//                    connection.close();
//                } catch (SQLException ex) {
//                    ex.printStackTrace();
//                }
//            }
//        }
//        return user;
//    }
//
//    @Override
//    public UserDetailsDTO getUserDetails(long userId) throws DAOException {
//        UserDetailsDTO userDetailsDTO;
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_DETAILS_BY_ID);
//            preparedStatement.setLong(1, userId);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            userDetailsDTO = new UserDetailsDTO();
//            while (resultSet.next()) {
//                userDetailsDTO.setName(resultSet.getString(UserConstant.NAME));
//                userDetailsDTO.setSurname(resultSet.getString(UserConstant.SURNAME));
//                userDetailsDTO.setAddress(resultSet.getString(UserConstant.ADDRESS));
//                userDetailsDTO.setPhoneNumber(resultSet.getString(UserConstant.PHONE));
//            }
//        } catch (SQLException e) {
//            throw new DAOException("not connection");
//        }finally {
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return userDetailsDTO;
//    }
//
//    @Override
//    public UserAllInfoDTO getInfoUsers(long userId) {
//        UserAllInfoDTO userAllInfoDTO = null;
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(GET_INFO_SQL);
//            preparedStatement.setLong(1, userId);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            userAllInfoDTO = new UserAllInfoDTO();
//            while (resultSet.next()) {
//                userAllInfoDTO.setLogin(resultSet.getString(UserConstant.LOGIN));
//                userAllInfoDTO.setPassword(resultSet.getString(UserConstant.PASSWORD));
//                userAllInfoDTO.setEmail(resultSet.getString(UserConstant.EMAIL));
//                userAllInfoDTO.setRole(Role.valueOf(resultSet.getString(UserConstant.ROLE).toUpperCase(Locale.ROOT)));
//                userAllInfoDTO.setStatus(Status.valueOf(resultSet.getString(UserConstant.STATUS).toUpperCase(Locale.ROOT)));
//                userAllInfoDTO.setName(resultSet.getString(UserConstant.NAME));
//                userAllInfoDTO.setSurName(resultSet.getString(UserConstant.SURNAME));
//                userAllInfoDTO.setAddress(resultSet.getString(UserConstant.ADDRESS));
//                userAllInfoDTO.setPhoneNumber(resultSet.getString(UserConstant.PHONE));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return userAllInfoDTO;
//    }
//
//    @Override
//    public boolean deleteUser(long id) throws DAONotFoundException {
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_SQL);
//            preparedStatement.setString(1, Status.INACTIVE.toString());
//            preparedStatement.setLong(2, id);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            throw new DAONotFoundException("Deletion was not successful", e);
//        } finally {
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return true;
//    }
}
