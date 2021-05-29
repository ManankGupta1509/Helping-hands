package com.example.demo.controler;

import com.example.demo.model.User;
import com.example.demo.model.dataList;
import com.example.demo.services.dataListServices;
import javassist.compiler.ast.Keyword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class dataListControler {

    @Autowired
    private dataListServices datalistservices;
    @RequestMapping("/")
    public String getPage(){
        return "layout";
    }


    @RequestMapping(method = RequestMethod.GET,value = "/index")
    public ArrayList<dataList> getdata(Model model,ArrayList<dataList> listdata){
        if(listdata.isEmpty()) {
            ArrayList<dataList> data = datalistservices.getdata();

            model.addAttribute("datalist", data);

            return data;
        }
        else
            return listdata;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/creates")
    public String getCreate(){
        return "create.html ";
    }
    @RequestMapping(method = RequestMethod.POST,value = "/create")
    public String createNewPost(dataList newPost,HttpSession session)
    {
        User user = (User)session.getAttribute("LoggedUser");
        newPost.setUser(user);
        datalistservices.createPost(newPost);
        return "redirect:/create";
    }
    @RequestMapping(method = RequestMethod.GET,value = "/create")
    public ArrayList<dataList> getdata(Model model, HttpSession session){
        User user = (User)session.getAttribute("LoggedUser");
        ArrayList<dataList> data=datalistservices.getdata(user.getId());
        model.addAttribute("datalist",data);
        return data;
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/delete")
    public String deletePost(@RequestParam(name = "postId") Integer postId){
        datalistservices.deletePost(postId);
        return "redirect:/index";
    }
    @RequestMapping(method = RequestMethod.GET,value = "/edit")
    public String editPost(@RequestParam(name = "postId") Integer postId,Model model){
        dataList data = datalistservices.getPost(postId);
        model.addAttribute("datalist",data);
        return "edit";
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/edit")
    public String editPostSubmit(@RequestParam(name = "postId") Integer postId,dataList updatedPost){
        updatedPost.setId(postId);
        datalistservices.updatedPost(updatedPost);
        return "redirect:/index";
    }
    @GetMapping("/search")
    public String getProduct(Model model, @RequestParam(name = "keyword") String keyword) {
        ArrayList<dataList> listdata = this.datalistservices.getsearchdata(keyword);
        model.addAttribute("datalist", listdata);
        model.addAttribute("keyword",keyword);
        getdata(model,listdata);
        return "index";
    }
}
