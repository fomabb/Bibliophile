package by.overone.bibliophile.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private long userId;
    private String userLogin;
    private String userPassword;
    private String userEmail;
    private Role userRole;
}
