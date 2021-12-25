package by.overone.bibliophile.service;

import by.overone.bibliophile.dao.exception.DAOException;
import by.overone.bibliophile.dao.exception.DAONotFoundException;
import by.overone.bibliophile.dto.*;
import by.overone.bibliophile.service.exception.ServiceException;
import by.overone.bibliophile.service.exception.ServiceNotFoundException;
import by.overone.bibliophile.util.validation.exception.ValidateException;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    List<UserGetAllDTO> getAllUsers() throws ServiceException, DAONotFoundException, DAOException;

//    List<UserGetAllDTO> getUsersByStatus() throws ServiceException;
//
//    UserGetAllDTO getUserById(long id) throws ServiceException, ServiceNotFoundException;
//
//    UserDataDTO addUser(UserRegistrationDTO userRegistrationDTO) throws ValidateException, ServiceException;
//
//    UserDetailsDTO getUserDetails(long userId) throws ServiceException;
//
//    UserAllInfoDTO getUserAllInfo(long userId);
//
//    void deleteUser(long id) throws ServiceException, ServiceNotFoundException;
}
