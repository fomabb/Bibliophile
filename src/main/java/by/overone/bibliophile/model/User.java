package by.overone.bibliophile.model;

import by.overone.bibliophile.dto.UserDataDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private long user_id;
    private String user_login;
    private String user_password;
    private String user_email;
    private Role role;
    private Status status;
}
