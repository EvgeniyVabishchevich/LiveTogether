package by.natariyz.livetogether.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import static by.natariyz.livetogether.utils.Constants.HtmlFiles.HOME;
import static by.natariyz.livetogether.utils.Constants.HtmlFiles.SIGN_IN;
import static by.natariyz.livetogether.utils.Constants.SessionAttributes.USER_LOGIN;

@Slf4j
@RestController
@RequestMapping("/sign-in")
@SessionAttributes(USER_LOGIN)
public class SignInController {
    @GetMapping
    public ModelAndView showSignInPage() {
        return new ModelAndView(SIGN_IN);
    }

    @PostMapping("/success")
    public ModelAndView showHomePage() {

        ModelAndView modelAndView = new ModelAndView(HOME);

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        modelAndView.addObject(USER_LOGIN, userDetails.getUsername());

        log.info("User \"" + userDetails.getUsername() + "\" logged in.");
        return modelAndView;
    }

}
