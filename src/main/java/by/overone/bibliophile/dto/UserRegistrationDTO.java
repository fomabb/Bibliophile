package by.overone.bibliophile.dto;

import by.overone.bibliophile.model.Role;
import by.overone.bibliophile.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationDTO {
    private String login;
    private String password;
    private String email;
}
