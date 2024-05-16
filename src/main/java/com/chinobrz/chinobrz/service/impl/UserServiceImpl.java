package com.chinobrz.chinobrz.service.impl;

import com.chinobrz.chinobrz.entity.User;
import com.chinobrz.chinobrz.repository.UserRepository;
import com.chinobrz.chinobrz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
