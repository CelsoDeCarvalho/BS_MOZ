package com.mz.view;

import com.mz.controller.FicheiroRelatorio;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author celso
 */
public class VerRelatorios extends JFrame{
    
    public VerRelatorios(){
        setSize(300, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
    }
    
    public static void main() {
        VerRelatorios vr=new VerRelatorios();
        JPanel painel=new JPanel();
        vr.add(painel);
        painel.setLayout(null);
        Font font =new Font("",Font.BOLD,24);
        JLabel titulo=new JLabel("RELATORIOS");
        JButton voltar=new JButton("Voltar");
        JTextArea relatorios=new JTextArea();
        JScrollPane rolagem=new JScrollPane(relatorios);
        titulo.setBounds(70,5,200,20);
        titulo.setFont(font);
        painel.add(titulo);
        rolagem.setBounds(20,50,250,280);
        voltar.setBounds(20,335,70,30);
        painel.add(rolagem);
        painel.add(voltar);
        relatorios.setEditable(false);
        
        FicheiroRelatorio.ler();
        
        for(int i=0;i<FicheiroRelatorio.relatorios.size();i++){
            relatorios.setText("=================================\n"+"DE: "+FicheiroRelatorio.relatorios.get(i).getMandatario()+"\n\nDATA: "+FicheiroRelatorio.relatorios.get(i).getData()+"\n\nSMS: "+FicheiroRelatorio.relatorios.get(i).getSms()+"\n=================================");
        }
        
        voltar.addActionListener((ActionEvent ae)->{
            vr.setVisible(false);
            FuncaoAdmin.main();
        });
        
        painel.setBackground(Color.WHITE);
        vr.setVisible(true);
    }
    
}
