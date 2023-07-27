package by.natariyz.livetogether.controller;

import by.natariyz.livetogether.dto.UserDto;
import by.natariyz.livetogether.service.UserService;
import by.natariyz.livetogether.validationForms.register.RegisterForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import static by.natariyz.livetogether.utils.Constants.HtmlFiles.REGISTER;

@RestController
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegisterController {
    private final UserService userService;

    @GetMapping
    public ModelAndView showRegisterPage() {
        ModelAndView modelAndView = new ModelAndView(REGISTER);

        modelAndView.addObject(new RegisterForm());

        return modelAndView;
    }

    @PostMapping
    public ModelAndView registerUser(@Valid RegisterForm registerForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView(REGISTER);
        }

        UserDto userDto = new UserDto(registerForm.getLogin());

        userService.save(userDto, registerForm.getPassword());

        return new ModelAndView("redirect:/login");
    }
}
