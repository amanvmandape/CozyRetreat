package com.cozyretreat.service;

import com.cozyretreat.entity.AppUser;
import com.cozyretreat.payload.LoginDTO;
import com.cozyretreat.payload.UserDTO;

public interface UserService {

    AppUser addUser(UserDTO dto);

    String verifyLogin(LoginDTO dto);
}
