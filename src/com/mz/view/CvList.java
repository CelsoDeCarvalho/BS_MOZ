package com.mz.view;


import com.mz.controller.FicheiroCurriculos;
import com.mz.controller.FicheiroFuncionarios;
import com.mz.model.Funcionario;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
/**
 *
 * @author celso
 */
public class CvList extends JFrame{
    
    public CvList(){
        setSize(700,350);
        setResizable(false);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setTitle("LISTA CV");
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
        
        
        CvList cvList=new CvList();
        
        //DECLARACOES=============================
        JButton del=new JButton("Apagar");
        JButton contratar=new JButton("Contratar");
        JButton voltar=new JButton("Voltar");
        JButton limpar=new JButton("Limpar");
        
        JPanel painel=new JPanel();
        JPanel painelEsquerda=new JPanel();
        JPanel painelDireita=new JPanel();
        JList lista=new JList();
        JLabel foto=new JLabel();
        JTextField nome=new JTextField();
        JTextField apelido=new JTextField();
        JTextField sexo=new JTextField();
        JTextField bi=new JTextField();
        JTextField data=new JTextField();
        JTextField telefone=new JTextField();
        JTextField grau=new JTextField();
        JTextField local=new JTextField();
        JTextField estado=new JTextField();
        JTextField email=new JTextField();
        JTextField linguas=new JTextField();
        JPanel pic=new JPanel();
        JLabel texto=new JLabel("<----- SELECIONE O CV");
        Font font0=new Font(Font.SANS_SERIF,Font.BOLD,14);
                
        DefaultListModel modelo=new DefaultListModel();
        JScrollPane rolagem=new JScrollPane(lista);

        //CONFIGURACOES===========================
        texto.setFont(font0);
        painel.setLayout(null);
        painelEsquerda.setLayout(null);
        painelDireita.setLayout(null);
        painelEsquerda.setBounds(0,0,350,350);
        painelDireita.setBounds(350,0,700,237);
        lista.setBounds(0,0,350,350);
        rolagem.setBounds(0,0,350,350);
        
        voltar.setBounds(350,237,115,42);
        limpar.setBounds(350,280,115,42);
        
        del.setBounds(465,237,115,85);
        texto.setBounds(450,130,200,30);
        contratar.setBounds(580,237,115,85);
        painelDireita.setVisible(false);
        contratar.setVisible(false);
        del.setVisible(false);

        //ADICOES=================================
        cvList.add(painel);
        painel.add(texto);
        painel.add(painelEsquerda);
        painel.add(painelDireita);
        painelEsquerda.add(rolagem);
        painel.add(voltar);
        painel.add(limpar);
        painel.add(del);
        painel.add(contratar);
        
        //ADICAO A LISTA=========================
        FicheiroCurriculos.ler();
        for(int i=0;i<FicheiroCurriculos.lerCurriculos.size();i++){
            modelo.add(i,FicheiroCurriculos.lerCurriculos.get(i));
        }
        lista.setModel(modelo);

        //CORES===================================
        painelEsquerda.setBackground(Color.WHITE);
        painel.setBackground(Color.DARK_GRAY);
        painelDireita.setBackground(Color.WHITE);
        contratar.setBackground(new Color(33, 92, 86));
        del.setBackground(new Color(179, 64, 44));
        texto.setForeground(Color.WHITE);
        
   
        //EVENTOS=================================
         lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         lista.addListSelectionListener((ListSelectionEvent SelectionEvent)->{
            
          if(lista.getValueIsAdjusting()==true){        
            int posicao=lista.getSelectedIndex();
            //DECLARACOES=================================================
            Font font=new Font(Font.SANS_SERIF,Font.BOLD,14);
            ImageIcon icon=null;   

            if(!FicheiroCurriculos.lerCurriculos.get(posicao).getCaminhoImg().equals("/com/mz/fotos/perfil.png")){
                try{
                    icon=new ImageIcon(FicheiroCurriculos.lerCurriculos.get(posicao).getCaminhoImg());
                }catch(NullPointerException nu){
                    JOptionPane.showMessageDialog(null,"Foto nao encontrada","",JOptionPane.INFORMATION_MESSAGE);
                    icon=new ImageIcon(cvList.getClass().getResource("/com/mz/fotos/perfil.png"));
                }
            }else  icon=new ImageIcon(cvList.getClass().getResource("/com/mz/fotos/perfil.png"));
                
     
            //CONFIGURACOES===================================================
            painelDireita.setVisible(true);
            contratar.setVisible(true);
            del.setVisible(true);
            nome.setBounds(10,10,170,25);
            apelido.setBounds(10,35,170,25);
            email.setBounds(10,210,335,25);
            bi.setBounds(10,85,170,25);
            local.setBounds(10,60,170,25);
            estado.setBounds(10,85,170,25);  
            telefone.setBounds(10,110,170,25);
            linguas.setBounds(10,135,335,25);
            grau.setBounds(10,160,335,25);
            data.setBounds(10,185,335,25); 
            sexo.setBounds(10,60,170,25); 
            pic.setBounds(200,10,125,125);
            foto.setBounds(0,0,125,125);
            pic.setLayout(null); 
            
             
            foto.setIcon(new ImageIcon(icon.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_SMOOTH)));
            
            //TEXT ENABLED==================================================
            nome.setEnabled(false);
            apelido.setEnabled(false);
            email.setEnabled(false);
            grau.setEnabled(false);
            telefone.setEnabled(false);
            sexo.setEnabled(false);
            local.setEnabled(false);
            estado.setEnabled(false);
            data.setEnabled(false);
            linguas.setEnabled(false);
            bi.setEnabled(false);
            
            //ADICAO AO PAINEL====================================================
            painelDireita.add(nome);
            painelDireita.add(apelido);
            painelDireita.add(email);
            painelDireita.add(bi);  
            painelDireita.add(sexo);
            painelDireita.add(data);
            painelDireita.add(linguas);
            painelDireita.add(telefone);
            painelDireita.add(grau);
            painelDireita.add(estado);
            painelDireita.add(local);
            painelDireita.add(pic);
            pic.add(foto);
            
            //OS SET TEX===========================================================
            nome.setText(FicheiroCurriculos.lerCurriculos.get(posicao).getNome());
            apelido.setText(FicheiroCurriculos.lerCurriculos.get(posicao).getApelido());
            bi.setText(FicheiroCurriculos.lerCurriculos.get(posicao).getBi());
            grau.setText(FicheiroCurriculos.lerCurriculos.get(posicao).getNivelAcademico());
            estado.setText(FicheiroCurriculos.lerCurriculos.get(posicao).getEstadoCivil());
            sexo.setText(FicheiroCurriculos.lerCurriculos.get(posicao).getGenero());
            local.setText(FicheiroCurriculos.lerCurriculos.get(posicao).getNacionalidade());
            String numero=""+FicheiroCurriculos.lerCurriculos.get(posicao).getContacto();
            telefone.setText(numero);
            email.setText(FicheiroCurriculos.lerCurriculos.get(posicao).getEmail());
            data.setText(FicheiroCurriculos.lerCurriculos.get(posicao).getDataNascimento());
            linguas.setText(FicheiroCurriculos.lerCurriculos.get(posicao).getLinguas());
            
            //FONTE================================================================
            nome.setFont(font);
            apelido.setFont(font);
            nome.setFont(font);
            grau.setFont(font);
            sexo.setFont(font);
            estado.setFont(font);
            email.setFont(font);
            telefone.setFont(font);
            local.setFont(font);
            linguas.setFont(font);
            data.setFont(font);
            
            //EVENTOS===============================================================
                
              del.addActionListener((ActionEvent a)->{
                 
                if(lista.getSelectedIndex()!=-1){
                   try{  
                       
                                              
                       FicheiroCurriculos.lerCurriculos.remove(lista.getSelectedIndex());
                       FicheiroCurriculos.gravaCurriculo(FicheiroCurriculos.lerCurriculos);
                       FicheiroCurriculos.ler();

                       
                       modelo.removeElementAt(lista.getSelectedIndex());
                       lista.setModel(modelo);    
                       painelDireita.setVisible(false);
                       del.setVisible(false);
                       contratar.setVisible(false);


                  
                    }catch(ArrayIndexOutOfBoundsException as){
                    }  
                } 
                
              });             
              
              
            contratar.addActionListener((ActionEvent as)->{
                
                cvList.setVisible(false);
                
                JFrame contrato=new JFrame();

                contrato.setSize(230,200);
                contrato.setResizable(false);
                contrato.setDefaultCloseOperation(3);
                contrato.setLocationRelativeTo(null);
                contrato.setTitle("Minimo 4000");
                JPanel painel1=new JPanel();
                contrato.add(painel1);
                painel1.setLayout(null);
        
                String cargos[]={"","Caixa","Recursos Humanos","Tesoraria","Gerente","Director","PCA"};
                JComboBox cargo=new JComboBox(cargos);
                JTextField salario=new JTextField();
                JButton voltar1=new JButton("Calcelar");
                JButton concluir=new JButton("Concluir");
        
                JLabel lCargo=new JLabel("Cargo");
                JLabel lSalario=new JLabel("Salario");
        
                cargo.setBounds(10,30,200,30);
                lCargo.setBounds(10,5,200,30);
                lSalario.setBounds(10,65,200,30);
                salario.setBounds(10,90,200,30);
                voltar1.setBounds(10,130,80,30);
                concluir.setBounds(130,130,80,30);
        
                painel1.add(cargo);
                painel1.add(salario);
                painel1.add(voltar1);
                painel1.add(concluir);
                painel1.add(lCargo);
                painel1.add(lSalario);
                        
                contrato.setVisible(true);
        
               voltar1.addActionListener((ActionEvent ae)->{
                    contrato.setVisible(false);
                    CvList.main();
                });
        
        
                concluir.addActionListener((ActionEvent ae)->{
                 
                 String carg=(String)cargo.getSelectedItem();
                 
                 try{
                     double saldo=Double.parseDouble(salario.getText());
                 }catch(NumberFormatException e){
                     JOptionPane.showMessageDialog(null,"Montante invalido","",JOptionPane.INFORMATION_MESSAGE);
                     return;
                 }
                    
                 if(carg.equals("") || salario.getText().equals("") || Double.parseDouble(salario.getText())<4000){
                     JOptionPane.showMessageDialog(null,"Campos vazios ou salario minimo invalido","",JOptionPane.INFORMATION_MESSAGE);
                     return;
                 }   
                    
                   Funcionario funcionario=new Funcionario();
                  
                  if(lista.getSelectedIndex()!=-1){
                                                            
                    funcionario=FicheiroCurriculos.lerCurriculos.get(lista.getSelectedIndex());
                    funcionario.setCargo(carg);
                    funcionario.setSalario(Double.parseDouble(salario.getText()));
                    funcionario.setContratado(true);

                     FicheiroFuncionarios.ler();
                    if(!FicheiroFuncionarios.ficheiroExiste()){
                       FicheiroFuncionarios.gravaFuncionario(FicheiroFuncionarios.lerFuncionarios);
                    }
                    FicheiroFuncionarios.lerFuncionario(funcionario);
                  
                    try{ 
                        
                                                                     
                       FicheiroCurriculos.lerCurriculos.remove(lista.getSelectedIndex());
                       FicheiroCurriculos.gravaCurriculo(FicheiroCurriculos.lerCurriculos);
                       FicheiroCurriculos.ler();
 
                                                 
                       modelo.removeElementAt(lista.getSelectedIndex());
                       lista.setModel(modelo);    
                       painelDireita.setVisible(false);
                       del.setVisible(false);
                       contratar.setVisible(false);

                    }catch(ArrayIndexOutOfBoundsException ss){
                    }
                  }    
                  
                    contrato.setVisible(false);
                    CvList.main();
                });
                                 
            });
              
          }   
         });
         
         limpar.addActionListener((ActionEvent ae)->{
            modelo.clear();
            lista.setModel(modelo);
            FicheiroCurriculos.ler();
            FicheiroCurriculos.lerCurriculos.clear();
           
            FicheiroCurriculos.gravaCurriculo(FicheiroCurriculos.lerCurriculos);
            FicheiroCurriculos.ler();
           
            painelDireita.setVisible(false);
            del.setVisible(false);
            contratar.setVisible(false);
           
         });
         
         
        voltar.addActionListener((ActionEvent ae)->{
           cvList.setVisible(false);
           FuncaoAdmin.main();
        });
      
        cvList.setVisible(true);
    }

    
}
