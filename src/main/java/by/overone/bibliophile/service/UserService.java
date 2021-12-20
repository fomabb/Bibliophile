package by.overone.bibliophile.service;

import by.overone.bibliophile.dao.exception.DAONotFoundException;
import by.overone.bibliophile.dto.UserDataDTO;
import by.overone.bibliophile.dto.UserDetailsDTO;
import by.overone.bibliophile.dto.UserGetAllDTO;
import by.overone.bibliophile.dto.UserRegistrationDTO;
import by.overone.bibliophile.service.exception.ServiceException;
import by.overone.bibliophile.service.exception.ServiceNotFoundException;
import by.overone.bibliophile.util.validation.exception.ValidateException;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    List<UserGetAllDTO> getAllUsers() throws ServiceException, DAONotFoundException;

    List<UserGetAllDTO> getUsersByStatus() throws ServiceException;

    UserGetAllDTO getUserById(long id) throws ServiceException, ServiceNotFoundException;

    UserDataDTO addUser(UserRegistrationDTO userRegistrationDTO) throws ValidateException, ServiceException;

    UserDetailsDTO getUserDetails(long userId) throws ServiceException;

    void deleteUser(long id) throws ServiceException, ServiceNotFoundException;
}
