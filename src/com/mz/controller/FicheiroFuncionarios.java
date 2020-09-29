package com.mz.controller;

import com.mz.model.Funcionario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class FicheiroFuncionarios{
    
    public static ArrayList<Funcionario> lerFuncionarios=new ArrayList();
    
    public static void lerFuncionario(Funcionario funcionario){
            try{
               File file = new File("Funcionario.dat");
               if(!file.exists())file.createNewFile();
               ObjectInputStream objecto= new ObjectInputStream(new FileInputStream(file));
               ArrayList<Funcionario> funcionarios=(ArrayList<Funcionario>)objecto.readObject();
               funcionarios.add(funcionario);
               gravaFuncionario(funcionarios);
               objecto.close();
           }catch (IOException | ClassNotFoundException e) {
               System.out.println(e);
           }       
    }
    
    public static void gravaFuncionario(ArrayList<Funcionario> funcionarios){
        File file=new File("Funcionario.dat");
       try{       
          if(!file.exists());
         ObjectOutputStream objecto=new ObjectOutputStream(new FileOutputStream(file,false));
         objecto.writeObject(funcionarios);
         objecto.close();
         
       }catch(IOException e){
           
       }  
    }  
   
    static public void ler(){
      try{    
         FileInputStream file=new FileInputStream("Funcionario.dat");
         ObjectInputStream objecto= new ObjectInputStream(file);
         lerFuncionarios=(ArrayList<Funcionario>)objecto.readObject();
         Iterator<Funcionario> iterator=lerFuncionarios.iterator();
         while(iterator.hasNext()){
             Funcionario funcionario=iterator.next();
            
         }
        
         objecto.close();
      }catch(IOException | ClassNotFoundException e){
          
      }   
    }

    public static boolean ficheiroExiste(){
        File file=new File("Funcionario.dat");
        return file.exists();
    }    
    
}
