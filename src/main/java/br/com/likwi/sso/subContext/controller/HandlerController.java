package br.com.likwi.sso.subContext.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HandlerController {

    @GetMapping(value = {"/", "/login"})
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @GetMapping(value = "/home")
    @PreAuthorize("hasAnyAuthority('professor')")
    public ModelAndView home() {
        return new ModelAndView("home");
    }

    @GetMapping(value = "/manage-students")
    @PreAuthorize("hasAnyAuthority('professor')")
    public ModelAndView manageStudents() {
        return new ModelAndView("manage-students");
    }

    @GetMapping(value = "/access-denied")
    public ModelAndView accessDenied() {
        return new ModelAndView("access-denied");
    }

}
