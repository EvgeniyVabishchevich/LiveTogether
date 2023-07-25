package by.natariyz.livetogether.controller;

import by.natariyz.livetogether.dto.UserDto;
import by.natariyz.livetogether.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        return new ModelAndView(REGISTER);
    }

    @PostMapping
    public ModelAndView registerUser(@RequestParam String login, @RequestParam String password,
                                     @RequestParam String passwordRepeat) {
        UserDto userDto = new UserDto(login);

        userService.save(userDto, password);

        return new ModelAndView("redirect:/login");
    }
}
