/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import Class.department;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class departmentDB {
   private ArrayList<department> deptList;
   private File fileObj;
    
   public departmentDB() {
        deptList = new ArrayList<>();
        String filePath = "D:/department.txt";
        fileObj = new File(filePath);
        try {
            if (!fileObj.exists()) {
                fileObj.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
   public boolean add(department d){     
      try{
          FileWriter fw=new FileWriter(fileObj,true);
          String line=d.getDeptID()+"\t"+d.getDeptname()+"\t"+"\n";
          fw.write(line);
          fw.close();
          return true;
      }catch(Exception ex){
          System.err.println(ex.getMessage());
          return false;
      }
   }
   
   public boolean delete(int deptID){
       boolean flag=false;
       ArrayList<department> deptList=getAll();
       for(department dept:deptList){
           if(dept.getDeptID()==deptID){
               deptList.remove(dept); 
               flag=true;
               break;
           }
       }
       try{           
          FileWriter fw=new FileWriter(fileObj);         
          fw.write("");
          fw.close();       
       }catch(Exception ex){
           System.err.println(ex.getMessage());
           flag=false;
       }
       for(department d: deptList){
           add(d);
       }
       
       return flag;
   }
   
   public department get(int deptID){
       ArrayList<department> deptList=getAll();
       for(department dept:deptList){
           if(dept.getDeptID()==deptID){
               return dept;
           }
       }
       return null;
   }
   
   public boolean update(department d){
     try{
         ArrayList<department> dList=getAll();
         FileWriter fw=new FileWriter(fileObj);         
         fw.write("");
         fw.close();  
         for(department dept:dList){
            if(dept.getDeptID()==d.getDeptID()) {
                dList.remove(dept);
                dList.add(d);
                break;
            }
         }
         for(department d1:dList){
             add(d1);
         }
         return true;
     }catch(Exception ex){
         System.err.println(ex.getMessage());
         return false;
     }
   }
   
   public ArrayList<department> getAll(){
       ArrayList<department> deptList=new ArrayList<>();
       try{
           Scanner sc=new Scanner(fileObj);
           while(sc.hasNextLine()){
               String line=sc.nextLine();
               String[] arr=line.split("\t");
               int deptID=Integer.valueOf(arr[0]);
               String deptname=arr[1];
               department d=new department(deptID, deptname);
               deptList.add(d);
           }           
          return deptList;
       }catch(Exception ex){
           System.err.println(ex.getMessage());
           return null;
       }
      
   }
}
