package com.shinbae.mvc.employeemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    @NotNull
    @Size(min = 4, message = "{Size.User.UserName}")
    private String userName;

    @NotNull
    @Size(min = 4, message = "{Size.User.Password}")
    private String password;

    @NotNull
    @Email(message = "{Email.User.Email}")
    private String email;

    private List<RoleDto> roles;
}
