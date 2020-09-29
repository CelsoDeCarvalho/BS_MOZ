package com.mz.view;

import com.mz.controller.FicheiroFuncionarios;
import com.mz.controller.Mascara;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author celso
 */
public class CadastrarUser extends JFrame{
    
    public CadastrarUser(){
        setSize(235,200);
        setResizable(true);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setTitle("User Sign Up");
    }
    
    public static void main() {
        CadastrarUser cu =new CadastrarUser();
        JPanel painel=new JPanel();
        cu.add(painel);
        painel.setLayout(null);
        
  
         Mascara mascara=new Mascara();
         
        JTextField tId=new JTextField();
        JPasswordField senha=new JPasswordField();
        JLabel lId=new JLabel("Digite o ID");
        JLabel lSenha=new JLabel("Crie a sua senha");
        JButton voltar=new JButton("Voltar");
        JButton concluir=new JButton("Feito");
        
        tId.setBounds(10,30,200,25);
        senha.setBounds(10,85,200,25);
        
        lId.setBounds(10,7,200,25);
        lSenha.setBounds(10,62,200,25);
        
        voltar.setBounds(10,125,70,25);
        concluir.setBounds(135,125,70,25);
        
        painel.add(tId);
        painel.add(senha);
        painel.add(lId);
        painel.add(lSenha);
        painel.add(voltar);
        painel.add(concluir);
        
        voltar.addActionListener((ActionEvent ae)->{
            cu.setVisible(false);
            PaginaPrincipal.main();
        });
        
        tId.addKeyListener(mascara);
        
        concluir.addActionListener((ActionEvent ae)->{
            if(tId.getText().equals("") || senha.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Campos vazio","",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            FicheiroFuncionarios.ler();
            int id=Integer.parseInt(tId.getText());
            boolean aceite=false;
            for(int i=0;i<FicheiroFuncionarios.lerFuncionarios.size();i++){

                if(id==FicheiroFuncionarios.lerFuncionarios.get(i).getId()){
                    if(FicheiroFuncionarios.lerFuncionarios.get(i).getSenha()!=null){
                       JOptionPane.showMessageDialog(null,"Este id ja cadastrado!","",JOptionPane.INFORMATION_MESSAGE); 
                       return;
                    }
                    aceite=true;
                    FicheiroFuncionarios.lerFuncionarios.get(i).setSenha(senha.getText());
                    FicheiroFuncionarios.gravaFuncionario(FicheiroFuncionarios.lerFuncionarios);
                    JOptionPane.showMessageDialog(null,"Cadastrado!","",JOptionPane.INFORMATION_MESSAGE);
                    tId.setText("");
                    senha.setText("");
                }
            }
            
            if(aceite==false){
                JOptionPane.showMessageDialog(null,"Id nao encontrado ou funcionario nao contratado","",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        });
        
        cu.setVisible(true);
    }
    
}
