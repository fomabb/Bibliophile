package by.overone.bibliophile.service.impl;

import by.overone.bibliophile.dao.UserDAO;
import by.overone.bibliophile.dao.exception.DAOException;
import by.overone.bibliophile.dao.exception.DAONotFoundException;
import by.overone.bibliophile.dao.impl.UserDAOImpl;
import by.overone.bibliophile.dto.UserGetAllDTO;
import by.overone.bibliophile.model.Status;
import by.overone.bibliophile.model.User;
import by.overone.bibliophile.service.UserService;
import by.overone.bibliophile.service.exception.ServiceException;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    UserDAO userDAO = new UserDAOImpl();

    @Override
    public List<UserGetAllDTO> getAllUsers() throws ServiceException, DAONotFoundException {
        List<UserGetAllDTO> userGetAllDTOS;
        try {
            List<User> users = userDAO.getAllUser();
            userGetAllDTOS = users.stream()
                    .map(user -> new UserGetAllDTO(user.getId(), user.getLogin(), user.getEmail(), user.getRole(), user.getStatus()))
                    .collect(Collectors.toList());
        } catch (DAOException e) {
            throw new ServiceException();
        }
        return userGetAllDTOS;
    }

    @Override
    public List<UserGetAllDTO> getUsersByStatus() throws ServiceException {
        List<UserGetAllDTO> userGetAllDTOS;
        try {
            List<User> users = userDAO.getUsersByStatus(Status.ACTIVE);
            userGetAllDTOS = users.stream()
                    .map(user -> new UserGetAllDTO(user.getId(), user.getLogin(), user.getEmail(), user.getRole(), user.getStatus()))
                    .collect(Collectors.toList());
        } catch (DAOException e) {
            throw new ServiceException("not connection", e);
        }
        return userGetAllDTOS;
    }

    @Override
    public UserGetAllDTO getUserById(long id) throws ServiceException {
        UserGetAllDTO userGetAllDTO = new UserGetAllDTO();
        try {
            User user = userDAO.getUserById(id);
            user.setId(user.getId());
            user.setLogin(user.getLogin());
            user.setEmail(user.getEmail());
            user.setRole(user.getRole());
            user.setStatus(user.getStatus());
        } catch (DAOException e) {
            throw new ServiceException("not connection");
        } catch (DAONotFoundException e ) {
            throw new ServiceException("User with id " +id+ " not found", e);
        }
        return userGetAllDTO;
    }
}


