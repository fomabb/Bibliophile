package by.overone.bibliophile;

import by.overone.bibliophile.dao.exception.DAONotFoundException;
import by.overone.bibliophile.dto.BookDataDTO;
import by.overone.bibliophile.dto.UserAllInfoDTO;
import by.overone.bibliophile.service.BooksService;
import by.overone.bibliophile.service.UserService;
import by.overone.bibliophile.service.exception.ServiceException;
import by.overone.bibliophile.service.exception.ServiceNotFoundException;
import by.overone.bibliophile.service.impl.BooksServiceImpl;
import by.overone.bibliophile.service.impl.UserServiceImpl;
import by.overone.bibliophile.util.validation.exception.ValidateException;

import java.sql.SQLException;
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

    public static void main(String[] args) throws DAONotFoundException, ServiceException, ServiceNotFoundException, ValidateException, SQLException {

        UserService userService = new UserServiceImpl();
        BooksService booksService = new BooksServiceImpl();

        // GET_ALL_USERS
//        List<UserGetAllDTO> userGetAllDTOS = userService.getAllUsers();
//        userGetAllDTOS.forEach(System.out::println);

        // GET_USER_BY_STATUS
//        List<UserGetAllDTO> userGetAllDTOS = userService.getUsersByStatus();
//        userGetAllDTOS.forEach(System.out::println);

        // GET_USER_BY_ID
//        UserGetAllDTO userGetAllDTO = userService.getUserById(3);
//        System.out.println(userGetAllDTO);

        //USER_REGISTRATION
//        UserRegistrationDTO userRegistrationDTO = new UserRegistrationDTO();
//        userRegistrationDTO.setLogin("Merlin");
//        userRegistrationDTO.setPassword("loh888");
//        userRegistrationDTO.setEmail("menson@gmail.com");
//        userService.addUser(userRegistrationDTO);

        // ADD_USER_DETAILS
//        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
//        userDetailsDTO.setName("Valeria");
//        userDetailsDTO.setSurname("Popko");
//        userDetailsDTO.setAddress("Pinsk");
//        userDetailsDTO.setPhoneNumber("+37529 555-66-22");
//        userService.addUserDetails(26, userDetailsDTO);

        // GET_USER_DETAILS_BY_ID
//        UserDetailsDTO userDetailsDTO = userService.getUserDetails(24);
//        System.out.println(userDetailsDTO);

        // GET_ALL_INFO
//        UserAllInfoDTO userGetAllDTO = userService.getUserAllInfo(24);
//        System.out.println(userGetAllDTO);

        // DELETE_USER
//        userService.deleteUser(22);

        // GET_ALL_BOOKS
        List<BookDataDTO> bookDataDTOS = booksService.getAllBooks();
        bookDataDTOS.forEach(System.out::println);
    }
}
