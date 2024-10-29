package com.vnh.assignment.service;

import com.vnh.assignment.repository.UserRepository;
import com.vnh.assignment.dto.UserDTO;
import com.vnh.assignment.entity.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String createUser(UserDTO userDTO) throws Exception {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDTO, userEntity);
        try{
            userRepository.save(userEntity);
            return "User added sucessfully!";
        }catch (Exception e){
            throw new Exception("Unable to add new user!!");
        }
    }

    public List<UserDTO> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        BeanUtils.copyProperties(userEntities, userDTOList);
        return userDTOList;
    }

    public String updateUser(UserDTO userBody, int id) throws Exception {
        try{
            Optional<UserEntity> userEntity = userRepository.findById(id);
            if(userEntity.isPresent()){
                UserEntity updatedUser = new UserEntity();
                BeanUtils.copyProperties(userBody, updatedUser);
                updatedUser.setId(userEntity.get().getId());
                userRepository.save(updatedUser);
                return "User updated Sucessfully!";
            }else{
                return "User not found!";
            }
        } catch (Exception e){
            throw new Exception("Unable to update user");
        }
    }

    public String deleteUser(int id) throws Exception {
        try{
            Optional<UserEntity> userEntity = userRepository.findById(id);
            if(userEntity.isPresent()){
                userRepository.deleteById(id);
                return "User deleted sucessfully!";
            }else{
                return "User not found!";
            }
        } catch (Exception e){
            throw new Exception("Unable to delete user");
        }
    }
}
