package com.example.StevenMVCFinal;

import java.sql.SQLException;
import java.util.Scanner;

public class MainProgram {

    private IDAO daoImpObj;
    Connection1 conObj;

    public MainProgram() {

        this.conObj = new Connection1();
        this.daoImpObj = new DAOImpl(conObj);

    }

    public static void main(String args[]) throws SQLException, ClassNotFoundException {

        MainProgram mainObj = new MainProgram();

        boolean flag = true;
        Scanner key = new Scanner(System.in);
        String ans = "";


        System.out.println("\nChoose from the following option");
        while(flag){
            System.out.println("\n\nEnter A to add, D to delete, E to edit, DI to display and EX to exit");
            ans = key.nextLine();
            if(ans.equals("A")){
                mainObj.addData();
                mainObj.displayData();

            }else if (ans.equals("E")){
                mainObj.editdata();

            }
            else if (ans.equals("D")){
                mainObj.deleteData();

            }
            else if (ans.equals("DI")){
                mainObj.displayData();

            }
            else if (ans.equals("EX")){
                break;
            }
        }

    }

    public void addData() throws SQLException, ClassNotFoundException {
        String catcode;
        String catdesc;

        Category cat;
        Category catr;


        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a category code ");
        catcode = scan.nextLine();

        catr = daoImpObj.search(catcode);
        if(!(catr == null)){
            System.out.println("Please use another catcode ");
            return ;
        }else{
            System.out.println("Enter category description ");
            catdesc = scan.nextLine();

            cat = null;
            daoImpObj.add(cat);
            daoImpObj.display();
        }


    }

    public void displayData() throws SQLException, ClassNotFoundException {
        daoImpObj.display();
    }

    public void editdata() throws SQLException, ClassNotFoundException{
        String catcode;
        String catdesc;
        String oldcode;

        Category cat;
        Category catr;

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a category code ");
        catcode = scan.nextLine();

        catr = daoImpObj.search(catcode);
        if(catr == null){
            System.out.println("Record does not exist");
        }else{
            oldcode = catr.getClientno();
            System.out.println("Enter new code ");
            catcode = scan.nextLine();
            System.out.println("Enter new desc ");
            catdesc = scan.nextLine();

            cat = null;
            daoImpObj.edit(cat, oldcode);
            daoImpObj.display();
        }

    }


    public void deleteData() throws SQLException, ClassNotFoundException{
        String catcode;
        Category catr;

        Scanner scan = new Scanner(System.in);
        System.out.println("\n Enter a category code ");
        catcode = scan.nextLine();

        catr = daoImpObj.search(catcode);
        if(catr == null){
            System.out.println("Record does not exists ");
            return;
        }else{
            daoImpObj.delete(catcode);
            daoImpObj.display();
        }

    }
}
