package com.mz.view;

import com.mz.controller.FicheiroAdmin;
import com.mz.controller.FicheiroFuncionarios;
import com.mz.model.Administrador;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Login extends JFrame{
    
    public Login(){
        setSize(300,350);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        //setUndecorated(true);
    }
    
    public static void main(){
        
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
        
        
        Login login=new Login();
        JPanel painel=new JPanel();
        JPanel cima=new JPanel();
        JPanel baixo=new JPanel();
        JLabel acesso=new JLabel("Login de Acesso");
        Font font=new Font(Font.SANS_SERIF,Font.BOLD,30);
        login.add(painel);
        painel.setLayout(null);
        
        //DECLARACOES===============================
        JLabel credencias=new JLabel("Entre com as suas credencias");
        JTextField username=new JTextField("Email ou id");
        JPasswordField password=new JPasswordField("Senha");
        JButton entrar=new JButton("Entrar");
        JButton sair=new JButton("Sair");
        JLabel nome=new JLabel("Username");
        JLabel senha=new JLabel("Password");
        JCheckBox verSenha=new JCheckBox("Mostrar senha");
        
        //CONFIGURACOES==============================
        password.setEchoChar((char)0);
        cima.setBounds(0,0,300,72);
        baixo.setBounds(0,72,300,410);
        acesso.setBounds(25,10,300,50);
        acesso.setFont(font);
        username.setBounds(23,60,250,30);
        password.setBounds(23,120,250,30);
        entrar.setBounds(75,180,150,30);
        sair.setBounds(75,210,150,30);
        credencias.setBounds(45,2,220,30);
        credencias.setFont(new Font(Font.SANS_SERIF,Font.BOLD,14));
        nome.setBounds(23,40,70,20);
        senha.setBounds(23,100,70,20);
        verSenha.setBounds(23,145,150,30);
        //DICAO AO PAINEL============================
        painel.add(cima);
        painel.add(baixo);
        cima.setLayout(null);
        cima.add(acesso);
        baixo.setLayout(null);
        baixo.add(username);
        baixo.add(password);
        baixo.add(entrar);
        baixo.add(sair);
        baixo.add(credencias);
        baixo.add(nome);
        baixo.add(senha);
        baixo.add(verSenha);
        
        //CORES=====================================
        cima.setBackground(new Color(27,128,125));
        baixo.setBackground(Color.WHITE);
        acesso.setForeground(Color.WHITE);
        entrar.setBackground(new Color(33, 92, 86));
        sair.setBackground(new Color(179, 64, 44));
        password.setForeground(Color.GRAY);
        username.setForeground(Color.GRAY);
        
        //EVENTOS===================================
        verSenha.addActionListener((ActionEvent ae)->{
           if(verSenha.isSelected())password.setEchoChar((char)0);
           else
               if(password.getText().equals("Senha")){
                   
               }else
                   password.setEchoChar('*');
        });
        
        username.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                if(username.getText().equals("Email ou id")){
                    username.setText("");
                    username.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent fe){
                if(username.getText().equals("")){
                    username.setText("Email ou id");
                    username.setForeground(Color.GRAY);
                }
            }
        });
        
        password.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                if(password.getText().equals("Senha")){
                    password.setText("");
                    password.setEchoChar('*');
                    password.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent fe){
                if(password.getText().equals("")){
                    password.setText("Senha");
                    password.setEchoChar((char)0);
                    password.setForeground(Color.GRAY);
                }
            }
        });
        
        sair.addActionListener((ActionEvent ae)->{
            login.setVisible(false);
            PaginaPrincipal.main();
        });
        
        entrar.addActionListener((ActionEvent ae)->{
            
          if(username.getText().equals("Email ou id") || password.getText().equals("Senha"))JOptionPane.showMessageDialog(null,"Campos Vazios","",JOptionPane.INFORMATION_MESSAGE);else 
          {   
            Administrador administrador=new Administrador();
            administrador=FicheiroAdmin.ler();
            
            if(!FicheiroAdmin.ficheiroExite()){JOptionPane.showMessageDialog(null,"Dados invalidos","",JOptionPane.INFORMATION_MESSAGE);
            return;}
            
              if(username.getText().equals(administrador.getEmail()) && password.getText().equals(administrador.getSenha()) || username.getText().equals(""+administrador.getId()) && password.getText().equals(administrador.getSenha())){
                  login.setVisible(false);
                  FuncaoAdmin.main();
                  return;
              }
                //parte do funcionario///////////////////////////////////////////
                if(!FicheiroFuncionarios.ficheiroExiste())JOptionPane.showMessageDialog(null,"Dados invalidos","",JOptionPane.INFORMATION_MESSAGE);
                else{
                   FicheiroFuncionarios.ler();
                   boolean entrou=false;
                   for(int i=0;i<FicheiroFuncionarios.lerFuncionarios.size();i++){
                       if(username.getText().equals(FicheiroFuncionarios.lerFuncionarios.get(i).getEmail()) && password.getText().equals(FicheiroFuncionarios.lerFuncionarios.get(i).getSenha()) || username.getText().equals(""+FicheiroFuncionarios.lerFuncionarios.get(i).getId())  && password.getText().equals(FicheiroFuncionarios.lerFuncionarios.get(i).getSenha())){
                           entrou=true;
                           login.setVisible(false);
                           FuncaoUser.main(i);
                        }
                    
                    }
                    if(entrou==false){JOptionPane.showMessageDialog(null,"Dados invalidos","",JOptionPane.INFORMATION_MESSAGE); return;}
                } 
          }    
        });
        
        login.setVisible(true);
    }
    
}
