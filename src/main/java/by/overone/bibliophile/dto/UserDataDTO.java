package by.overone.bibliophile.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDataDTO {
    private long id;
    private String login;
    private String email;
    private String password;
}
