//package org.yassir.MajesticCup.Controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.yassir.MajesticCup.Model.Entity.User;
////import org.yassir.MajesticCup.Service.Impl.UserService;
//
//@RestController
//@RequestMapping("/api/public")
//public class UserController {
//
//    private final UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping("/test")
//    public String test() {
//        return "test";
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<User> register(@RequestBody User user) {
//        userService.registerUser(user);
//        return ResponseEntity.ok(user);
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestBody User user) {
//        return userService.verify(user);
//    }
//
//
//
//}