package com.example.StevenMVCFinal;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDAO {

    public int add(Category cat) throws SQLException, ClassNotFoundException;
    //saves the old value(ccCat)
    public Category edit(Category cat,String ccCat) throws SQLException, ClassNotFoundException ;
    public void delete (String catCode) throws SQLException, ClassNotFoundException;
    public ArrayList<Category> display() throws SQLException, ClassNotFoundException;
    //check if it exists
    public Category search(String catCode) throws SQLException, ClassNotFoundException;

}
