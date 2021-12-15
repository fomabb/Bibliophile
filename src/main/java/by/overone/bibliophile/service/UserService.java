package by.overone.bibliophile.service;

import by.overone.bibliophile.dao.exception.DAONotFoundException;
import by.overone.bibliophile.dto.UserGetAllDTO;
import by.overone.bibliophile.dto.UserRoleGetDTO;
import by.overone.bibliophile.service.exception.ServiceException;

import java.util.List;

public interface UserService {

    List<UserGetAllDTO> getAllUsers() throws ServiceException, DAONotFoundException;

    List<UserRoleGetDTO> getRoleUsers() throws ServiceException;
}
