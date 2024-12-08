package org.yassir.MajesticCup.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yassir.MajesticCup.Service.Impl.UserService;

@RestController
@RequestMapping("/api")

public class AdminController {



    public AdminController() {
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

}