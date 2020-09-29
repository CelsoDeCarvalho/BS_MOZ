package com.mz.view;

import com.mz.controller.FicheiroAdmin;
import com.mz.controller.FicheiroFuncionarios;
import com.mz.model.Administrador;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author celso
 */
public class Funcionarios extends JFrame{
    
    public Funcionarios(){
        setSize(700,345);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
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
        
        Funcionarios funcionarios=new Funcionarios();
        JPanel painel=new JPanel();
        painel.setLayout(null);
        funcionarios.add(painel);
        
        //DECLARACOES=====================================
        JPanel painelTabela=new JPanel();
        JTable tabela=new JTable();
        Object[]colunas={"Id","Nome","Apelido","Contacto","Genero","Email"};
        DefaultTableModel modelo=new DefaultTableModel();
        JScrollPane rolagem=new JScrollPane(tabela);
        JButton voltar=new JButton();
        JButton ver=new JButton();
        JButton pagamento=new JButton();
        JButton demitir=new JButton();
        JTextField pesquisa=new JTextField();
        JButton pesquisar=new JButton();
        
        JLabel lback=new JLabel("Voltar");
        JLabel lver=new JLabel("Ver Funcionario");
        JLabel lpey=new JLabel("Pagamento");
        JLabel ldismiss=new JLabel("Demitir");
        JLabel total=new JLabel();
        
        
        Object[]dados=new Object[6];
        
        //CONFIGURACOES===================================
        voltar.setBounds(20,10,70,70);
        lback.setBounds(40,80,70,20);
        ver.setBounds(110,10,70,70);
        lver.setBounds(102,80,100,20);
        pagamento.setBounds(200,10,70,70);
        lpey.setBounds(202,80,70,20);
        demitir.setBounds(290,10,70,70);
        ldismiss.setBounds(305,80,70,20);
        total.setBounds(560,100,150,20);
        pesquisa.setBounds(390,10,200,30);
        pesquisar.setBounds(590,10,30,30);
    
        painelTabela.setBounds(0,125,694,191);
        modelo.setColumnIdentifiers(colunas);
        tabela.setModel(modelo);
        rolagem.setBounds(0,0,694,191);
        painelTabela.setLayout(null);
        demitir.setOpaque(true);
        
        //ADICOES=========================================
        painel.add(painelTabela);
        painel.add(voltar);
        painel.add(lback);
        painel.add(lver);
        painel.add(ver);
        painel.add(pagamento);
        painel.add(lpey);
        painel.add(total);
        painel.add(demitir);
        painel.add(ldismiss);
        painel.add(pesquisa);
        painel.add(pesquisar);
        painelTabela.add(rolagem);
        
        //ADICIONAR A TABELA=============================
        FicheiroFuncionarios.ler();
        
        total.setText("FUNCIONARIOS: "+FicheiroFuncionarios.lerFuncionarios.size());
        
        for(int i=0;i<FicheiroFuncionarios.lerFuncionarios.size();i++){
           dados[0]=FicheiroFuncionarios.lerFuncionarios.get(i).getId();
           dados[1]=FicheiroFuncionarios.lerFuncionarios.get(i).getNome();
           dados[2]=FicheiroFuncionarios.lerFuncionarios.get(i).getApelido();
           dados[3]=FicheiroFuncionarios.lerFuncionarios.get(i).getContacto();
           dados[4]=FicheiroFuncionarios.lerFuncionarios.get(i).getGenero();
           dados[5]=FicheiroFuncionarios.lerFuncionarios.get(i).getEmail();
           modelo.addRow(dados);
        }   
        
        //FOTOS==========================================
        voltar.setIcon(new ImageIcon(funcionarios.getClass().getResource("/com/mz/fotos/icons8-back-arrow-100.png")));
        ver.setIcon(new ImageIcon(funcionarios.getClass().getResource("/com/mz/fotos/icons8-mark-view-as-non-hidden-100.png")));
        pagamento.setIcon(new ImageIcon(funcionarios.getClass().getResource("/com/mz/fotos/icons8-online-payment-100.png")));
        demitir.setIcon(new ImageIcon(funcionarios.getClass().getResource("/com/mz/fotos/icons8-unavailable-100 (1).png")));
        pesquisar.setIcon(new ImageIcon(funcionarios.getClass().getResource("/com/mz/fotos/icons8-find-user-male-30.png")));

        
        //CORES===========================================
        
        //EVENTOS=========================================
        
        voltar.addActionListener((ActionEvent ae)->{
           funcionarios.setVisible(false);
           FuncaoAdmin.main();
        });
        
        demitir.addActionListener((ActionEvent ae)->{
                          // i = the index of the selected row
                int i = tabela.getSelectedRow();
                if(i >= 0){
                    
                    modelo.removeRow(i);
                    FicheiroFuncionarios.lerFuncionarios.remove(i);
                    FicheiroFuncionarios.gravaFuncionario(FicheiroFuncionarios.lerFuncionarios);
                    total.setText("FUNCIONARIOS: "+FicheiroFuncionarios.lerFuncionarios.size());
                }
                else{
                    JOptionPane.showMessageDialog(null,"Nenhum funcionario selecionado","",JOptionPane.INFORMATION_MESSAGE);
                }
        });
        
        ver.addActionListener((ActionEvent ae)->{
          int i= tabela.getSelectedRow();
          if(i >= 0){      
          funcionarios.setVisible(false);
          
          JFrame tela=new JFrame("USER INFO");
               tela.setSize(500,250);
               tela.setResizable(false);
               tela.setDefaultCloseOperation(3);
               tela.setLocationRelativeTo(null);
               
               JPanel painel1=new JPanel();
               tela.add(painel1);
               painel1.setLayout(null);
               
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
               //JTextField t12=new JTextField();
               JTextField t13=new JTextField();
               JButton voltar1=new JButton("Voltar");
               
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
               //t12.setEditable(false);
               //t12.setEditable(false);
               
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
               //t12.setText("SALDO: "+FicheiroFuncionarios.lerFuncionarios.get(i).getSaldo());
               t13.setText("CARGO: "+FicheiroFuncionarios.lerFuncionarios.get(i).getCargo());
               
               t1.setBounds(10,10,70,25);
               t2.setBounds(85,10,200,25);
               t3.setBounds(290,10,200,25);
               t4.setBounds(10,40,200,25);
               t5.setBounds(215,40,275,25);
               t11.setBounds(215,70,120,25);
               //t12.setBounds(340,70,150,25);
               t13.setBounds(215,100,275,25);
               
               t6.setBounds(10,70,200,25);
               t7.setBounds(10,100,200,25);
               t8.setBounds(10,130,200,25);
               t9.setBounds(10,160,200,25);
               t10.setBounds(10,190,200,25);
               voltar1.setBounds(310,190,70,25);
               
               painel1.add(t1);
               painel1.add(t2);
               painel1.add(t3);
               painel1.add(t4);
               painel1.add(t5);
               painel1.add(t6);
               painel1.add(t7);
               painel1.add(t8);
               painel1.add(t9);
               painel1.add(t10);
               painel1.add(t11);
               //painel1.add(t12);
               painel1.add(t13);              
               painel1.add(voltar1);
               
               voltar1.addActionListener((ActionEvent aee)->{
                   tela.setVisible(false);
                   funcionarios.setVisible(true);
               });
               
               tela.setVisible(true);
          }else {
                   JOptionPane.showMessageDialog(null,"Nenhum funcionario selecionado","",JOptionPane.INFORMATION_MESSAGE);
                   return;
                }   
        });
        
        
        pagamento.addActionListener((ActionEvent ae)->{
            
            int i = tabela.getSelectedRow();
             if(i >= 0){
              funcionarios.setVisible(false);
              JFrame tela=new JFrame();
              tela.setSize(300,200);
              tela.setResizable(false);
              tela.setDefaultCloseOperation(3);
              tela.setLocationRelativeTo(null);
            
              JPanel pPainel=new JPanel();
              tela.add(pPainel);
              pPainel.setLayout(null);
            
              JTextField faltas=new JTextField();
              JTextField corte=new JTextField();
              JTextField receber=new JTextField();
              JButton b1=new JButton("voltar");
              JButton b2=new JButton("Gerar");
              JButton b3=new JButton("Pagar");
              JLabel f=new JLabel("FALTAS");
              JLabel c=new JLabel("CORTE");
              JLabel ar=new JLabel("A RECEBER");
            
              faltas.setBounds(100,10,100,25);
              corte.setBounds(100,40,100,25);
              receber.setBounds(100,70,100,25);
            
              f.setBounds(10,10,100,25);
              c.setBounds(10,40,100,25);
              ar.setBounds(10,70,100,25);
            
              b1.setBounds(20,140,70,30);
              b2.setBounds(105,140,70,30);
              b3.setBounds(195,140,70,30);
            
              pPainel.add(faltas);
              pPainel.add(corte);
              pPainel.add(receber);
              pPainel.add(f);
              pPainel.add(c);
              pPainel.add(ar);
              pPainel.add(b1);
              pPainel.add(b2);
              pPainel.add(b3);
              receber.setEnabled(false);
              receber.setText(""+FicheiroFuncionarios.lerFuncionarios.get(i).getSalario());
                      
              b1.addActionListener((ActionEvent aee)->{
               tela.setVisible(false);
               funcionarios.setVisible(true);
              });
              
              b2.addActionListener((ActionEvent aee)->{
                  
                try{  
                  double co=Double.parseDouble(corte.getText());
                  int fa=Integer.parseInt(faltas.getText());
                  double valorGerado=Double.parseDouble(receber.getText());
                  valorGerado=(valorGerado-co)-fa*200;
                  receber.setText(""+valorGerado);
                }catch(NumberFormatException nf){
                    
                }  

                 b2.setVisible(false);
              });
              
              faltas.addKeyListener(new KeyAdapter(){
                    private final int tamanho=2;
                    public void keyTyped(KeyEvent ke) {
                       JTextField jtf=(JTextField) ke.getSource();
                       char key= ke.getKeyChar();
                       boolean press=(key ==KeyEvent.VK_SPACE || key ==KeyEvent.VK_DELETE || Character.isDigit(key));
                       if(!press || jtf.getText().length()==tamanho){
                           ke.consume();
                       }
                    }
              });
              
              corte.addKeyListener(new KeyAdapter(){
                    private final int tamanho=3;
                    public void keyTyped(KeyEvent ke) {
                       JTextField jtf=(JTextField) ke.getSource();
                       char key= ke.getKeyChar();
                       boolean press=(key ==KeyEvent.VK_SPACE || key ==KeyEvent.VK_DELETE || Character.isDigit(key));
                       if(!press || jtf.getText().length()==tamanho){
                           ke.consume();
                       }
                    }
              });
              

              b3.addActionListener((ActionEvent aee)->{
                Administrador administrador=new Administrador();
                administrador=FicheiroAdmin.ler();
                double valor=Double.parseDouble(receber.getText());
                if(administrador.getSaldo()>=valor){
                  FicheiroFuncionarios.ler();    
                  FicheiroFuncionarios.lerFuncionarios.get(i).setSaldo(FicheiroFuncionarios.lerFuncionarios.get(i).getSaldo()+valor);
                  FicheiroFuncionarios.gravaFuncionario(FicheiroFuncionarios.lerFuncionarios);
                  administrador.setSaldo(administrador.getSaldo()-valor);
                  FicheiroAdmin.gravar(administrador);
                  JOptionPane.showMessageDialog(null,"PAGAMENTO DE "+valor+" feito com sucesso","",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null,"Saldo insuficiente","",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }  
                
              });
              
              
              
            
            tela.setVisible(true);
         }else{
                JOptionPane.showMessageDialog(null,"Nenhum funcionario selecionado","",JOptionPane.INFORMATION_MESSAGE);
                return;
             }  
        });
        
       
        
        funcionarios.setVisible(true);
    }
}
