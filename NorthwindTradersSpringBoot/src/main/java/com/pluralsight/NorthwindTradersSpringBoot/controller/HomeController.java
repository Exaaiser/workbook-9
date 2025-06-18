package com.pluralsight.NorthwindTradersSpringBoot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    //Application Programming Interface

    @RequestMapping(path="/", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public String index(@RequestParam(defaultValue="World!") String name) {
        return "Hello " + name;
    }

    @RequestMapping(path="/teapot", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.I_AM_A_TEAPOT)
    public String teapot(@RequestParam(defaultValue="You are") String name) {
        name += name.equals("You are") ? "" : " is";
        return name + " a teapot";
    }
}
