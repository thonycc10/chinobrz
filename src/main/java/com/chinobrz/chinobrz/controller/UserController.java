package com.chinobrz.chinobrz.controller;

import com.chinobrz.chinobrz.entity.User;
import com.chinobrz.chinobrz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody User user) {
        User userResponse;
        Map<String, Object> response = new HashMap<>();
        try {
            userResponse = userService.save(user);
        }catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object> >(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El usuario ha sido registrado con exito");
        response.put("user", userResponse);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
