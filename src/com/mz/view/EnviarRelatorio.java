package com.mz.view;

import com.mz.controller.FicheiroFuncionarios;
import com.mz.controller.FicheiroRelatorio;
import com.mz.model.Relatorio;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author celso
 */
public class EnviarRelatorio extends JFrame{
    
    public EnviarRelatorio(){
        setSize(400,250);
        setResizable(false);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
    }
    
    public static void main(int i) {
        EnviarRelatorio er=new EnviarRelatorio();
        JPanel painel=new JPanel();
        er.add(painel);
        painel.setLayout(null);
        
        JTextField nome=new JTextField();
        JTextField data=new JTextField();
        JTextField assunto=new JTextField("Relatorio");
        JTextArea texto=new JTextArea();
        JScrollPane rolagem=new JScrollPane(texto);
        
        JLabel lNome=new JLabel("DE");
        JLabel lData=new JLabel("DATA");
        JLabel lAssunto=new JLabel("ASSUNTO");
        JLabel lMesagen=new JLabel("SMS");
        
        nome.setEditable(false);
        data.setEditable(false);
        assunto.setEditable(false);
        
        JButton voltar=new JButton("Voltar");
        JButton limpar=new JButton("Limpar");
        JButton enviar=new JButton("Enviar");
        
        nome.setBounds(10,30,150,25);
        data.setBounds(10,85,150,25);
        assunto.setBounds(10,140,150,25);
        rolagem.setBounds(190,30,180,100);
        
        lNome.setBounds(10,5,100,25);
        lData.setBounds(10,60,100,25);
        lAssunto.setBounds(10,115,100,25);
        lMesagen.setBounds(190,5,100,25);
        
        voltar.setBounds(10,180,70,25);
        limpar.setBounds(90,180,80,25);
        enviar.setBounds(180,180,70,25);
        
        painel.add(nome);
        painel.add(data);
        painel.add(assunto);
        painel.add(rolagem);
        painel.add(voltar);
        painel.add(limpar);
        painel.add(enviar);
        
        painel.add(lNome);
        painel.add(lData);
        painel.add(lAssunto);
        painel.add(lMesagen);
        
        Date date = new Date(System.currentTimeMillis());
        DateFormat df = new SimpleDateFormat("dd-MM-yyy");
  
        data.setText(df.format(date.getDate()));
        
        FicheiroFuncionarios.ler();
        nome.setText(FicheiroFuncionarios.lerFuncionarios.get(i).getNome());
        
        limpar.addActionListener((ActionEvent ae)->{
            texto.setText("");
        });
        
        voltar.addActionListener((ActionEvent ae)->{
            er.setVisible(false);
            FuncaoUser.main(i);
        }); 
        
        
        enviar.addActionListener((ActionEvent ae)->{
            Relatorio relatorio=new Relatorio();
            relatorio.setAssunto(assunto.getText());
            relatorio.setData(data.getText());
            relatorio.setMandatario(nome.getText());
            relatorio.setSms(texto.getText());
            
            FicheiroRelatorio.ler();
            if(!FicheiroRelatorio.ficheiroExiste()){
                FicheiroRelatorio.gravaRelatorio(FicheiroRelatorio.relatorios);
            }
            
            FicheiroRelatorio.lerRelatorios(relatorio);
            JOptionPane.showMessageDialog(null,"Relatorio enviado","",JOptionPane.INFORMATION_MESSAGE);
             er.setVisible(false);
             FuncaoUser.main(i);
        });        
        
        er.setVisible(true);
        
    }
    
}
