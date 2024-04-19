package com.cozyretreat.service;

import com.cozyretreat.entity.AppUser;
import com.cozyretreat.payload.LoginDTO;
import com.cozyretreat.payload.UserDTO;
import com.cozyretreat.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final AppUserRepository userRepository;
    @Override
    public AppUser addUser(UserDTO dto) {
        AppUser user = mapToEntity(dto);
        return userRepository.save(user);
    }

    @Override
    public String verifyLogin(LoginDTO dto) {
        Optional<AppUser> opt = userRepository.findByUsername(dto.getUsername());
        if(opt.isPresent())
        {
            AppUser user = opt.get();
            if(BCrypt.checkpw(dto.getPassword(), user.getPassword()))
            {
                return "Successfully Logged in";
            }
        }

        return null;
    }

    private AppUser mapToEntity(UserDTO dto) {
        AppUser user = new AppUser();
        user.setName(dto.getName());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt(10)));
        user.setUserRole(dto.getUserRole());
        return user;
    }
}
