package by.natariyz.livetogether.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import static by.natariyz.livetogether.utils.Constants.HtmlFiles.HOME;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = {"/home", "/"})
public class HomeController {
    @GetMapping
    public ModelAndView showMainPage() {
        return new ModelAndView(HOME);
    }
}
