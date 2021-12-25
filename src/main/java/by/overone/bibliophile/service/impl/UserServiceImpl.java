package by.overone.bibliophile.service.impl;

import by.overone.bibliophile.dao.UserDAO;
import by.overone.bibliophile.dao.exception.DAOException;
import by.overone.bibliophile.dao.exception.DAONotFoundException;
import by.overone.bibliophile.dto.*;
import by.overone.bibliophile.service.UserService;
import by.overone.bibliophile.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

//    UserDAO userDAO = new UserDAOImpl();

    @Override
    public List<UserGetAllDTO> getAllUsers() throws ServiceException, DAONotFoundException, DAOException {
        List<UserGetAllDTO> users = userDAO.getAllUser().stream().map(user -> new UserGetAllDTO(user.getUser_id(),
                        user.getUser_login(), user.getUser_email(), user.getRole(), user.getStatus()))
                .collect(Collectors.toList());
        return users;

//        List<UserGetAllDTO> userGetAllDTOS;
//        try {
//            List<User> users = userDAO.getAllUser();
//            userGetAllDTOS = users.stream()
//                    .map(user -> new UserGetAllDTO(user.getId(), user.getLogin(), user.getEmail(), user.getRole(),
//                            user.getStatus()))
//                    .collect(Collectors.toList());
//        } catch (DAOException e) {
//            throw new ServiceException();
//        }
//        return userGetAllDTOS;
    }

//    @Override
//    public List<UserGetAllDTO> getUsersByStatus() throws ServiceException {
//        List<UserGetAllDTO> userGetAllDTOS;
//        try {
//            List<User> users = userDAO.getUsersByStatus(Status.ACTIVE);
//            userGetAllDTOS = users.stream()
//                    .map(user -> new UserGetAllDTO(user.getId(), user.getLogin(), user.getEmail(), user.getRole(),
//                            user.getStatus()))
//                    .collect(Collectors.toList());
//        } catch (DAOException e) {
//            throw new ServiceException("not connection", e);
//        }
//        return userGetAllDTOS;
//    }
//
//    @Override
//    public UserGetAllDTO getUserById(long bookId) throws ServiceException, ServiceNotFoundException {
//        UserGetAllDTO userGetAllDTO = new UserGetAllDTO();
//        try {
//            User user = userDAO.getUserById(bookId);
//            userGetAllDTO.setId(user.getId());
//            userGetAllDTO.setLogin(user.getLogin());
//            userGetAllDTO.setEmail(user.getEmail());
//            userGetAllDTO.setRole(user.getRole());
//            userGetAllDTO.setStatus(user.getStatus());
//        } catch (DAOException e) {
//            throw new ServiceException("not connection");
//        } catch (DAONotFoundException e) {
//            throw new ServiceNotFoundException("User with id " + bookId + " not found", e);
//        }
//        return userGetAllDTO;
//    }
//
//    @Override
//    public UserDataDTO addUser(UserRegistrationDTO userRegistrationDTO) throws ValidateException, ServiceException {
//        User user = new User();
//        user.setLogin(userRegistrationDTO.getLogin());
//        user.setEmail(userRegistrationDTO.getEmail());
//        user.setPassword(DigestUtils.md5Hex(userRegistrationDTO.getPassword()));
//
//        if (!UserValidate.validateRegistration(userRegistrationDTO)) {
//            throw new ValidateException("incorrect data entered");
//        }
//        try {
//            user = userDAO.addUser(user);
//        } catch (DAOException e) {
//            throw new ServiceException("not add", e);
//        }
//
//        return new UserDataDTO(0, user.getLogin(), user.getPassword(), user.getEmail());
//    }
//
//    @Override
//    public UserDetailsDTO getUserDetails(long userId) throws ServiceException {
//        UserDetailsDTO userDetailsDTO = null;
//        try {
//            userDetailsDTO = userDAO.getUserDetails(userId);
//        } catch (DAOException e) {
//            throw new ServiceException("Error" , e);
//        }
//        return userDetailsDTO;
//    }
//
//    @Override
//    public UserAllInfoDTO getUserAllInfo(long userId) {
//        return userDAO.getInfoUsers(userId);
//    }
//
//
//    @Override
//    public void deleteUser(long id) throws ServiceException, ServiceNotFoundException {
//        getUserById(id);
//        try {
//            userDAO.deleteUser(id);
//        } catch (DAONotFoundException | DAOException e) {
//            e.printStackTrace();
//        }
//    }
}


