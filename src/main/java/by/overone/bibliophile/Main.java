package by.overone.bibliophile;

import by.overone.bibliophile.dao.exception.DAONotFoundException;
import by.overone.bibliophile.dto.UserDetailsDTO;
import by.overone.bibliophile.dto.UserGetAllDTO;
import by.overone.bibliophile.dto.UserRegistrationDTO;
import by.overone.bibliophile.model.Role;
import by.overone.bibliophile.model.Status;
import by.overone.bibliophile.service.UserService;
import by.overone.bibliophile.service.exception.ServiceException;
import by.overone.bibliophile.service.exception.ServiceNotFoundException;
import by.overone.bibliophile.service.impl.UserServiceImpl;
import by.overone.bibliophile.util.validation.exception.ValidateException;

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
 3) Вывести по ID покупателей; +
 4) Добавить пользователя (регистрация); +
 5) Добавить детали пользователя; +
 6) Удалить пользователя;
 7) Обновить пользователя;
     */

    public static void main(String[] args) throws DAONotFoundException, ServiceException, ServiceNotFoundException, ValidateException {

        UserService userService = new UserServiceImpl();

        // GET_ALL_USERS
//        List<UserGetAllDTO> userGetAllDTOS = userService.getAllUsers();
//        userGetAllDTOS.forEach(System.out::println);

        // GET_USER_BY_STATUS
//        List<UserGetAllDTO> userGetAllDTOS = userService.getUsersByStatus();
//        userGetAllDTOS.forEach(System.out::println);

        // GET_USER_BY_ID
//        UserGetAllDTO userGetAllDTO = userService.getUserById(22);
//        System.out.println(userGetAllDTO);

        //USER_REGISTRATION
        UserRegistrationDTO userRegistrationDTO = new UserRegistrationDTO();
        userRegistrationDTO.setLogin("Marina");
        userRegistrationDTO.setPassword("mar1234");
        userRegistrationDTO.setEmail("mr@mail.com");
        userService.addUser(userRegistrationDTO);


        // ADD_USER_DETAILS
//        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
//        userDetailsDTO.setName("Oleg");
//        userDetailsDTO.setSurname("Veshiy");
//        userDetailsDTO.setAddress("Brest");
//        userDetailsDTO.setPhoneNumber("+37529 555-66-22");
//        userService.addUserDetails(4, userDetailsDTO);

        // DELETE_USER
//        userService.deleteUser(22);
    }
}
