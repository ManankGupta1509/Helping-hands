package com.PostSharing.PostSharing.Service;


import com.PostSharing.PostSharing.Modle.Restraunt;
import com.PostSharing.PostSharing.Repository.RestrauntRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestrauntService {

    @Autowired
    private RestrauntRepo restrauntRepo;

    public  Long addrest(Restraunt restraunt)
    {
        try{
            Restraunt restraunt1=restrauntRepo.save(restraunt);
            return restraunt1.getId();

        }
        catch (Exception e)
        {
            return null;
        }
    }

    public List<Restraunt> allrest()
    {
        return restrauntRepo.findAll();
    }

    public Restraunt getrest(Long id){
        try{
            Optional<Restraunt> restraunt=restrauntRepo.findById(id);
            if(restraunt.isPresent())
            {
                return restraunt.get();
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
