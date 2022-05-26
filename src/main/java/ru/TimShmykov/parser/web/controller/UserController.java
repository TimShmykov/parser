package ru.TimShmykov.parser.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.TimShmykov.parser.Service.storage.util.UserService;
import ru.TimShmykov.parser.model.User;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // @GetMapping
            // public List<User> getUsers (@RequestParam long userId){
        //     return userService.getUsers(userId);
        // }



}



