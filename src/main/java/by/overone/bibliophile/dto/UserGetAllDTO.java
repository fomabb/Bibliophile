package by.overone.bibliophile.dto;

import by.overone.bibliophile.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserGetAllDTO {
    private long userIdDTO;
    private String userLoginDTO;
    private String userEmailDTO;
    private Role userRoleDTO;
}
