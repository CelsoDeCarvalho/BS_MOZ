package com.mz.view;
import com.mz.controller.FicheiroCurriculos;
import com.toedter.calendar.JDateChooser;
import com.mz.model.Funcionario;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.MaskFormatter;


public class Curriculo extends JFrame{
    
    
    public Curriculo(){
        setSize(450, 470);
        setResizable(false);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setTitle("Curriculo Vitae");
        
    }
    
    
    public static void main()throws ParseException{
        
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
           }
        } catch (Exception e) {
              e.printStackTrace();
          }
        
        Curriculo cv=new Curriculo();
        JPanel painel=new JPanel();
        JPanel foto=new JPanel();
        cv.add(painel);
        painel.setLayout(null);
        Funcionario funcionario=new Funcionario();
        
        //CONFIGURACOES DE FOTOS=========================================
        Icon perfilDefault=new ImageIcon(cv.getClass().getResource(funcionario.getCaminhoImg())); 
        
        String cidades[]={"","Nampula","Niassa","Cabo Delgado","Tete","Manica","Zambezia","Sofala","Inhambane","Gaza","Maputo"};
        String nivelA[]={"","Sem Nivel Academico","Ensino Primario","Ensino Secundario","Licenciatura","Mestrado","Doutoramento"};
        String estadoC[]={"","Solteiro","Casado","Viuvo"};
        String sexo[]={"","Masculino","Feminino","Outros"};
        
        //Mascaras===================================================
        MaskFormatter telefone=new MaskFormatter("+258#########");
        telefone.setValidCharacters("0123456789");
        
        //DECLARACOES=================================================
        JTextField tNome=new JTextField();
        JTextField tcaminho=new JTextField();
        JTextField tApelido=new JTextField();
        JTextField tBi=new JTextField();
        JTextField tEmail=new JTextField();
        JFormattedTextField tContacto=new JFormattedTextField(telefone);
        tContacto.setHighlighter(null);
        JDateChooser data=new JDateChooser();
        JComboBox provincia=new JComboBox(cidades);
        JComboBox nivelAcademico=new JComboBox(nivelA);
        JComboBox estadoCivil=new JComboBox(estadoC);
        JComboBox genero=new JComboBox(sexo);
        JCheckBox en=new JCheckBox("Ingles");
        JCheckBox pt=new JCheckBox("Portugues");
        JButton pic=new JButton("Escolher");
        JButton remover=new JButton("Apagar");
        JButton submeter=new JButton("Submeter");
        JButton reset=new JButton("Limpar");
        JButton back=new JButton("Voltar");
        //Labels--------------------------
        JLabel perfil=new JLabel(perfilDefault);
        JLabel lNome=new JLabel("NOME");
        JLabel lApelido=new JLabel("APELIDO");
        JLabel lBi=new JLabel("BI");
        JLabel lEmail=new JLabel("EMAIL");
        JLabel lContacto=new JLabel("TELEFONE");
        JLabel lData=new JLabel("DATA DE NASCIMENTO");
        JLabel lProvincia=new JLabel("LOCAL DE NASCIMENTO");
        JLabel lNivel=new JLabel("GRAU ACADEMICO");
        JLabel lCivil=new JLabel("ESTADO CIVIL");
        JLabel lSexo=new JLabel("SEXO");
        JLabel lLinguas=new JLabel("LINGUAS FALADAS");
        JLabel lFoto=new JLabel("SELECIONE FOTO");
        
        //CONFIGURACOES================================================
        tNome.setBounds(10,30,200,25);
        tApelido.setBounds(10,80,200,25);
        tBi.setBounds(10,130,200,25);
        data.setBounds(10,180,200,25);
        tEmail.setBounds(10,230,200,25);
        tContacto.setBounds(230,230,200,25);
        genero.setBounds(230,280,200,25);
        provincia.setBounds(10,280,200,25);
        nivelAcademico.setBounds(10,330,200,25);
        estadoCivil.setBounds(10,380,200,25);
        perfil.setBounds(280,30,100,100);
        en.setBounds(230,330,70,20);
        pt.setBounds(300,330,90,20);
        foto.setBounds(280,30,100,100);
        pic.setBounds(230,140,100,25);
        //painel.setBackground(Color.GRAY);
        lNome.setBounds(10,10,200,20);
        lApelido.setBounds(10,60,200,20);
        lBi.setBounds(10,110,200,20);
        lData.setBounds(10,160,200,20);
        lEmail.setBounds(10,210,200,20);
        lContacto.setBounds(230,210,200,20);
        lSexo.setBounds(230,260,200,20);
        lProvincia.setBounds(10,260,200,20);
        lNivel.setBounds(10,310,200,20);
        lCivil.setBounds(10,360,200,20);
        lLinguas.setBounds(230,310,200,20);
        lFoto.setBounds(280,10,150,20);
        submeter.setBounds(330,410,100,25);
        reset.setBounds(220,410,100,25);
        tcaminho.setBounds(265,170,130,25);
        tcaminho.setEditable(false);
        tcaminho.setText(funcionario.getCaminhoImg());
        remover.setBounds(330,140,100,25);
        back.setBounds(10,410,70,25);
        tContacto.setFocusLostBehavior(JFormattedTextField.PERSIST);
        
        //ADICAO AO PAINEL=============================================
        painel.add(tNome);
        painel.add(tApelido);
        painel.add(tBi);
        painel.add(data);
        painel.add(tEmail);
        painel.add(tContacto);
        painel.add(genero);
        painel.add(provincia);
        painel.add(perfil);
        painel.add(nivelAcademico);
        painel.add(estadoCivil);
        painel.add(en);
        painel.add(pt);
        painel.add(foto);
        painel.add(lNome);
        painel.add(lApelido);
        painel.add(pic);
        painel.add(lBi);
        painel.add(lData);
        painel.add(lEmail);
        painel.add(lContacto);
        painel.add(lSexo);
        painel.add(lProvincia);
        painel.add(lNivel);
        painel.add(lCivil);
        painel.add(lLinguas);
        painel.add(lFoto);
        painel.add(submeter);
        painel.add(reset);
        painel.add(tcaminho);
        painel.add(remover);
        painel.add(back);
        
        
        //CONFIGURACOES DE CORES=========================================
        foto.setBackground(Color.WHITE);
        
        
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
        
        //ACCOES========================================================
        pic.addActionListener((ActionEvent ae) -> {
            JFileChooser arquivo=new JFileChooser();
            arquivo.setFileFilter(filter);
            arquivo.setAcceptAllFileFilterUsed(false);
            arquivo.setDialogTitle("Selecione uma imagem");
            arquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int escolha=arquivo.showOpenDialog(cv);
            
            if(escolha==JFileChooser.APPROVE_OPTION){
                File file=new File("");
                file=arquivo.getSelectedFile();
                funcionario.setCaminhoImg(file.getAbsolutePath());
                ImageIcon imagem=new ImageIcon(arquivo.getSelectedFile().getPath());
                perfil.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(perfil.getWidth(), perfil.getHeight(), Image.SCALE_DEFAULT)));
                tcaminho.setText(funcionario.getCaminhoImg());
            }
        });
        
    remover.addActionListener((ActionEvent ae) -> {
        perfil.setIcon(perfilDefault);
        funcionario.setCaminhoImg("/com/mz/fotos/perfil.png");
        tcaminho.setText(funcionario.getCaminhoImg());
    });
    
    back.addActionListener((ActionEvent ae) -> {
       cv.setVisible(false);
       CV.main();
    });
    
    submeter.addActionListener((ActionEvent ae)->{
        
        //VALIDANDO CAMPOS===================================
        String l,n,e,s;
        l=(String)provincia.getSelectedItem();
        n=(String)nivelAcademico.getSelectedItem();
        e=(String)estadoCivil.getSelectedItem();
        s=(String)genero.getSelectedItem();
        
        if((tNome.getText().equals("")) ||(tApelido.getText().equals("")) ||(tBi.getText().equals(""))||(tEmail.getText().equals(""))||(data.getDate()==null)||(l.equals(""))||(n.equals(""))||(e).equals("")||(s.equals(""))||(tContacto.getText().trim().length())<13){
            JOptionPane.showMessageDialog(null,"Esapacos vazios ou incompletos","Erro",JOptionPane.INFORMATION_MESSAGE);
        }else
            if(!tContacto.getText().substring(4,6).equals("84") && (!tContacto.getText().substring(4,6).equals("82")) && (!tContacto.getText().substring(4,6).equals("86")) &&  !tContacto.getText().substring(4,6).equals("85") && (!tContacto.getText().substring(4,6).equals("83")) && (!tContacto.getText().substring(4,6).equals("87"))){
                JOptionPane.showMessageDialog(null,"Contacto invalido","Erro",JOptionPane.ERROR_MESSAGE);
            }else
            {
       
        FicheiroCurriculos.ler();
        
        for(int i=0;i<FicheiroCurriculos.lerCurriculos.size();i++){
            if(tEmail.getText().equals(FicheiroCurriculos.lerCurriculos.get(i).getEmail())){
                JOptionPane.showMessageDialog(null,"Email introduzido ja exite","",JOptionPane.INFORMATION_MESSAGE);
                return;
            }else
                if(Long.parseLong(tContacto.getText().substring(4,13))==FicheiroCurriculos.lerCurriculos.get(i).getContacto()){
                    JOptionPane.showMessageDialog(null,"Contacto introduzido ja exite","",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            
        }
         
        DateFormat df = new SimpleDateFormat("dd-MM-yyy");
        funcionario.setNome(tNome.getText());
        funcionario.setApelido(tApelido.getText());
        funcionario.setDataNascimento(df.format(data.getDate()));
        funcionario.setEmail(tEmail.getText());
        funcionario.setBi(tBi.getText());
        funcionario.setContacto(Long.parseLong(tContacto.getText().substring(4,13)));
        funcionario.setNacionalidade((String)provincia.getSelectedItem());
        funcionario.setNivelAcademico((String)nivelAcademico.getSelectedItem());
        funcionario.setGenero((String)genero.getSelectedItem());
        funcionario.setEstadoCivil((String)estadoCivil.getSelectedItem());
        int random=(int)(1000 + Math.random() * (10000 - 1000 + 1));
        
        for(int i=0;i<FicheiroCurriculos.lerCurriculos.size();i++){
            if(random==FicheiroCurriculos.lerCurriculos.get(i).getId()){
               random=(int)(1000 + Math.random() * (10000 - 1000 + 1));
               i=0;
            }
        }
        funcionario.setId(random);
        
        if((en.isSelected())&&(!pt.isSelected()))funcionario.setLinguas("Ingles");
        else
            if(pt.isSelected()&&!en.isSelected())funcionario.setLinguas("Portugues");
        else
                if(en.isSelected()&&pt.isSelected())funcionario.setLinguas("Ingles|Portugues");
        else
                    funcionario.setLinguas("");
        
        ArrayList<Funcionario> funcionarios=new ArrayList<>();
        
        if(!FicheiroCurriculos.ficheiroExite()){
            FicheiroCurriculos.gravaCurriculo(funcionarios);
        }    
        
        FicheiroCurriculos.lerCurriculo(funcionario);
        new FicheiroCurriculos().ler();
        
         tNome.setText("");
         tApelido.setText("");
         tBi.setText("");
         tContacto.setText("");
         tEmail.setText("");
         en.setSelected(false);
         pt.setSelected(false);
         nivelAcademico.setSelectedIndex(0);
         estadoCivil.setSelectedIndex(0);
         genero.setSelectedIndex(0);
         provincia.setSelectedIndex(0);
         data.setDate(null);
        perfil.setIcon(perfilDefault);
        funcionario.setCaminhoImg("/com/mz/fotos/perfil.png");
        tcaminho.setText(funcionario.getCaminhoImg());
        
        JOptionPane.showMessageDialog(null,"Curriculo submetido com sucesso\n Seu id e "+random+" Use o para fazer o \ncadastro caso for contratado.\n\n\nAGUARDE","",JOptionPane.INFORMATION_MESSAGE);
            }
        
        
    });
    
    
    reset.addActionListener((ActionEvent ae)->{
         tNome.setText("");
         tApelido.setText("");
         tBi.setText("");
         tContacto.setText("");
         tEmail.setText("");
         en.setSelected(false);
         pt.setSelected(false);
         nivelAcademico.setSelectedIndex(0);
         estadoCivil.setSelectedIndex(0);
         genero.setSelectedIndex(0);
         provincia.setSelectedIndex(0);
         data.setDate(null);
        perfil.setIcon(perfilDefault);
        funcionario.setCaminhoImg("/com/mz/fotos/perfil.png");
        tcaminho.setText(funcionario.getCaminhoImg());
         
    });
        
        cv.setVisible(true);
    }
    
    
}
