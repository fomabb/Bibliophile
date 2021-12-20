package by.overone.bibliophile.dto;

import by.overone.bibliophile.model.Role;
import by.overone.bibliophile.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAllInfoDTO {
    private long id;
    private String login;
    private String password;
    private String email;
    private Role role;
    private Status status;
    private String name;
    private String surName;
    private String address;
    private String phoneNumber;
}
