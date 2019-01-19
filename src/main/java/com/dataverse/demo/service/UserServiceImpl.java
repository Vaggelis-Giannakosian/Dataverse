package com.dataverse.demo.service;

import com.dataverse.demo.domain.User;
import com.dataverse.demo.dto.UserDtoCreate;
import com.dataverse.demo.exception.UserExistsException;
import com.dataverse.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;


// Create new User
    @Override
    public void create (UserDtoCreate userDtoCreate) throws UserExistsException {

        if(! isExistCreate(userDtoCreate)  ){
            User user = new User();

            user.setUserPassword(userDtoCreate.getPassword());
            user.setUserEmail(userDtoCreate.getUserEmail());
            user.setUserFirstName(userDtoCreate.getUserFirstName());
            user.setUserLastName(userDtoCreate.getUserLastName());
            user.setUserCompany(userDtoCreate.getUserCompany());
            user.setUserPhoneNumber(userDtoCreate.getUserPhoneNumber());

            User savedUser = userRepository.save(user);
        }else{
            throw new UserExistsException("Person with email: "+userDtoCreate.getUserEmail()+" already exists ");
        }

    }

    //Check to see if created User already exists in Db
    public boolean isExistCreate (UserDtoCreate userDtoCreate){
        return isExist(userDtoCreate.getUserEmail());
    }

    private boolean isExist (String email){
        if(userRepository.findUserByUserEmail(email)  != null)
        {
            return true;
        }
        return false;
    }

    public User getUserProfile(String email){
        return userRepository.findUserByUserEmail(email);
    }

    @Override
    public void updateUser(UserDtoCreate userDtoCreate, Long id) {

        User user = userRepository.findUserByUserId(id);

        user.setUserFirstName(userDtoCreate.getUserFirstName());
        user.setUserLastName(userDtoCreate.getUserLastName());
        user.setUserEmail(userDtoCreate.getUserEmail());
        user.setUserCompany(userDtoCreate.getUserCompany());
        user.setUserPhoneNumber(userDtoCreate.getUserPhoneNumber());
        user.setUserPassword(userDtoCreate.getPassword());


        userRepository.save(user);

    }



}
