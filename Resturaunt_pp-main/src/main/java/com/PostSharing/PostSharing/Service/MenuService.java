package com.PostSharing.PostSharing.Service;


import com.PostSharing.PostSharing.Modle.Menu;
import com.PostSharing.PostSharing.Repository.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuRepo menuRepo;

    public boolean addmenu(Menu menu)
    {
        try{
            menuRepo.save(menu);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public List<Menu> getfullmenu(Long id)
    {
        return menuRepo.getAllByRestId(id);
    }


}
