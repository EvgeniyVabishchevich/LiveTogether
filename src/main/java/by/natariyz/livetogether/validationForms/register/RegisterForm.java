package by.natariyz.livetogether.validationForms.register;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@PasswordConstraint
public class RegisterForm {
    @NotNull
    @NotBlank (message = "Login is mandatory.")
    private String login;
    @NotNull
    @NotBlank (message = "Password is mandatory.")
    private String password;
    @NotNull
    @NotBlank
    private String passwordRepeat;
}
