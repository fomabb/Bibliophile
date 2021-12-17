package by.overone.bibliophile;

import by.overone.bibliophile.dao.exception.DAONotFoundException;
import by.overone.bibliophile.dto.UserGetAllDTO;
import by.overone.bibliophile.dto.UserRegistrationDTO;
import by.overone.bibliophile.model.Role;
import by.overone.bibliophile.model.Status;
import by.overone.bibliophile.service.UserService;
import by.overone.bibliophile.service.exception.ServiceException;
import by.overone.bibliophile.service.exception.ServiceNotFoundException;
import by.overone.bibliophile.service.impl.UserServiceImpl;

import java.util.List;

public class Main {

    /*
    Книголюб (Bibliophile)!
 1) Покупатель (customers);
 2) Продавец (employee);
 3) Книги (books);
 4) Заказы (orders);
 	Создать таблицы:
  1) Покупатели (customers); 2) Продавцы (employee); 3) Книги (books); 4) Заказы (orders).

Задачи программы:
 1) Вывести всех покуптелей; +
 2) Вывести всех покупателей по статусу; +
 3) Вывести по ID покупателей;
 4) Добавить пользователя (регистрация);
 5) Добавить детали пользователя;
 6) Обновить пользователя;
 7) Удалить пользователя;
     */

    public static void main(String[] args) throws DAONotFoundException, ServiceException, ServiceNotFoundException {

        UserService userService = new UserServiceImpl();

        // GET_ALL_USERS
//        List<UserGetAllDTO> userGetAllDTOS = userService.getAllUsers();
//        userGetAllDTOS.forEach(System.out::println);

        // GET_USER_BY_STATUS
//        List<UserGetAllDTO> userGetAllDTOS = userService.getUsersByStatus();
//        userGetAllDTOS.forEach(System.out::println);

        // GET_USER_BY_ID
//        UserGetAllDTO userGetAllDTO = userService.getUserById(1);
//        System.out.println(userGetAllDTO);

        //USER_REGISTRATION
        UserRegistrationDTO userRegistrationDTO = new UserRegistrationDTO();
        userRegistrationDTO.setLogin("Oleg");
        userRegistrationDTO.setPassword("private557");
        userRegistrationDTO.setEmail("oligi@mail.com");
        userRegistrationDTO.setRole(Role.CUSTOMERS);
        userRegistrationDTO.setStatus(Status.ACTIVE);
        userService.addUser(userRegistrationDTO);
    }
}
