package com.mz.controller;

import com.mz.model.Administrador;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

public class FicheiroAdmin{
    
    public static void gravar(Object objecto){
         File file=new File("Administrador.dat");
        try{
            file.delete();
            file.createNewFile();
            
          ObjectOutputStream objectOutputStrem=new ObjectOutputStream(new FileOutputStream(file));//ABERTURA DO FICHEIRO PARA ESCRITA
          
          objectOutputStrem.writeObject(objecto);//ESCRITA NO ARQUIVO
          
          objectOutputStrem.close();

        }catch(IOException e){
            System.out.println("Problemas ao gravar");
        }  
    }
    
    public static Administrador ler(){
        Administrador objecto=new Administrador();

        try{
            File file=new File("Administrador.dat");
            if(file.exists()){
              ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(file));
              objecto=(Administrador)objectInputStream.readObject();
              
              objectInputStream.close();
            }
            
        }catch(IOException | ClassNotFoundException e){
            
        }
       return objecto; 
    }
    
    public static boolean ficheiroExite(){
        File file=new File("Administrador.dat");
        return file.exists();
    }
    
    public static void apagar(){
        File file=new File("Administrador.dat");
        if(file.exists()){
            file.delete();
        }
    }
    
}
