package by.overone.bibliophile.dto;

import by.overone.bibliophile.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDataDTO extends User {
    private long id;
    private String login;
    private String email;
    private String password;
}
