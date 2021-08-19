package com.example.StevenMVCFinal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping
@Controller
@SessionAttributes({"clintno","clintname"})
public class InventoryController {
    @Autowired
    CategoryService service;

    String oldId="";


    //a mapping when someone enters file
    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String showCategorypage(ModelMap model,@RequestParam(defaultValue = "") String id) {




        model.addAttribute("todos", service.retrieveTodos());



        return "category";


    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showCategoryPage2(ModelMap model) {

        model.addAttribute("todos", service.retrieveTodos());

        return "category";




    }

    @RequestMapping(value ="/add-todo", method = RequestMethod.GET)
    public String showtodopage(){
        return "catadd";
    }


    @RequestMapping(value ="/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @RequestParam String clientno, @RequestParam String clientname, @RequestParam double loanamount, @RequestParam int years, @RequestParam String loantype){


        service.addTodo(clientno,clientname,loanamount,years,loantype);


        model.clear();
        return "redirect:/category";
    }


    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(ModelMap model,  @RequestParam(defaultValue = "") String id){


        model.addAttribute("todos",service.retrieve(id));

        Category x = service.retrieve(id);


        oldId=String.valueOf(x.getClientno());

        return "catedit";
    }



    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String showUpdate(ModelMap model,  @RequestParam String catcode, @RequestParam String catdesc) {







        String iid = (String) model.get("id");
        //String iid = oldId;
        service.deleteTodo(iid);

        //service.addTodo(catcode,catdesc);



        return "redirect:/";

    }



    @RequestMapping(value ="/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(ModelMap model, @RequestParam String id) throws SQLException, ClassNotFoundException {


        service.deleteTodo(id);



        model.clear();
        return "redirect:/category";
    }

}

