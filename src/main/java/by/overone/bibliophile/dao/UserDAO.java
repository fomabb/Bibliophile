package by.overone.bibliophile.dao;

import by.overone.bibliophile.dao.exception.DAOException;
import by.overone.bibliophile.dao.exception.DAONotFoundException;
import by.overone.bibliophile.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUser() throws DAOException, DAONotFoundException;
}
