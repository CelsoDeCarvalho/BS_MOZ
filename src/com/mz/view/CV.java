/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mz.view;

import com.mz.controller.FicheiroCurriculos;
import com.mz.controller.FicheiroFuncionarios;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author celso
 */
public class CV extends JFrame{
    
    public CV(){
        setSize(305,200);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setTitle("ENVIAR CV");
    }
    
    public static void main() {
        
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
           }
        } catch (Exception e) {
              e.printStackTrace();
          }
        
        
        CV cv=new CV();
        JPanel painel=new JPanel();
        cv.add(painel);
        
        painel.setLayout(null);
        
        JTable tabela=new JTable();
        Object[]colunas={"Nome","Email","Contratado"};
        DefaultTableModel modelo=new DefaultTableModel();
        JScrollPane rolagem=new JScrollPane(tabela);
        
        JButton voltar=new JButton("Cancelar");
        JButton enviar=new JButton("Enviar CV");
        JButton chat=new JButton("Enviar Email");
        
        voltar.setBounds(0,0,100,50);
        enviar.setBounds(100,0,100,50);
        chat.setBounds(200,0,100,50);
        rolagem.setBounds(0,50,300,122);
        
        painel.add(voltar);
        painel.add(enviar);
        painel.add(chat);
        painel.add(rolagem);
        
        modelo.setColumnIdentifiers(colunas);
        tabela.setModel(modelo);
        
        Object[]dados=new Object[3];
        
        FicheiroCurriculos.ler();
        for(int i=0;i<FicheiroCurriculos.lerCurriculos.size();i++){
            dados[0]=FicheiroCurriculos.lerCurriculos.get(i).getNome();
            dados[1]=FicheiroCurriculos.lerCurriculos.get(i).getEmail();
            dados[2]=FicheiroCurriculos.lerCurriculos.get(i).getContratado(); 
            modelo.addRow(dados);
        }
        
        FicheiroFuncionarios.ler();
        for(int i=0;i<FicheiroFuncionarios.lerFuncionarios.size();i++){
            dados[0]=FicheiroFuncionarios.lerFuncionarios.get(i).getNome();
            dados[1]=FicheiroFuncionarios.lerFuncionarios.get(i).getEmail();
            dados[2]=FicheiroFuncionarios.lerFuncionarios.get(i).getContratado();
            modelo.addRow(dados);
        }
        
        //EVENTOS====================================
        voltar.addActionListener((ActionEvent ae)->{
           cv.setVisible(false);
           PaginaPrincipal.main();
        });
        
        enviar.addActionListener((ActionEvent ae)->{
            try {
                cv.setVisible(false);
                Curriculo.main();
            } catch (ParseException ex) {
                Logger.getLogger(CV.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        chat.addActionListener((ActionEvent ae)->{
            JOptionPane.showMessageDialog(null,"Em desenvolvimento","",JOptionPane.INFORMATION_MESSAGE);
        });   
        
        
        cv.setVisible(true);
    }
    
}
