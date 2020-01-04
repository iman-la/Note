package note.note.util;

import note.note.entity.User;
import note.note.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtils {



    public static String getCurrentLoggedInUser() {
        /*
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        String email = authentication.getName();
        return email;
        */
        return "a@a.com";

    }


}
