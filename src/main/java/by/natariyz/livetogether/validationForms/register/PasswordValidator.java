package by.natariyz.livetogether.validationForms.register;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordConstraint, RegisterForm> {
    @Override
    public void initialize(PasswordConstraint p) {
    }

    public boolean isValid(RegisterForm registerForm, ConstraintValidatorContext c) {
        String plainPassword = registerForm.getPassword();
        String repeatPassword = registerForm.getPasswordRepeat();

        if (plainPassword == null || repeatPassword == null) {
            return true;
        }

        boolean isValid = plainPassword.equals(repeatPassword);

        if (!isValid) {
            c.disableDefaultConstraintViolation();
            c.buildConstraintViolationWithTemplate("Passwords do not match.")
                    .addPropertyNode("password")
                    .addConstraintViolation();
        }

        return isValid;
    }
}
