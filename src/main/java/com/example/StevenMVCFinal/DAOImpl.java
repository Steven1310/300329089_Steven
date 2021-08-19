package com.example.StevenMVCFinal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOImpl implements IDAO {

    public Connection1 con3;

    public DAOImpl(Connection1 con3) {
        this.con3 = con3;
    }

    @Override
    public int add(Category cat) throws SQLException, ClassNotFoundException {

        Category category=this.search(cat.getClientno());
        if(category==null) {
            String qre1 = "insert into loantable values(?,?,?,?,?)";
            PreparedStatement obj1 = con3.connect().prepareStatement(qre1);
            obj1.setString(1, cat.getClientno());
            obj1.setString(2, cat.getClientname());
            obj1.setDouble(3, cat.getLoanamount());
            obj1.setInt(4, cat.getYears());
            obj1.setString(5, cat.getLoantype());
            obj1.executeUpdate();
            System.out.println();
            return 1;
        }
        else
            return 0;

    }

    @Override
    public Category edit(Category cat, String ccCat) throws SQLException, ClassNotFoundException {

        String qre1 = "update loantable set clientno = ?, clientname = ?, loanamount = ?, years = ?, loantype = ? where clientno = ?";
        PreparedStatement obj1 = con3.connect().prepareStatement(qre1);


        obj1.setString(1, cat.getClientno());
        obj1.setString(2, cat.getClientname());
        obj1.setDouble(3, cat.getLoanamount());
        obj1.setInt(4, cat.getYears());
        obj1.setString(5, cat.getLoantype());
        obj1.setString(6, ccCat);
        obj1.executeUpdate();
        System.out.println("One record edited");
        return cat;
    }

    @Override
    public void delete(String catCode) throws SQLException, ClassNotFoundException {

        String qre1 = "delete from loantable where clientno = ?";
        PreparedStatement obj1 = con3.connect().prepareStatement(qre1);
        obj1.setString(1, catCode);
        obj1.executeUpdate();
        System.out.println("One record deleted");


    }

    @Override
    public ArrayList<Category> display() throws SQLException, ClassNotFoundException {

        ArrayList<Category> categories=new ArrayList<Category>();
        Category catDisplay;

        String qre1 = "select * from loantable";
        PreparedStatement obj1 = con3.connect().prepareStatement(qre1);
        ResultSet rs = obj1.executeQuery();
        while(rs.next()){
            catDisplay = new Category(rs.getString("clientno"), rs.getString("clientname"),rs.getDouble("loanamount"),rs.getInt("years"),rs.getString("loantype"));
            categories.add(catDisplay);
            System.out.println("No:"+catDisplay.getClientno());
        }
        return  categories;
    }

    @Override
    public Category search(String clientno) throws SQLException, ClassNotFoundException {

        String qre1 = "select * from loantable where clientno = ?";
        PreparedStatement obj1 = con3.connect().prepareStatement(qre1, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        obj1.setString(1,clientno);
        ResultSet rs = obj1.executeQuery();

        if(!rs.first()){
            System.out.print("Record not existing, ");
            return null;
        }

        Category obj2 = new Category(rs.getString("clientno"), rs.getString("clientname"),rs.getDouble("loanamount"),rs.getInt("years"),rs.getString("loantype"));
        return obj2;
    }
}
