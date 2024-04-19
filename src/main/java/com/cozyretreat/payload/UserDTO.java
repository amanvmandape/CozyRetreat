package com.cozyretreat.payload;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class UserDTO {

    private String name;

    private String username;

    private String email;

    private String password;

    private String userRole;
}
