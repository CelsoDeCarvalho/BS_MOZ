package com.mz.controller;

import com.mz.model.Relatorio;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author celso
 */
public class FicheiroRelatorio {
    
           public static  ArrayList<Relatorio> relatorios=new ArrayList<>();
   
    public static void lerRelatorios(Relatorio relatorio){
           try{
               File file = new File("Relatorio.txt");
               if(!file.exists())file.createNewFile();
               ObjectInputStream objecto= new ObjectInputStream(new FileInputStream(file));
               ArrayList<Relatorio> relatorios=(ArrayList<Relatorio>)objecto.readObject();
               relatorios.add(relatorio);
               gravaRelatorio(relatorios);
               objecto.close();
           }catch (IOException | ClassNotFoundException e) {
               System.out.println(e);
           }
    }       
    
    public static void gravaRelatorio(ArrayList<Relatorio> relatorios){
        File file=new File("Relatorio.txt");
       try{       
          if(!file.exists());
         ObjectOutputStream objecto=new ObjectOutputStream(new FileOutputStream(file,false));
         objecto.writeObject(relatorios);
         objecto.close();
         
       }catch(IOException e){
           
       }  
    }
    
    static public void ler(){
      try{    
         FileInputStream file=new FileInputStream("Relatorio.txt");
         ObjectInputStream objecto= new ObjectInputStream(file);
         relatorios=(ArrayList<Relatorio>)objecto.readObject();
         Iterator<Relatorio> iterator=relatorios.iterator();
         while(iterator.hasNext()){
             Relatorio relatorio=iterator.next();
            
         }
        
         objecto.close();
      }catch(IOException | ClassNotFoundException e){
          
      }   
    }
    
    public static boolean ficheiroExiste(){
       File file=new File("Relatorio.txt");
       return file.exists();
    }
    
}
