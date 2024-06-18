/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import Class.designation;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class designationDB {
   private ArrayList<designation> deList;
   private File fileObj;
    
   public designationDB() {
        deList = new ArrayList<>();
        String filePath = "D:/designation.txt";
        fileObj = new File(filePath);
        try {
            if (!fileObj.exists()) {
                fileObj.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
   public boolean add(designation s){     
      try{
          FileWriter fw=new FileWriter(fileObj,true);
          String line=s.getDesigID()+"\t"+s.getDesigname()+"\t"+"\n";
          fw.write(line);
          fw.close();
          return true;
      }catch(Exception ex){
          System.err.println(ex.getMessage());
          return false;
      }
   }
   
   public boolean delete(int desigID){
       boolean flag=false;
       ArrayList<designation> deList=getAll();
       for(designation desig:deList){
           if(desig.getDesigID()==desigID){
               deList.remove(desig); 
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
       for(designation s: deList){
           add(s);
       }
       
       return flag;
   }
   
   public designation get(int desigID){
       ArrayList<designation> deList=getAll();
       for(designation desig:deList){
           if(desig.getDesigID()==desigID){
               return desig;
           }
       }
       return null;
   }
   
   public boolean update(designation s){
     try{
         ArrayList<designation> sList=getAll();
         FileWriter fw=new FileWriter(fileObj);         
         fw.write("");
         fw.close();  
         for(designation desig:sList){
            if(desig.getDesigID()==s.getDesigID()) {
                sList.remove(desig);
                sList.add(s);
                break;
            }
         }
         for(designation s1:sList){
             add(s1);
         }
         return true;
     }catch(Exception ex){
         System.err.println(ex.getMessage());
         return false;
     }
   }
   
   public ArrayList<designation> getAll(){
       ArrayList<designation> desigList=new ArrayList<>();
       try{
           Scanner sc=new Scanner(fileObj);
           while(sc.hasNextLine()){
               String line=sc.nextLine();
               String[] arr=line.split("\t");
               int desigID=Integer.valueOf(arr[0]);
               String designame=arr[1];
               designation s=new designation(desigID, designame);
               deList.add(s);
           }           
          return deList;
       }catch(Exception ex){
           System.err.println(ex.getMessage());
           return null;
       }
      
   }
}
