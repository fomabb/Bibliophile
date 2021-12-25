package by.overone.bibliophile.controller;

import by.overone.bibliophile.dao.exception.DAOException;
import by.overone.bibliophile.dao.exception.DAONotFoundException;
import by.overone.bibliophile.dto.UserGetAllDTO;
import by.overone.bibliophile.service.UserService;
import by.overone.bibliophile.service.exception.ServiceException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserGetAllDTO> readAll() throws DAOException, DAONotFoundException, ServiceException {
        return userService.getAllUsers();
    }

    @GetMapping("/hello")
    public String read() {
        return "Hello";
    }
}
