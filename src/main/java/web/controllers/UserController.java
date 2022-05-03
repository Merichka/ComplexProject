package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.models.User;
import web.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {

    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String userTypedQuery(@RequestParam(value = "name", required = false) String name,
                                 @RequestParam(value = "lastName", required = false) String lastName,
                                 Model model) {
        return "users";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return "add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String editUser(@ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors())
            return "edit";
        userService.editUser(user);
        return "redirect:/users";
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editUser(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        User user = userService.getById(id.longValue());
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
    public ModelAndView editUser(@ModelAttribute User user, @PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("users");

        userService.editUser(user);
        String message = "User was successfully edited.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("users");
        userService.deleteUser(id);
        return modelAndView;
    }

}