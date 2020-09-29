package com.mz.view;

import com.mz.controller.FicheiroAdmin;
import com.mz.model.Administrador;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;

public class CadastroAdmin extends JFrame{
    
    public CadastroAdmin(){
        setSize(400,330);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setTitle("Registrar Admin");
       
    }
    
     static Administrador ad=new Administrador();
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
        
        CadastroAdmin ca=new CadastroAdmin();
        Icon perfilDefault=new ImageIcon(ca.getClass().getResource(ad.getCaminhoImg()));
        
        //DECLARACOES============================
        Icon image=new ImageIcon(ca.getClass().getResource(ad.getCaminhoImg()));
        
        String genero[]={"","Masculino","Feminino","Outros"};
        JPanel painel=new JPanel();
        JPanel foto=new JPanel();
        JTextField tNome=new JTextField();
        JTextField tApelido=new JTextField();
        JTextField tEmail=new JTextField();
        JPasswordField senha=new JPasswordField();
        JComboBox sexo=new JComboBox(genero);
        JButton pic =new JButton("Escolher");
        JLabel lNome=new JLabel("NOME");
        JLabel lApelido=new JLabel("APELIDO");
        JLabel lEmail=new JLabel("EMAIL");
        JLabel lSexo=new JLabel("SEXO");
        JLabel lSenha=new JLabel("SENHA");
        JLabel lFoto=new JLabel(image);
        JButton voltar =new JButton("Voltar");
        JButton reset =new JButton("Limpar");
        JButton ok =new JButton("Concluir");
        
        //CONFIGURACOES===========================
        ca.add(painel);
        foto.setLayout(null);
        painel.setLayout(null);
        tNome.setBounds(10,30,200,25);
        tApelido.setBounds(10,80,200,25);
        tEmail.setBounds(10,130,200,25);
        sexo.setBounds(10,180,200,25);
        senha.setBounds(10,230,200,25);
        
        lNome.setBounds(10,10,200,25);
        lApelido.setBounds(10,60,200,25);
        lEmail.setBounds(10,110,200,25);
        lSexo.setBounds(10,160,200,25);
        lSenha.setBounds(10,210,70,25);
        foto.setBounds(255,30,100,100);
        lFoto.setBounds(255,30,100,100);
        pic.setBounds(255,135,100,25);
        
        voltar.setBounds(10,270,70,25);
        reset.setBounds(220,270,70,25);
        ok.setBounds(300,270,80,25);

        
        //ADICAO AO PAINEL=========================
        painel.add(tNome);
        painel.add(tApelido);
        painel.add(tEmail);
        painel.add(sexo);
        
        painel.add(lNome);
        painel.add(lApelido);
        painel.add(lEmail);
        painel.add(lSexo);
        painel.add(senha);
        painel.add(lSenha);
        painel.add(lFoto);
        painel.add(foto);
        painel.add(pic);
        painel.add(voltar);
        painel.add(ok);
        painel.add(reset);
        
        //CORES===================================
        foto.setBackground(Color.WHITE);
        
        //ACCOES=================================
        
        FileFilter filter = new FileFilter(){

            public boolean accept(File f) {
              if (f.isDirectory()) {
                  return true;
              } else {
                   String filename = f.getName().toLowerCase();
                   return filename.endsWith(".jpg") || filename.endsWith(".png") ;
                }
            }

            @Override
            public String getDescription() {
                return "JPG Images (*.jpg)\n(*.png)";
            }
        };
        
        pic.addActionListener((ActionEvent ae) -> {
            JFileChooser arquivo=new JFileChooser();
            arquivo.setFileFilter(filter);
            arquivo.setAcceptAllFileFilterUsed(false);
            arquivo.setDialogTitle("Selecione uma imagem");
            arquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int escolha=arquivo.showOpenDialog(ca);
            
            if(escolha==JFileChooser.APPROVE_OPTION){
                File file=new File("");
                file=arquivo.getSelectedFile();
                ad.setCaminhoImg(file.getAbsolutePath());
                ImageIcon imagem=new ImageIcon(arquivo.getSelectedFile().getPath());
                lFoto.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(lFoto.getWidth(), lFoto.getHeight(), Image.SCALE_DEFAULT)));
                
            }
        });
        
        
        ok.addActionListener((ActionEvent ae) ->{
            String sex=(String)sexo.getSelectedItem();
            if(tNome.getText().equals("") || tApelido.getText().equals("") || tEmail.getText().equals("") || sex.equals("") || senha.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Campos vazios","",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            ad.setNome(tNome.getText());
            ad.setApelido(tApelido.getText());
            ad.setEmail(tEmail.getText());
            ad.setGenero((String)sexo.getSelectedItem());
            ad.setSenha(senha.getText());
            ad.setId((int)(1000 + Math.random() * (10000 - 1000 + 1)));
            
            FicheiroAdmin ficheiroA=new FicheiroAdmin();
            ficheiroA.gravar(ad);
            JOptionPane.showMessageDialog(null,"Cadastrado com sucesso\n\nID: "+ad.getId(),"CADASTRO INFO",JOptionPane.INFORMATION_MESSAGE);
            
            ca.setVisible(false);
            Login.main();
        });

        voltar.addActionListener((ActionEvent ae)->{
            ca.setVisible(false);
            PaginaPrincipal.main();
        });
        
        reset.addActionListener((ActionEvent ae)->{
           senha.setText("");
           tNome.setText("");
           tApelido.setText("");
           tEmail.setText("");
           sexo.setSelectedIndex(0);
           
            lFoto.setIcon(perfilDefault);
            ad.setCaminhoImg("/com/mz/fotos/perfil.png");
            
           
        });
 
        
        ca.setVisible(true);
    }
    
}
