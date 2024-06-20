package com.unla.ghsicilianotfi.controllers;

import com.unla.ghsicilianotfi.helpers.ViewRouteHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.HOME);
        return mAV;
    }

}


