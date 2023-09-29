package com.example.blog_app.Service.impl;

import com.example.blog_app.Exception.ResourceNotFoundException;
import com.example.blog_app.Entity.User;
import com.example.blog_app.Payload.UserDto;
import com.example.blog_app.Repositry.UserRepo;
import com.example.blog_app.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {

        User user = this.DtotoUser(userDto);
        User savedUser = this.userRepo.save(user);
        return this.UserTODto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
         User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        User updateUser = this.userRepo.save(user);
         UserDto userDto1 = this.UserTODto(updateUser);
         return userDto1;
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));

        return this.UserTODto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepo.findAll();
          List<UserDto> userDtos = users.stream().map(user -> this.UserTODto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
        this.userRepo.delete(user);
    }

    public User DtotoUser(UserDto userDto){
        User user = ((ModelMapper) this.modelMapper).map(userDto, User.class);
        return user;
    }
    public UserDto UserTODto(User user){
        UserDto userDto = ((ModelMapper) this.modelMapper).map(user, UserDto.class);
        return userDto;
    }

}
