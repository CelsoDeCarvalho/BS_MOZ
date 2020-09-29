package com.mz.view;

import com.mz.controller.FicheiroAdmin;
import com.mz.controller.FicheiroFuncionarios;
import com.mz.model.Administrador;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class FuncaoAdmin extends JFrame{
    
    public FuncaoAdmin(){
        setSize(905, 450);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
    }
    
    public static void main() {
        FuncaoAdmin funcaoAdmin=new FuncaoAdmin();
        
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
        
        JPanel painel =new JPanel();
        
        //DECALRACOES==============================
        JPanel painelA=new JPanel();
        JPanel painelB=new JPanel();
        JPanel painelC=new JPanel();
        
        JPanel painela=new JPanel();
        JPanel painelb=new JPanel();
        JPanel painelc=new JPanel();

        
        JPanel painelVA=new JPanel();
        JPanel painelVB=new JPanel();
        JPanel painelV=new JPanel();
        JPanel uC=new JPanel();
        JPanel perfil=new JPanel();
        JLabel foto7=new JLabel();
        
        Icon icon1=new ImageIcon(funcaoAdmin.getClass().getResource("/com/mz/fotos/icons8-profile-80.png"));
        JLabel foto1=new JLabel(icon1);
        Icon icon2=new ImageIcon(funcaoAdmin.getClass().getResource("/com/mz/fotos/icons8-money-80.png"));
        JLabel foto2=new JLabel(icon2);
        Icon icon3=new ImageIcon(funcaoAdmin.getClass().getResource("/com/mz/fotos/icons8-staff-80.png"));
        JLabel foto3=new JLabel(icon3);
        Icon icon4=new ImageIcon(funcaoAdmin.getClass().getResource("/com/mz/fotos/icons8-medical-history-50.png"));
        JLabel foto4=new JLabel(icon4);
        Icon icon5=new ImageIcon(funcaoAdmin.getClass().getResource("/com/mz/fotos/icons8-email-open-50.png"));
        JLabel foto5=new JLabel(icon5);
        ImageIcon icon7=new ImageIcon(funcaoAdmin.getClass().getResource("/com/mz/fotos/1Odq43G.jpg"));
        Icon icon6=new ImageIcon(funcaoAdmin.getClass().getResource("/com/mz/fotos/icons8-retirement-50.png"));
        JLabel foto6=new JLabel(icon6);  
        
        JLabel texto1=new JLabel("CURRICULOS");
        JLabel texto2=new JLabel("FUNCIONARIOS");
        JLabel texto3=new JLabel();
        JLabel texto4=new JLabel("relatorios");
        JLabel texto5=new JLabel("e-mail");
        JLabel texto8=new JLabel("retitar");
        JLabel texto6=new JLabel("ULTIMA CONTRATAÇAO");
        JLabel texto7=new JLabel("PERFIL");
        JLabel ultima=new JLabel();
        JLabel dados=new JLabel("MEUS DADOS");
        JTextField ultimo=new JTextField();
        JTextField nome=new JTextField();
        JTextField apelido=new JTextField();
        JTextField senha=new JTextField();
        JTextField genero=new JTextField();
        nome.setEnabled(false);
        apelido.setEnabled(false);
        senha.setEnabled(false);
        genero.setEnabled(false);
        JLabel fundo=new JLabel();
        
        
        JButton logOut=new JButton("Log out");
        
        //CONFIGURACOES============================

        painelA.setLayout(null);
        painelB.setLayout(null);
        painelVA.setLayout(null);
        painelVB.setLayout(null);
        painelV.setLayout(null);
        painelC.setLayout(null);
        painel.setLayout(null);
        painela.setLayout(null);
        painelb.setLayout(null);
        painelc.setLayout(null);
        perfil.setLayout(null);
        
        painelVA.setBounds(20, 20, 200, 210);
        painelVB.setBounds(20, 250, 200, 150);
        painelA.setBounds(240, 20, 200, 130);
        painelB.setBounds(460, 20, 200, 130);
        painelC.setBounds(680, 20, 200, 130);
        painela.setBounds(240, 170, 130, 80);
        painelb.setBounds(385, 170, 130, 80);
        painelc.setBounds(530, 170, 130, 80);
        painelV.setBounds(680, 170, 200, 190);
        logOut.setBounds(400,370,105,30);
        ultima.setBounds(0,0,100,100);
        uC.setBounds(50,40,100,100);
        perfil.setBounds(50,40,100,100);
        foto7.setBounds(0,0,100,100);
        uC.setLayout(null);
        
        foto1.setBounds(30,1,128,128);
        foto2.setBounds(30,1,128,128);
        foto3.setBounds(30,1,128,128);
        foto4.setBounds(40,5,50,50);
        foto5.setBounds(40,5,50,50);
        foto6.setBounds(40,5,50,50);
        ultimo.setBounds(20,150,160,30);
        ultimo.setEnabled(false);
        
        texto1.setBounds(60,105,128,20);
        texto2.setBounds(55,105,128,20);
        texto3.setBounds(65,105,128,20);
        texto4.setBounds(40,55,128,20);
        texto5.setBounds(47,55,128,20);
        texto8.setBounds(47,55,128,20);
        texto6.setBounds(30,5,150,30);
        texto7.setBounds(86,5,150,30);
        dados.setBounds(55,02,100,20);
        
        nome.setBounds(10,30,180,30);
        apelido.setBounds(10,60,180,30);
        senha.setBounds(10,90,180,30);
        genero.setBounds(10,120,180,30);
        
        //ADICOES==================================
        funcaoAdmin.add(painel);
        painel.add(painelVA);
        painel.add(painelVB);
        painel.add(painelA);
        painel.add(painelB);
        painel.add(painelC);
        painel.add(painela);
        painel.add(painelb);
        painel.add(painelc);
        painel.add(painelV);
        painel.add(logOut);
        painelV.add(uC);
        painelV.add(ultimo);
        
        painelA.add(foto1);
        painelC.add(foto2);
        painelB.add(foto3);
        painela.add(foto4);
        painelb.add(foto5);
        painelc.add(foto6);
        
        painelA.add(texto1);
        painelB.add(texto2);
        painelC.add(texto3);
        painela.add(texto4);
        painelb.add(texto5);
        painelc.add(texto8);
        painelV.add(texto6);
        painelVA.add(texto7);
        painelVA.add(perfil);
        painelVB.add(dados);
        painelVB.add(nome);
        painelVB.add(apelido);
        painelVB.add(senha);
        painelVB.add(genero);
        painel.add(fundo);
        fundo.setBounds(0,0,905,450);
        fundo.setIcon(new ImageIcon(icon7.getImage().getScaledInstance(fundo.getWidth(), fundo.getHeight(), Image.SCALE_SMOOTH)));
        
        //CORES===================================
        painel.setBackground(new Color(240, 240, 240));
        painelVA.setBackground(new Color(31, 31, 42));
        painelVB.setBackground(new Color(31, 31, 42));
        painelA.setBackground(Color.WHITE);
        painelB.setBackground(Color.WHITE);
        painelC.setBackground(Color.WHITE);
        painela.setBackground(Color.WHITE);
        painelb.setBackground(Color.WHITE);
        painelc.setBackground(Color.WHITE);
        painelV.setBackground(Color.WHITE);
        logOut.setBackground(new Color(179, 64, 44));
        texto7.setForeground(Color.WHITE);
        perfil.setBackground(new Color(31, 31, 42));
        dados.setForeground(Color.WHITE);
        
        //FOTOS=====================================
        Administrador administrador=new Administrador();
        
        administrador=FicheiroAdmin.ler();
        
        nome.setText("NOME: "+administrador.getNome());
        apelido.setText("Apelido: "+administrador.getApelido());
        senha.setText("SENHA: "+administrador.getSenha());
        genero.setText("EMAIL: "+administrador.getEmail());
        texto7.setText(""+administrador.getId());
        
        texto3.setText(""+administrador.getSaldo()+" MT");
        ImageIcon icon=null;
        
        if(!administrador.getCaminhoImg().equals("/com/mz/fotos/perfil.png")){
            try{
                icon=new ImageIcon(administrador.getCaminhoImg());
            }catch(NullPointerException nu){
                icon=new ImageIcon(funcaoAdmin.getClass().getResource("/com/mz/fotos/perfil.png"));
            }
        }else icon=new ImageIcon(funcaoAdmin.getClass().getResource("/com/mz/fotos/perfil.png"));
        
        foto7.setIcon(new ImageIcon(icon.getImage().getScaledInstance(foto7.getWidth(), foto7.getHeight(), Image.SCALE_SMOOTH)));
        perfil.add(foto7);
        
        FicheiroFuncionarios.ler();
        if(FicheiroFuncionarios.lerFuncionarios.size()>0){
          int i=FicheiroFuncionarios.lerFuncionarios.size()-1;
          ultimo.setText(FicheiroFuncionarios.lerFuncionarios.get(i).getNome()+" "+FicheiroFuncionarios.lerFuncionarios.get(i).getApelido());
          ImageIcon icons=null;
          if(!FicheiroFuncionarios.lerFuncionarios.get(i).getCaminhoImg().equals("/com/mz/fotos/perfil.png")){
              try{
                 icons=new ImageIcon(FicheiroFuncionarios.lerFuncionarios.get(i).getCaminhoImg()); 
              }catch(NullPointerException nu){
                 icons=new ImageIcon(funcaoAdmin.getClass().getResource("/com/mz/fotos/perfil.png")); 
              }
          }else icons=new ImageIcon(funcaoAdmin.getClass().getResource("/com/mz/fotos/perfil.png"));
        
          ultima.setIcon(new ImageIcon(icons.getImage().getScaledInstance(ultima.getWidth(), ultima.getHeight(), Image.SCALE_SMOOTH)));
          uC.add(ultima);
        }  
         
        //EVENTOS===================================
        logOut.addActionListener((ActionEvent ae)->{
            funcaoAdmin.setVisible(false);
            Login.main();
        });
        
        painelA.addMouseListener(new  MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                funcaoAdmin.setVisible(false);
                CvList.main();
            }
            
        });
        
        painelB.addMouseListener(new  MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                funcaoAdmin.setVisible(false);
                Funcionarios.main();
            }
            
        });
        
        painelc.addMouseListener(new  MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                String opcoes[]={"SIM","NAO"};
                int escolha=JOptionPane.showOptionDialog(null,"QUER MERSMO RETIRAR-SE?","",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null, opcoes, opcoes[0]);
                System.out.println(escolha);
                switch(escolha){
                    case 0:{
                            FicheiroAdmin.apagar();
                            funcaoAdmin.setVisible(false);
                            Login.main();
                        break;}
                    case 1:{break;}
                    case -1:{break;}
                }
            }
            
        }); 
        
        painelb.addMouseListener(new  MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
               JOptionPane.showMessageDialog(null,"Ainda em desenvolvimento","",JOptionPane.INFORMATION_MESSAGE);
               return;
            }
            
        });
        
        painela.addMouseListener(new  MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
               funcaoAdmin.setVisible(false);
               VerRelatorios.main();
            }
            
        });
        
        
        
        funcaoAdmin.setVisible(true);
    }
    
}
