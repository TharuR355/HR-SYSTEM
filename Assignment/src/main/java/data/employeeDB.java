/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;
import Class.employee;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class employeeDB {
   private ArrayList<employee> empList;
   private File fileObj;
    
   public employeeDB() {
        empList = new ArrayList<>();
        String filePath = "D:/employee.txt";
        fileObj = new File(filePath);
        try {
            if (!fileObj.exists()) {
                fileObj.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
   public boolean add(employee b){     
      try{
          FileWriter fw=new FileWriter(fileObj,true);
          String line=b.getEmpID()+"\t"+b.getName()+"\t"+b.getDept()+"\t"+b.getDesig()+"\t"+"\n";
          fw.write(line);
          fw.close();
          return true;
      }catch(Exception ex){
          System.err.println(ex.getMessage());
          return false;
      }
   }
   
   public boolean delete(int empID){
       boolean flag=false;
       ArrayList<employee> empList=getAll();
       for(employee emp:empList){
           if(emp.getEmpID()==empID){
               empList.remove(emp); 
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
       for(employee b: empList){
           add(b);
       }
       
       return flag;
   }
   
   public employee get(int empID){
       ArrayList<employee> empList=getAll();
       for(employee emp:empList){
           if(emp.getEmpID()==empID){
               return emp;
           }
       }
       return null;
   }
   
   public boolean update(employee e){
     try{
         ArrayList<employee> eList=getAll();
         FileWriter fw=new FileWriter(fileObj);         
         fw.write("");
         fw.close();  
         for(employee emp:eList){
            if(emp.getEmpID()==e.getEmpID()) {
                eList.remove(emp);
                eList.add(e);
                break;
            }
         }
         for(employee e1:eList){
             add(e1);
         }
         return true;
     }catch(Exception ex){
         System.err.println(ex.getMessage());
         return false;
     }
   }
   
   public ArrayList<employee> getAll(){
       ArrayList<employee> empList=new ArrayList<>();
       try{
           Scanner sc=new Scanner(fileObj);
           while(sc.hasNextLine()){
               String line=sc.nextLine();
               String[] arr=line.split("\t");
               int empID=Integer.valueOf(arr[0]);
               String name=arr[1];
               String dept=arr[2];
               String desig=arr[3];
               employee e=new employee(empID, name, dept, desig);
               empList.add(e);
           }           
          return empList;
       }catch(Exception ex){
           System.err.println(ex.getMessage());
           return null;
       }
      
   }
}
