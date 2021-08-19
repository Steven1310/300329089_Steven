package com.example.StevenMVCFinal;

import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Service
public class CategoryService {

    private IDAO daoImpObj;
    Connection1 conObj;

    private static List<Category> todos = new ArrayList<Category>();
    //private static int todoCount = 2;

    CategoryService() {
        this.conObj = new Connection1();
        this.daoImpObj = new DAOImpl(conObj);
    }



    public void initialadd(){

        /*todos.add(new Category("SS", "School Supplies"));
        todos.add(new Category("Dr", "Drinks"));*/

    }


    public List<Category> retrieveTodos() {
        List<Category> filteredTodos = new ArrayList<Category>();
        try {
            filteredTodos=daoImpObj.display();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return filteredTodos;
    }

    public void addTodo(String clientno,String clientname,double loanamount,int years,String loantype) {
        try {
            daoImpObj.add(new Category(clientno, clientname,loanamount,years,loantype));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void deleteTodo(String id) {

        try {
            daoImpObj.delete(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


    public Category retrieve(String id){

        Category cat= null;
        try {
            cat = daoImpObj.search(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cat;

    }

    public void update(Category todo){
        todos.remove(todo);
        todos.add(todo);
    }


}

