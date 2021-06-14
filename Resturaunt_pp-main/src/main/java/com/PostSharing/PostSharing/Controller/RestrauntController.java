package com.PostSharing.PostSharing.Controller;


import com.PostSharing.PostSharing.Modle.Restraunt;
import com.PostSharing.PostSharing.Service.RestrauntService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin
@RestController
public class RestrauntController {

    @Autowired
    private RestrauntService restrauntService;

@PostMapping("/addrestraunt")
    public Long addrestraunt(@RequestBody String data) throws JsonProcessingException {
    Restraunt restraunt=new ObjectMapper().readValue(data,Restraunt.class);
    return restrauntService.addrest(restraunt);
}
    @GetMapping("/allrestraunts")
    public List<Restraunt> allrest(){
    return restrauntService.allrest();
    }

    @GetMapping("/rest/{id}")
    public Restraunt getmenu(@PathVariable("id") Long resid)
    {
        return restrauntService.getrest(resid);
    }
}

