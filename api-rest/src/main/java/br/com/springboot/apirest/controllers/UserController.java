package br.com.springboot.apirest.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.apirest.model.User;

@RestController
@RequestMapping("/users")
public class UserController {
    
    private List<User> users = new ArrayList<>();


    @GetMapping("/{id}")
    public User user(@PathVariable("id") Long id){

    Optional<User> userfind = users.stream().filter(user -> user.getId() == id).findFirst();

    if(userfind.isPresent()){
        return userfind.get();
    }
    return null;

    }

    @PostMapping("/")
public User user(@RequestBody User user){
    users.add(user);
    return user;
}

    @GetMapping("/List")
public List<User> list(){
    return users;
}
}
