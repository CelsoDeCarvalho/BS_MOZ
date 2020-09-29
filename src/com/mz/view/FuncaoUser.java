package com.mz.view;

import com.mz.controller.FicheiroFuncionarios;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FuncaoUser extends JFrame{
    
    public FuncaoUser(){
        setSize(500,300);
        setResizable(false);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setTitle("USER OPTIONS");
    }
    
    public static void main(int i) {
        FuncaoUser fu=new FuncaoUser();
        JPanel painel=new JPanel();
        fu.add(painel);
        painel.setLayout(null);
        
        JLabel relatorio=new JLabel("ENVIAR RELATORIO");
        JLabel email=new JLabel("ENVIAR EMAIL");
        JLabel dados=new JLabel("MEUS DADOS");
        
        ImageIcon icon1=new ImageIcon(fu.getClass().getResource("/com/mz/fotos/relatorio.jpg"));
        ImageIcon icon2=new ImageIcon(fu.getClass().getResource("/com/mz/fotos/download.png"));
        ImageIcon icon3=new ImageIcon(fu.getClass().getResource("/com/mz/fotos/Post_lab_01-1-424x300.jpg"));
        ImageIcon icon4=new ImageIcon(fu.getClass().getResource("/com/mz/fotos/icons8-exit-sign-30.png"));
        
        JLabel foto1=new JLabel();
        JLabel foto2=new JLabel();
        JLabel foto3=new JLabel();
        JLabel foto4=new JLabel();
        JLabel nome=new JLabel("NOME");
        
        JButton voltar=new JButton();
        
        JPanel painel1=new JPanel();
        JPanel painel2=new JPanel();
        JPanel painel3=new JPanel();
        JPanel painel4=new JPanel();
        
        painel1.setBounds(10,75,150,150);
        painel2.setBounds(173,75,150,150);
        painel3.setBounds(335,75,150,150);
        painel4.setBounds(300,10,30,30);
        nome.setBounds(340,10,150,30);
        voltar.setBounds(10,10,25,30);
        foto4.setBounds(0,0,30,30);
        
        painel1.setLayout(null);
        painel2.setLayout(null);
        painel3.setLayout(null);
        painel4.setLayout(null);
        
        
        relatorio.setBounds(30,230,150,20);
        email.setBounds(210,230,150,20);
        dados.setBounds(370,230,150,20);
        
        foto1.setBounds(0,0,150,150);
        foto2.setBounds(0,0,150,150);
        foto3.setBounds(0,0,150,150);
        
        painel.add(painel1);
        painel.add(painel2);
        painel.add(painel3);
        painel.add(voltar);
        painel.add(painel4);
        painel.add(nome);
        painel1.add(foto1);
        painel2.add(foto2);
        painel3.add(foto3);
        
        foto1.setIcon(new ImageIcon(icon1.getImage().getScaledInstance(foto1.getWidth(), foto1.getHeight(), Image.SCALE_SMOOTH)));
        foto2.setIcon(new ImageIcon(icon2.getImage().getScaledInstance(foto2.getWidth(), foto2.getHeight(), Image.SCALE_SMOOTH)));
        foto3.setIcon(new ImageIcon(icon3.getImage().getScaledInstance(foto3.getWidth(), foto3.getHeight(), Image.SCALE_SMOOTH)));
        voltar.setIcon(icon4);
        painel.add(relatorio);
        painel.add(email);
        painel.add(dados);
        
        painel.setBackground(Color.WHITE);
        
        FicheiroFuncionarios.ler();
        nome.setText(FicheiroFuncionarios.lerFuncionarios.get(i).getNome());
        
        ImageIcon icons=null;
          if(!FicheiroFuncionarios.lerFuncionarios.get(i).getCaminhoImg().equals("/com/mz/fotos/perfil.png")){
              try{
                 icons=new ImageIcon(FicheiroFuncionarios.lerFuncionarios.get(i).getCaminhoImg()); 
              }catch(NullPointerException nu){
                 icons=new ImageIcon(fu.getClass().getResource("/com/mz/fotos/perfil.png")); 
              }
          }else icons=new ImageIcon(fu.getClass().getResource("/com/mz/fotos/perfil.png"));
        
          foto4.setIcon(new ImageIcon(icons.getImage().getScaledInstance(foto4.getWidth(), foto4.getHeight(), Image.SCALE_SMOOTH)));
          painel4.add(foto4);
        
        voltar.addActionListener((ActionEvent ae)->{
          fu.setVisible(false);
          Login.main();
        });
        
        painel1.addMouseListener(new  MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                fu.setVisible(false);
                EnviarRelatorio.main(i);
            }
            
        });
        
        painel2.addMouseListener(new  MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
               JOptionPane.showMessageDialog(null,"Ainda em desenvolvimento","",JOptionPane.INFORMATION_MESSAGE);
               return;
            }
            
        });
        
        painel3.addMouseListener(new  MouseAdapter() {
            
            public void mouseClicked(MouseEvent me) {
                fu.setVisible(false);
                
               JFrame tela=new JFrame("USER INFO");
               tela.setSize(500,250);
               tela.setResizable(false);
               tela.setDefaultCloseOperation(3);
               tela.setLocationRelativeTo(null);
               
               JPanel painel=new JPanel();
               tela.add(painel);
               painel.setLayout(null);
               
               JTextField t1=new JTextField();
               JTextField t2=new JTextField();
               JTextField t3=new JTextField();
               JTextField t4=new JTextField();
               JTextField t5=new JTextField();
               JTextField t6=new JTextField();
               JTextField t7=new JTextField();
               JTextField t8=new JTextField();
               JTextField t9=new JTextField();
               JTextField t10=new JTextField();
               JTextField t11=new JTextField();
               JTextField t12=new JTextField();
               JTextField t13=new JTextField();
               JButton voltar=new JButton("Voltar");
               
               t1.setEditable(false);
               t2.setEditable(false);
               t3.setEditable(false);
               t4.setEditable(false);
               t5.setEditable(false);
               t6.setEditable(false);
               t7.setEditable(false);
               t8.setEditable(false);
               t9.setEditable(false);
               t10.setEditable(false);
               t11.setEditable(false);
               t12.setEditable(false);
               t12.setEditable(false);
               
               t1.setText("ID: "+FicheiroFuncionarios.lerFuncionarios.get(i).getId());
               t2.setText("NOME: "+FicheiroFuncionarios.lerFuncionarios.get(i).getNome());
               t3.setText("APELIDO: "+FicheiroFuncionarios.lerFuncionarios.get(i).getApelido());
               t4.setText("CONTACTO: "+FicheiroFuncionarios.lerFuncionarios.get(i).getContacto());
               t5.setText("EMAIL: "+FicheiroFuncionarios.lerFuncionarios.get(i).getEmail());
               t6.setText("DATA NASCIMENTO: "+FicheiroFuncionarios.lerFuncionarios.get(i).getDataNascimento());
               t7.setText("GRAU: "+FicheiroFuncionarios.lerFuncionarios.get(i).getNivelAcademico());
               t8.setText("LOCAL NASCIMENTO: "+FicheiroFuncionarios.lerFuncionarios.get(i).getNacionalidade());
               t9.setText("GENERO: "+FicheiroFuncionarios.lerFuncionarios.get(i).getGenero());
               t10.setText("ESTADO CIVIL: "+FicheiroFuncionarios.lerFuncionarios.get(i).getEstadoCivil());
               t11.setText("SALARIO: "+FicheiroFuncionarios.lerFuncionarios.get(i).getSalario());
               t12.setText("SALDO: "+FicheiroFuncionarios.lerFuncionarios.get(i).getSaldo());
               t13.setText("CARGO: "+FicheiroFuncionarios.lerFuncionarios.get(i).getCargo());
               
               t1.setBounds(10,10,70,25);
               t2.setBounds(85,10,200,25);
               t3.setBounds(290,10,200,25);
               t4.setBounds(10,40,200,25);
               t5.setBounds(215,40,275,25);
               t11.setBounds(215,70,120,25);
               t12.setBounds(340,70,150,25);
               t13.setBounds(215,100,275,25);
               
               t6.setBounds(10,70,200,25);
               t7.setBounds(10,100,200,25);
               t8.setBounds(10,130,200,25);
               t9.setBounds(10,160,200,25);
               t10.setBounds(10,190,200,25);
               voltar.setBounds(310,190,70,25);
               
               painel.add(t1);
               painel.add(t2);
               painel.add(t3);
               painel.add(t4);
               painel.add(t5);
               painel.add(t6);
               painel.add(t7);
               painel.add(t8);
               painel.add(t9);
               painel.add(t10);
               painel.add(t11);
               painel.add(t12);
               painel.add(t13);              
               painel.add(voltar);
               
               voltar.addActionListener((ActionEvent ae)->{
                   tela.setVisible(false);
                   fu.setVisible(true);
               });
               
               tela.setVisible(true);
               
            }
            
        });        
        
        
        fu.setVisible(true);
    }
    
}