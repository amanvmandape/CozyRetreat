package com.cozyretreat.controller;

import com.cozyretreat.entity.AppUser;
import com.cozyretreat.payload.JWTResponse;
import com.cozyretreat.payload.LoginDTO;
import com.cozyretreat.payload.UserDTO;
import com.cozyretreat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/app/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<AppUser> addUser(@RequestBody UserDTO dto) {
        AppUser user = userService.addUser(dto);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?>login(@RequestBody LoginDTO dto) {
        String s = userService.verifyLogin(dto);
        if(s!=null) {
            JWTResponse response = new JWTResponse(s);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid Credentials", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/profile")
    public ResponseEntity<AppUser> getProfile(@AuthenticationPrincipal AppUser user) {
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
