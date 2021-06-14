package com.PostSharing.PostSharing.Controller;


import com.PostSharing.PostSharing.Modle.Menu;
import com.PostSharing.PostSharing.Service.MenuService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping("/menu/create")
    private boolean menuadd(@RequestBody String data) throws JsonProcessingException {
        Menu menu=new ObjectMapper().readValue(data, Menu.class);
        return menuService.addmenu(menu);
    }

    @GetMapping("/menu/get/{menuid}")
    private List<Menu> getmenu(@PathVariable("menuid") Long id) {
        return menuService.getfullmenu(id);
    }

}
