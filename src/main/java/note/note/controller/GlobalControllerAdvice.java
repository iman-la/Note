package note.note.controller;

import note.note.entity.User;
import note.note.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {

    private final UserService userService;

    public GlobalControllerAdvice(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute
    public void addAttributes(Model model){
        User currentUser = userService.getCurrentUser();
        model.addAttribute("currentUser",currentUser);


    }



}
