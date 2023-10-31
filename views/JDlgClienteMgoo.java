/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import bean.ClienteMgoo;
import dao.ClienteMgoo_DAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import tools.Util;

/**
 *
 * @author u10916731103
 */
public class JDlgClienteMgoo extends javax.swing.JDialog {
 
    private boolean incluindo;
    MaskFormatter mascaraCPF, mascaraDataNascimento,mascaraRg,mascaraCep,mascaraTelefone, mascaraCelular;
    /**
     * Creates new form JDlgClienteMgoo
     */
    public JDlgClienteMgoo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Util.habilitar(false, jTxtCodigo, jTxtNome, jTxtApelido, jFmtCpf, jFmtDataNascimento,jCboSexo,jCboTipoPagamento,jFmtCelular, jFmtCep, jFmtRenavam,jFmtTelefone,jFmtRg,jTxtComplemento,jTxtEmail,jTxtEndereco, jBtnConfirmar, jBtnAlterar, jBtnExcluir );
        Util.habilitar(true,jBtnIncluir, jBtnCancelar, jBtnPesquisar);
        setTitle("Cadastro de clientes");
        setLocationRelativeTo(null);
        
        try {
            mascaraCPF = new MaskFormatter( "###.###.###-##" );
            mascaraDataNascimento = new MaskFormatter("##/##/####");
            mascaraRg= new MaskFormatter("#.###.###");
            mascaraCep=new MaskFormatter("#####-###");
            mascaraTelefone= new MaskFormatter("####-####");
            mascaraCelular= new MaskFormatter("(+##)## ####-####");
        } catch (ParseException ex) {
            Logger.getLogger(JDlgClienteMgoo.class.getName()).log(Level.SEVERE, null, ex);
        }
       jFmtCpf.setFormatterFactory( new DefaultFormatterFactory( mascaraCPF )); 
       jFmtDataNascimento.setFormatterFactory( new DefaultFormatterFactory(mascaraDataNascimento));
       jFmtRg.setFormatterFactory( new DefaultFormatterFactory( mascaraRg )); 
       jFmtCep.setFormatterFactory( new DefaultFormatterFactory( mascaraCep )); 
       jFmtTelefone.setFormatterFactory( new DefaultFormatterFactory( mascaraTelefone ));
       jFmtCelular.setFormatterFactory( new DefaultFormatterFactory( mascaraCelular ));
    }

    @Override
    public void pack() {
        super.pack(); //To change body of generated methods, choose Tools | Templates.
    }
   
    
    
     public void limparCampos() {
        jTxtCodigo.setText("");
        jTxtNome.setText("");
        jTxtApelido.setText("");
        jFmtCpf.setText("");
        jFmtDataNascimento.setText("");
        jFmtRg.setText("");
        jTxtEmail.setText("");
        jCboSexo.setSelectedIndex(-1);
        jFmtTelefone.setText("");
        jFmtCelular.setText("");
        jFmtRenavam.setText("");
        jCboTipoPagamento.setSelectedIndex(-1);
        jFmtCep.setText("");
        jTxtEndereco.setText("");
        jTxtComplemento.setText("");

        
    }
    
   public ClienteMgoo viewBean() {
          ClienteMgoo clienteMgoo = new ClienteMgoo();
        int id = Integer.valueOf(jTxtCodigo.getText());
        
        clienteMgoo.setIdClienteMgoo(id);
        clienteMgoo.setNomeMgoo(jTxtNome.getText());
        clienteMgoo.setApelidoMgoo(jTxtApelido.getText());
        clienteMgoo.setCpfMgoo(jFmtCpf.getText());
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            clienteMgoo.setDataNascimentoMgoo(formato.parse(jFmtDataNascimento.getText()));
        } catch (ParseException ex) {
            Logger.getLogger(JDlgClienteMgoo.class.getName()).log(Level.SEVERE, null, ex);
        }
        clienteMgoo.setRgMgoo(jFmtRg.getText());
        clienteMgoo.setEmailMgoo(jTxtEmail.getText());
        clienteMgoo.setSexoMgoo(jCboSexo.getSelectedIndex());
        clienteMgoo.setTelefoneMgoo(jFmtTelefone.getText());
        clienteMgoo.setCelularMgoo(jFmtCelular.getText());
        clienteMgoo.setCpfMgoo(jFmtRenavam.getText());
        clienteMgoo.setTipoPagamentoMgoo(jCboTipoPagamento.getSelectedIndex());
        clienteMgoo.setCepMgoo(jFmtCep.getText());
        clienteMgoo.setEnderecoMgoo(jTxtEndereco.getText());
        clienteMgoo.setComplementoMgoo(jTxtComplemento.getText());
        
        return clienteMgoo;
        
   } 
   
           
   public ClienteMgoo beanView(ClienteMgoo clienteMgoo){
     String id = String.valueOf(clienteMgoo.getIdClienteMgoo());
       
       jTxtCodigo.setText( id );
       jTxtNome.setText(clienteMgoo.getNomeMgoo() );
       jTxtApelido.setText(clienteMgoo.getApelidoMgoo());
       jFmtCpf.setText(clienteMgoo.getCpfMgoo());
       SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
       jFmtDataNascimento.setText(formato.format(clienteMgoo.getDataNascimentoMgoo()));
       jFmtRg.setText(clienteMgoo.getRgMgoo());
       jTxtEmail.setText(clienteMgoo.getEmailMgoo());
       jCboSexo.setSelectedIndex( clienteMgoo.getSexoMgoo());
       jFmtTelefone.setText(clienteMgoo.getTelefoneMgoo());
       jFmtCelular.setText(clienteMgoo.getCelularMgoo());
       jFmtRenavam.setText(clienteMgoo.getRenavamMgoo());
       jCboTipoPagamento.setSelectedIndex( clienteMgoo.getTipoPagamentoMgoo());
       jFmtCep.setText(clienteMgoo.getCepMgoo());
       jTxtEndereco.setText(clienteMgoo.getEnderecoMgoo());
       jTxtComplemento.setText(clienteMgoo.getComplementoMgoo());
       
        return clienteMgoo;
        
   }
       
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTxtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTxtApelido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jFmtCpf = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jFmtDataNascimento = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jCboSexo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jBtnIncluir = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnConfirmar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jBtnPesquisar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jCboTipoPagamento = new javax.swing.JComboBox<>();
        jTxtEmail = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTxtEndereco = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTxtComplemento = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTxtCodigo = new javax.swing.JTextField();
        jFmtRg = new javax.swing.JFormattedTextField();
        jFmtTelefone = new javax.swing.JFormattedTextField();
        jFmtCelular = new javax.swing.JFormattedTextField();
        jFmtRenavam = new javax.swing.JFormattedTextField();
        jFmtCep = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("RG");

        jLabel2.setText("Nome");

        jTxtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtNomeActionPerformed(evt);
            }
        });

        jLabel3.setText("Apelido");

        jLabel4.setText("CPF");

        jLabel5.setText("Data de Nascimento");

        jLabel6.setText("telefone");

        jLabel7.setText("sexo");

        jCboSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feminino", "Masculino" }));
        jCboSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCboSexoActionPerformed(evt);
            }
        });

        jLabel8.setText("Email");

        jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/incluir.png"))); // NOI18N
        jBtnIncluir.setText("Incluir");
        jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirActionPerformed(evt);
            }
        });

        jBtnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alterar.png"))); // NOI18N
        jBtnAlterar.setText("Alterar");
        jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarActionPerformed(evt);
            }
        });

        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Excluir.png"))); // NOI18N
        jBtnExcluir.setText("Excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jBtnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/confirmar.png"))); // NOI18N
        jBtnConfirmar.setText("Confirmar");
        jBtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConfirmarActionPerformed(evt);
            }
        });

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jBtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pesquisar.png"))); // NOI18N
        jBtnPesquisar.setText("Pesquisar");
        jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisarActionPerformed(evt);
            }
        });

        jLabel9.setText("celular");

        jLabel10.setText("Renavam");

        jLabel11.setText("Tipo de pagamento");

        jCboTipoPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cartão", "Pix", "Dinheiro" }));

        jLabel12.setText("Endereço");

        jLabel13.setText("Complemento");

        jLabel14.setText("CEP");

        jLabel15.setText("Código");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnIncluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnAlterar)
                        .addGap(37, 37, 37)
                        .addComponent(jBtnExcluir)
                        .addGap(48, 48, 48)
                        .addComponent(jBtnConfirmar)
                        .addGap(44, 44, 44)
                        .addComponent(jBtnCancelar)
                        .addGap(30, 30, 30)
                        .addComponent(jBtnPesquisar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTxtApelido)
                            .addComponent(jTxtNome)
                            .addComponent(jTxtComplemento)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel15)
                            .addComponent(jTxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jFmtCep)
                                    .addComponent(jTxtEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFmtCelular, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFmtCpf, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel5)
                                            .addComponent(jFmtDataNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                            .addComponent(jLabel7)
                                            .addComponent(jCboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel10)
                                            .addComponent(jFmtRenavam))
                                        .addGap(62, 62, 62)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jFmtRg)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel11)
                                                    .addComponent(jLabel1)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jCboTipoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 78, Short.MAX_VALUE))
                                            .addComponent(jFmtTelefone)))
                                    .addComponent(jTxtEndereco))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtApelido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFmtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCboTipoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtRenavam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnIncluir)
                    .addComponent(jBtnAlterar)
                    .addComponent(jBtnExcluir)
                    .addComponent(jBtnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnCancelar)
                    .addComponent(jBtnPesquisar))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtNomeActionPerformed

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed
        // TODO add your hand habilitar();
        Util.habilitar(true, jTxtCodigo, jTxtNome, jTxtApelido, jFmtCpf, jFmtDataNascimento,jCboSexo,jCboTipoPagamento,jFmtCelular, jFmtCep, jFmtRenavam,jFmtTelefone,jFmtRg,jTxtComplemento,jTxtEmail,jTxtEndereco, jBtnConfirmar, jBtnAlterar, jBtnExcluir );
        Util.habilitar(false,jBtnIncluir, jBtnCancelar, jBtnPesquisar);
        Util.limparCampos(jTxtCodigo, jTxtNome, jTxtApelido, jFmtCpf, jFmtDataNascimento,jCboSexo,jCboTipoPagamento,jFmtCelular, jFmtCep, jFmtRenavam,jFmtTelefone,jFmtRg,jTxtComplemento,jTxtEmail,jTxtEndereco);
        incluindo = true;
    }//GEN-LAST:event_jBtnIncluirActionPerformed

    private void jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarActionPerformed
        Util.habilitar(true, jTxtCodigo, jTxtNome, jTxtApelido, jFmtCpf, jFmtDataNascimento,jCboSexo,jCboTipoPagamento,jFmtCelular, jFmtCep, jFmtRenavam,jFmtTelefone,jFmtRg,jTxtComplemento,jTxtEmail,jTxtEndereco, jBtnConfirmar, jBtnAlterar, jBtnExcluir );
        incluindo = false;
    }//GEN-LAST:event_jBtnAlterarActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        // TODO add your handling code here:
        if (Util.perguntar("Deseja excluir o registro?") == true) {
          
            } else {
                Util.mensagem("Exclusão cancelada");
            }
        
                  Util.limparCampos(jTxtCodigo, jTxtNome, jTxtApelido, jFmtCpf, jFmtDataNascimento,jCboSexo,jCboTipoPagamento,jFmtCelular, jFmtCep, jFmtRenavam,jFmtTelefone,jFmtRg,jTxtComplemento,jTxtEmail,jTxtEndereco);
                                    

    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmarActionPerformed
        // TODO add your handling code here:
        
         Util.habilitar(true, jTxtCodigo, jTxtNome, jTxtApelido, jFmtCpf, jFmtDataNascimento,jCboSexo,jCboTipoPagamento,jFmtCelular, jFmtCep, jFmtRenavam,jFmtTelefone,jFmtRg,jTxtComplemento,jTxtEmail,jTxtEndereco, jBtnConfirmar, jBtnAlterar, jBtnExcluir, jBtnCancelar );
        Util.habilitar(false,jBtnIncluir, jBtnPesquisar);
        Util.limparCampos(jTxtCodigo, jTxtNome, jTxtApelido, jFmtCpf, jFmtDataNascimento,jCboSexo,jCboTipoPagamento,jFmtCelular, jFmtCep, jFmtRenavam,jFmtTelefone,jFmtRg,jTxtComplemento,jTxtEmail,jTxtEndereco);
       
    }//GEN-LAST:event_jBtnConfirmarActionPerformed

    private void jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisarActionPerformed
         String resp = JOptionPane.showInputDialog(null, "Entre com o código (PK)",
                "Pesquisar", 2);
        int id = Integer.parseInt(resp);
       
        
        ClienteMgoo_DAO ClienteMgoo_DAO = new ClienteMgoo_DAO();
       ClienteMgoo clienteMgoo = (ClienteMgoo)  ClienteMgoo_DAO.list(id);
       
        beanView(clienteMgoo);

    }//GEN-LAST:event_jBtnPesquisarActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        // TODO add your handling code here:
        Util.habilitar(false);
        Util.mensagem("Cancelamento concluido");
        
       Util.limparCampos(jTxtCodigo, jTxtNome, jTxtApelido, jFmtCpf, jFmtDataNascimento,jCboSexo,jCboTipoPagamento,jFmtCelular, jFmtCep, jFmtRenavam,jFmtTelefone,jFmtRg,jTxtComplemento,jTxtEmail,jTxtEndereco);
        
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jCboSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCboSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCboSexoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDlgClienteMgoo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgClienteMgoo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgClienteMgoo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgClienteMgoo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgClienteMgoo dialog = new JDlgClienteMgoo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAlterar;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnConfirmar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JButton jBtnPesquisar;
    private javax.swing.JComboBox<String> jCboSexo;
    private javax.swing.JComboBox<String> jCboTipoPagamento;
    private javax.swing.JFormattedTextField jFmtCelular;
    private javax.swing.JFormattedTextField jFmtCep;
    private javax.swing.JFormattedTextField jFmtCpf;
    private javax.swing.JFormattedTextField jFmtDataNascimento;
    private javax.swing.JFormattedTextField jFmtRenavam;
    private javax.swing.JFormattedTextField jFmtRg;
    private javax.swing.JFormattedTextField jFmtTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTxtApelido;
    private javax.swing.JTextField jTxtCodigo;
    private javax.swing.JTextField jTxtComplemento;
    private javax.swing.JTextField jTxtEmail;
    private javax.swing.JTextField jTxtEndereco;
    private javax.swing.JTextField jTxtNome;
    // End of variables declaration//GEN-END:variables

    

  

   
}
