package com.mz.view;
import com.mz.controller.FicheiroAdmin;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class PaginaPrincipal extends JFrame{
    
    public PaginaPrincipal(){
        setSize(600,450);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setLayout(null);
        setUndecorated(true);
    }
    

    
    public static void main(String...celso){
        
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
        
        PaginaPrincipal pp=new PaginaPrincipal();
        JPanel painel=new JPanel();
        JPanel painel1=new JPanel();
        JButton sair=new JButton();
        JPanel p1=new JPanel();
        JPanel p2=new JPanel();
        JPanel p3=new JPanel(); 
        JPanel p4=new JPanel();
        JPanel p5=new JPanel();
        JPanel p6=new JPanel(); 
        
        JSeparator separa1=new JSeparator(SwingConstants.VERTICAL);
        JSeparator separa2=new JSeparator(SwingConstants.VERTICAL);
        
        Icon im1=new ImageIcon(pp.getClass().getResource("/com/mz/fotos/icons8-login-50.png"));
        Icon im2=new ImageIcon(pp.getClass().getResource("/com/mz/fotos/icons8-add-user-male-50.png"));
        Icon im3=new ImageIcon(pp.getClass().getResource("/com/mz/fotos/icons8-email-50.png"));
        Icon im4=new ImageIcon(pp.getClass().getResource("/com/mz/fotos/icons8-about-50.png"));
        Icon im5=new ImageIcon(pp.getClass().getResource("/com/mz/fotos/icons8-settings-50.png"));
        Icon im6=new ImageIcon(pp.getClass().getResource("/com/mz/fotos/icons8-exit-50.png"));
        Icon quit=new ImageIcon(pp.getClass().getResource("/com/mz/fotos/icons8-fechar-janela-20.png"));
        Icon fcasa=new ImageIcon(pp.getClass().getResource("/com/mz/fotos/icons8-home-100.png"));
        ImageIcon flogo=new ImageIcon(pp.getClass().getResource("/com/mz/fotos/61jffqbinQL._AC_SL1400_.jpg"));
        
        JLabel foto1=new JLabel(im1);
        JLabel foto2=new JLabel(im2);
        JLabel foto3=new JLabel(im3);
        JLabel foto4=new JLabel(im4);
        JLabel foto5=new JLabel(im5);
        JLabel foto6=new JLabel(im6);
        JLabel lcasa=new JLabel(fcasa);
        JLabel llogo=new JLabel();
        
        llogo.setBounds(65,30,70,70);
        llogo.setIcon(new ImageIcon(flogo.getImage().getScaledInstance(llogo.getWidth(), llogo.getHeight(), Image.SCALE_SMOOTH)));
                
        sair.setIcon(quit);
        
        JLabel login=new JLabel("Sign In");
        JLabel reg=new JLabel("Sign Up");
        JLabel cv=new JLabel("Send CV");
        JLabel info=new JLabel("Info");
        JLabel setting=new JLabel("Settings");
        JLabel exit=new JLabel("Exit");
        JLabel home=new JLabel("HOME");
        JLabel rh=new JLabel("RH MANAGER");
        JLabel soft=new JLabel("Software ®");
        Font font=new Font("",Font.BOLD,20);
       
        painel.setBounds(0,130,600,450);
        painel1.setBounds(0,0,600,130);
        painel1.setBackground(new Color(59, 60, 253));
        painel.setBackground(new Color(220, 220, 220));
        painel.setLayout(null);
        painel1.setLayout(null);
        p1.setBounds(100,50,100,100);
        p1.setBackground(new Color(170, 170, 170));
        p2.setBounds(250,50,100,100);
        p2.setBackground(new Color(170, 170, 170));
        p3.setBounds(400,50,100,100);
        p3.setBackground(new Color(170, 170, 170));
        
        p4.setBounds(100,180,100,100);
        p4.setBackground(new Color(170, 170, 170));
        p5.setBounds(250,180,100,100);
        p5.setBackground(new Color(170, 170, 170));
        p6.setBounds(400,180,100,100);
        p6.setBackground(new Color(170, 170, 170));
        sair.setBounds(580,0,20,20);
        painel1.add(sair);
        
        pp.add(painel1);
        pp.add(painel);
        painel.add(p1); p1.setLayout(null);
        painel.add(p2); p2.setLayout(null);
        painel.add(p3); p3.setLayout(null);
        painel.add(p4); p4.setLayout(null);
        painel.add(p5); p5.setLayout(null);
        painel.add(p6); p6.setLayout(null);
        
        foto1.setBounds(25,5,50,50);
        p1.add(foto1);
        foto2.setBounds(25,5,50,50);
        p2.add(foto2);
        foto3.setBounds(25,5,50,50);
        p3.add(foto3);
        foto4.setBounds(25,5,50,50);
        p4.add(foto4);
        foto5.setBounds(25,5,50,50);
        p5.add(foto5);
        foto6.setBounds(25,5,50,50);
        p6.add(foto6);
        
        login.setBounds(30,70,60,20);
        p1.add(login);
        
        reg.setBounds(30,70,60,20);
        p2.add(reg);
        
        cv.setBounds(25,70,80,20);
        p3.add(cv);
        
        info.setBounds(40,70,60,20);
        p4.add(info);
        
        setting.setBounds(25,70,60,20);
        p5.add(setting);
        
        exit.setBounds(40,70,60,20);
        p6.add(exit);
        
        rh.setBounds(235,40,200,30);
        soft.setBounds(310,60,100,30);
        rh.setFont(font);
        
        lcasa.setBounds(450,2,100,100);
        home.setBounds(485,100,60,20);
        home.setForeground(Color.white);
        painel1.add(home);
        painel1.add(lcasa);
        separa1.setBounds(400,15,2,100);
        painel1.add(separa1);
        separa2.setBounds(200,15,2,100);
        painel1.add(separa2);
        painel1.add(rh);
        painel1.add(soft);
        painel1.add(llogo);
        
        soft.setForeground(Color.WHITE);
        rh.setForeground(Color.WHITE);
        
        sair.addActionListener(new ActionListener(){
           
            public void actionPerformed(ActionEvent e){
               System.exit(0);
            }
        });
        
        p6.addMouseListener(new  MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                System.exit(0);
            }
            
        });
        
        p3.addMouseListener(new  MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                pp.setVisible(false);
                CV.main();
            }
            
        });
        
        p2.addMouseListener(new  MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                pp.setVisible(false);
                if(!FicheiroAdmin.ficheiroExite()){
                    CadastroAdmin.main();
                }else{
                    pp.setVisible(false);
                    CadastrarUser.main();
                }
                   
            }
            
        });
        
        p1.addMouseListener(new  MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if(FicheiroAdmin.ficheiroExite()){
                   pp.setVisible(false);
                   Login.main();
                }else{
                    JOptionPane.showMessageDialog(null,"Aguarde por um ADMINISTRADOR","",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
            
        });
         

        pp.setVisible(true);
    }
    
}
