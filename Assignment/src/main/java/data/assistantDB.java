/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import Class.assistant;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class assistantDB {
   private ArrayList<assistant> aList;
   private File fileObj;
    
   public assistantDB() {
        aList = new ArrayList<>();
        String filePath = "D:/assistant.txt";
        fileObj = new File(filePath);
        try {
            if (!fileObj.exists()) {
                fileObj.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
   public boolean add(assistant a){     
      try{
          FileWriter fw=new FileWriter(fileObj,true);
          String line=a.getAssistantID()+"\t"+a.getAssistantname()+"\t"+a.getAssistantmanager()+"\t"+"\n";
          fw.write(line);
          fw.close();
          return true;
      }catch(Exception ex){
          System.err.println(ex.getMessage());
          return false;
      }
   }
   
   public boolean delete(int assistantID){
       boolean flag=false;
       ArrayList<assistant> aList=getAll();
       for(assistant assis:aList){
           if(assis.getAssistantID()==assistantID){
               aList.remove(assis); 
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
       for(assistant a: aList){
           add(a);
       }
       
       return flag;
   }
   
   public assistant get(int assistantID){
       ArrayList<assistant> aList=getAll();
       for(assistant assis:aList){
           if(assis.getAssistantID()==assistantID){
               return assis;
           }
       }
       return null;
   }
   
   public boolean update(assistant s){
     try{
         ArrayList<assistant> sList=getAll();
         FileWriter fw=new FileWriter(fileObj);         
         fw.write("");
         fw.close();  
         for(assistant assis:sList){
            if(assis.getAssistantID()==s.getAssistantID()) {
                sList.remove(assis);
                sList.add(s);
                break;
            }
         }
         for(assistant a1:sList){
             add(a1);
         }
         return true;
     }catch(Exception ex){
         System.err.println(ex.getMessage());
         return false;
     }
   }
   
   public ArrayList<assistant> getAll(){
       ArrayList<assistant> aList=new ArrayList<>();
       try{
           Scanner sc=new Scanner(fileObj);
           while(sc.hasNextLine()){
               String line=sc.nextLine();
               String[] arr=line.split("\t");
               int assistantID=Integer.valueOf(arr[0]);
               String assistantname=arr[1];
               String assistantmanager=arr[2];
               assistant a=new assistant(assistantID, assistantname, assistantmanager);
               aList.add(a);
           }           
          return aList;
       }catch(Exception ex){
           System.err.println(ex.getMessage());
           return null;
       }
      
   }
}
