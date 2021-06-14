package com.PostSharing.PostSharing.Service;


import com.PostSharing.PostSharing.Modle.User;
import com.PostSharing.PostSharing.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public String signupuser(User user)
    {
        try{
            userRepo.save(user);
            return user.getUserid();
        }
        catch (Exception e)
        {
            return null;
        }
    }


    public String loginuser(User user)
    {
        String id=user.getUserid();
        try {
            Optional<User> user1=userRepo.findById(id);
            if(user1.isPresent())
            {
                return (user.getPassword().equals(user1.get().getPassword()))?user1.get().getUserid():null;
            }
            else {
                return null;
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
