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

public class FicheiroCurriculos{
    
       public static  ArrayList<Funcionario> lerCurriculos=new ArrayList<>();
   
    public static void lerCurriculo(Funcionario funcionario){
           try{
               File file = new File("Curriculo.dat");
               if(!file.exists())file.createNewFile();
               ObjectInputStream objecto= new ObjectInputStream(new FileInputStream(file));
               ArrayList<Funcionario> funcionarios=(ArrayList<Funcionario>)objecto.readObject();
               funcionarios.add(funcionario);
               gravaCurriculo(funcionarios);
               objecto.close();
           }catch (IOException | ClassNotFoundException e) {
               System.out.println(e);
           }
    }       
    
    public static void gravaCurriculo(ArrayList<Funcionario> funcionarios){
        File file=new File("Curriculo.dat");
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
         FileInputStream file=new FileInputStream("Curriculo.dat");
         ObjectInputStream objecto= new ObjectInputStream(file);
         lerCurriculos=(ArrayList<Funcionario>)objecto.readObject();
         Iterator<Funcionario> iterator=lerCurriculos.iterator();
         while(iterator.hasNext()){
             Funcionario funcionario=iterator.next();
            
         }
        
         objecto.close();
      }catch(IOException | ClassNotFoundException e){
          
      }   
    }
    
    public static boolean ficheiroExite(){
        File file=new File("Curriculo.dat");
        return file.exists();
    }
    
    public static void reiniciar(){
       File file=new File("Curriculo.dat");
       if(file.exists()){
           file.delete();
           try{
            file.createNewFile();
           }catch(IOException e){
               
           }
       }
    }
    
}
