package by.overone.bibliophile.dao;

import by.overone.bibliophile.dao.exception.DAOException;
import by.overone.bibliophile.dao.exception.DAOExistException;
import by.overone.bibliophile.dao.exception.DAONotFoundException;
import by.overone.bibliophile.dto.UserAllInfoDTO;
import by.overone.bibliophile.dto.UserDataDTO;
import by.overone.bibliophile.dto.UserDetailsDTO;
import by.overone.bibliophile.dto.UserRegistrationDTO;
import by.overone.bibliophile.model.Status;
import by.overone.bibliophile.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    List<User> getAllUser() throws DAOException, DAONotFoundException;

//    List<User> getUsersByStatus(Status status) throws DAOException;
//
//    User getUserById(long id) throws DAONotFoundException, DAOException;
//
//    User addUser(User user) throws DAOException;
//
//    UserDetailsDTO getUserDetails(long userId) throws DAOException;
//
//    UserAllInfoDTO getInfoUsers(long userId);
//
//    boolean deleteUser(long id) throws DAONotFoundException, DAOException;
}
