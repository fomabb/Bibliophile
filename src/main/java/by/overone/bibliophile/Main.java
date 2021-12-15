package by.overone.bibliophile;

import by.overone.bibliophile.dao.exception.DAONotFoundException;
import by.overone.bibliophile.dto.UserGetAllDTO;
import by.overone.bibliophile.service.UserService;
import by.overone.bibliophile.service.exception.ServiceException;
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
 1) Вывести всех продавцов;
 2) Вывести всех покупателей;
 3) Вывести по ID покупателей и продавцов;
 4) Получить общий список книг по жанру;
 5) Получить общий список книг по названию;
 6) Регистрация покупателей.
     */

    public static void main(String[] args) throws DAONotFoundException, ServiceException {

        UserService userService = new UserServiceImpl();

        // GET_ALL_USERS
        List<UserGetAllDTO> userGetAllDTOS = userService.getAllUsers();
        userGetAllDTOS.forEach(System.out::println);

    }
}
