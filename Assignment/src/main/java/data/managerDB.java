/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import Class.manager;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class managerDB {
   private ArrayList<manager> maList;
   private File fileObj;
    
   public managerDB() {
        maList = new ArrayList<>();
        String filePath = "D:/manager.txt";
        fileObj = new File(filePath);
        try {
            if (!fileObj.exists()) {
                fileObj.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
   public boolean add(manager m){     
      try{
          FileWriter fw=new FileWriter(fileObj,true);
          String line=m.getManagerID()+"\t"+m.getManagername()+"\t"+"\n";
          fw.write(line);
          fw.close();
          return true;
      }catch(Exception ex){
          System.err.println(ex.getMessage());
          return false;
      }
   }
   
   public boolean delete(int managerID){
       boolean flag=false;
       ArrayList<manager> maList=getAll();
       for(manager ma:maList){
           if(ma.getManagerID()==managerID){
               maList.remove(ma); 
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
       for(manager m: maList){
           add(m);
       }
       
       return flag;
   }
   
   public manager get(int managerID){
       ArrayList<manager> maList=getAll();
       for(manager ma:maList){
           if(ma.getManagerID()==managerID){
               return ma;
           }
       }
       return null;
   }
   
   public boolean update(manager m){
     try{
         ArrayList<manager> mList=getAll();
         FileWriter fw=new FileWriter(fileObj);         
         fw.write("");
         fw.close();  
         for(manager ma:mList){
            if(ma.getManagerID()==m.getManagerID()) {
                mList.remove(ma);
                mList.add(m);
                break;
            }
         }
         for(manager m1:mList){
             add(m1);
         }
         return true;
     }catch(Exception ex){
         System.err.println(ex.getMessage());
         return false;
     }
   }
   
   public ArrayList<manager> getAll(){
       ArrayList<manager> maList=new ArrayList<>();
       try{
           Scanner sc=new Scanner(fileObj);
           while(sc.hasNextLine()){
               String line=sc.nextLine();
               String[] arr=line.split("\t");
               int managerID=Integer.valueOf(arr[0]);
               String managername=arr[1];
               manager m=new manager(managerID, managername);
               maList.add(m);
           }           
          return maList;
       }catch(Exception ex){
           System.err.println(ex.getMessage());
           return null;
       }
      
   }
}
