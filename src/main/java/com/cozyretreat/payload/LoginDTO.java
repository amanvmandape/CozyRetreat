package com.cozyretreat.payload;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
public class LoginDTO {
    private String username;
    private String password;
}
