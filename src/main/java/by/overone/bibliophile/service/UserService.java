package by.overone.bibliophile.service;

import by.overone.bibliophile.dao.exception.DAONotFoundException;
import by.overone.bibliophile.dto.UserDetailsDTO;
import by.overone.bibliophile.dto.UserGetAllDTO;
import by.overone.bibliophile.dto.UserRegistrationDTO;
import by.overone.bibliophile.service.exception.ServiceException;
import by.overone.bibliophile.service.exception.ServiceNotFoundException;

import java.util.List;

public interface UserService {

    List<UserGetAllDTO> getAllUsers() throws ServiceException, DAONotFoundException;

    List<UserGetAllDTO> getUsersByStatus() throws ServiceException;

    UserGetAllDTO getUserById(long id) throws ServiceException, ServiceNotFoundException;

    boolean addUser(UserRegistrationDTO user) throws ServiceException;

    void addUserDetails(long id, UserDetailsDTO userDetailsDTO) throws ServiceException, ServiceNotFoundException;
}
