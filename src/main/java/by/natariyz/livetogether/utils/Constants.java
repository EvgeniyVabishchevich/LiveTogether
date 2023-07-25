package by.natariyz.livetogether.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {
    @UtilityClass
    public static class HtmlFiles {
        public static final String HOME = "home";
        public static final String ROOM = "room";
        public static final String SIGN_IN = "signIn";
        public static final String REGISTER = "register";
    }

    @UtilityClass
    public static class ControllerMappingPaths {
        public static final String SIGN_IN = "/sign-in";
        public static final String SIGN_IN_SUCCESS = "/sign-in/success";
        public static final String REGISTER = "/register";
    }

    @UtilityClass
    public static class Parameters {
        public static final String LOGIN = "login";
        public static final String PASSWORD = "password";
    }

    @UtilityClass
    public static class Attributes {
        public static final String ROOM_URL = "roomUrl";
    }

    @UtilityClass
    public static class SessionAttributes {
        public static final String USER_LOGIN = "userLogin";
    }
}
