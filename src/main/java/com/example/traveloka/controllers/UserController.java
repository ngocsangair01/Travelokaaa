package com.example.traveloka.controllers;

import com.example.traveloka.base.ResponseUser;
import com.example.traveloka.daos.User;
import com.example.traveloka.dtos.SignInDTO;
import com.example.traveloka.dtos.UserDTO;
import com.example.traveloka.exceptions.DuplicateException;
import com.example.traveloka.exceptions.NotFoundException;
import com.example.traveloka.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<?> findAllUser(){
        return ResponseEntity.status(200).body(userRepository.findAll());
    }
    @GetMapping("/{idUser}")
    public ResponseEntity<?> findUserById(@PathVariable("idUser")Integer idUser) {
        Optional<User> user = userRepository.findByIdUser(idUser);
        if (user.isEmpty()) {
            throw new NotFoundException("Chưa có tài khoản nào ");
        }
        return ResponseEntity.status(200).body(new ResponseUser(201,"Thông tin user",user.get()));
    }
    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
        User oldUser = userRepository.findByAccount(userDTO.getName());
        if (oldUser != null) {
            throw new DuplicateException("Tài khoản đã tồn tại");
        }
        User user = new User();
        user.setAccount(userDTO.getAccount());
        user.setPassword(userDTO.getPassword());
        user.setName(userDTO.getName());
        user.setAge(userDTO.getAge());
        user.setEmail(userDTO.getEmail());
        user.setAddress(userDTO.getAddress());
        user.setSex(userDTO.getSex());
        user.setBirthday(userDTO.getBirthday());
        User newUser = userRepository.save(user);
        return ResponseEntity.status(201).body(new ResponseUser(201, "Đăng ký thành công", newUser));
    }
    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody SignInDTO signInDTO) {
        User user = userRepository.findByAccount(signInDTO.getAccount());
        if (user == null){
            throw new NotFoundException("Tài khoản không đúng");
        }
        if (!(user.getPassword().equals(signInDTO.getPassword()))){
            throw new NotFoundException("Mật khẩu không đúng");
        }
        return ResponseEntity.status(200).body(new ResponseUser(201,"Đăng nhập thành công",user));
    }
    @DeleteMapping("/{idUser}")
    public ResponseEntity<?> deleteUserById(@PathVariable(name = "idUser")Integer idUser){
        Optional<User> user = userRepository.findByIdUser(idUser);
        if (user.isEmpty()){
            throw new NotFoundException("User does not exists");
        }
        userRepository.deleteById(idUser);
        return ResponseEntity.status(200).body(new ResponseUser(201,"delete success",user.get()));
    }
}
