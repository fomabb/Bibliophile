package by.overone.bibliophile.service.impl;

import by.overone.bibliophile.dao.UserDAO;
import by.overone.bibliophile.dao.exception.DAOException;
import by.overone.bibliophile.dao.exception.DAONotFoundException;
import by.overone.bibliophile.dao.impl.UserDAOImpl;
import by.overone.bibliophile.dto.UserGetAllDTO;
import by.overone.bibliophile.dto.UserRoleGetDTO;
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
                    .map(user -> new UserGetAllDTO(user.getUserId(), user.getUserLogin(), user.getUserEmail(), user.getUserRole()))
                    .collect(Collectors.toList());
        } catch (DAOException e) {
            throw new ServiceException();
        }
        return userGetAllDTOS;
    }

    @Override
    public List<UserRoleGetDTO> getRoleUsers() throws ServiceException {
        List<UserRoleGetDTO> userRoleGetDTOS;
        try {
            List<User> users = userDAO.getRoleUser();
            userRoleGetDTOS = users.stream()
                    .map(user -> new UserRoleGetDTO(user.getUserId(), user.getUserLogin(), user.getUserEmail(), user.getUserRole()))
                    .collect(Collectors.toList());
        } catch (DAOException e) {
            throw new ServiceException();
        }
        return userRoleGetDTOS;
    }
}
