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
            throw new UserExistsException("Person with Afm: "+userDtoCreate.getUserEmail()+" exist ");
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

}
