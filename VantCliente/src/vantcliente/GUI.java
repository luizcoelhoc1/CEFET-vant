package vantcliente;

import java.awt.Color;
import java.awt.Point;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Luiz Carlos, Gabriel Silva, Matheus, Gabriel Megda
 */
public class GUI extends javax.swing.JFrame {

    public GUI() {

        //inicia as variaveis
        this.pontoDestino = new Point();
        this.pontoOrigem = new Point();
        this.historico = new ArrayList<>();
        this.podeLancarInterrogacao = false;

        //altera o fundo
        Color corFundo = new Color(171, 107, 255);
        getContentPane().setBackground(corFundo);

        initComponents();

        //teoricamente conecta com o servidor
        try {
            this.cliente = new Socket("127.0.0.1", 8888);
            this.in = new DataInputStream(cliente.getInputStream());
            this.out = new DataOutputStream(cliente.getOutputStream());
        } catch (UnknownHostException ex) {
            System.out.println("unknownHost");
        } catch (IOException ex) {
            System.out.println("io");
        }
    }

    /**
     * Transforma pixel em grau no mapa
     *
     * @param pixel
     * @param xOrY
     * @return Grau
     */
    public int pixelToGrau(int pixel, boolean xOrY) {
        double grau;
        if (xOrY) {
            grau = ((pixel * 360) / 800) - 180;
        } else {
            grau = ((pixel * -180) / 400) + 90;
        }
        return (int) grau;
    }

    /**
     * Transforma grau em pixel no mapa
     *
     * @param grau
     * @param xOrY
     * @return pixel
     */
    public int grauToPixel(int grau, boolean xOrY) {
        double pixel;
        if (xOrY) {
            pixel = ((grau * 800) / 360) + 400;
        } else {
            pixel = ((grau * 400) / 180) - 200;
            pixel *= -1;
        }
        return (int) pixel;
    }

    /**
     * converte Km por hora para Pixel por segundo
     *
     * @param kmph
     * @return Pixel/segundo
     */
    public double kmPorHoraToPixelPorSegundo(double kmph) {
        //xx km/s                              ypx/s
        //raioDaTerra/pixelmapa km/3600s       1px/1s
        return kmph / 45.98;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        cbHistorico = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfLongitudeOrigem = new javax.swing.JTextField();
        tfLatitudeDestino = new javax.swing.JTextField();
        tfLatitudeOrigem = new javax.swing.JTextField();
        tfLongitudeDestino = new javax.swing.JTextField();
        bLancar = new javax.swing.JButton();
        bAbortar = new javax.swing.JButton();
        lMapa = new Label(this.pontoOrigem, this.pontoDestino);
        jLabel2 = new javax.swing.JLabel();
        rbOrigem = new javax.swing.JRadioButton();
        rbDestino = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        bLimpar = new javax.swing.JButton();
        bDefinir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        tfVelocidade = new javax.swing.JTextField();
        jlContador = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jlOrigemDefinidoX = new javax.swing.JLabel();
        jlDestinoDefinidoX = new javax.swing.JLabel();
        jlOrigemDefinidoY = new javax.swing.JLabel();
        jlDestinoDefinidoY = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 255, 102));

        cbHistorico.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbHistoricoPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Histórico");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Latitude Origem: ");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Longitude Origem: ");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Latitude Destino: ");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Longitude Destino: ");

        tfLongitudeOrigem.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        tfLatitudeDestino.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        tfLatitudeOrigem.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        tfLongitudeDestino.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        bLancar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bLancar.setText("Lançar VANT!");
        bLancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLancarActionPerformed(evt);
            }
        });

        bAbortar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bAbortar.setText("Abortar");
        bAbortar.setMaximumSize(new java.awt.Dimension(171, 32));
        bAbortar.setMinimumSize(new java.awt.Dimension(171, 32));
        bAbortar.setPreferredSize(new java.awt.Dimension(171, 32));

        lMapa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/earth.jpg"))); // NOI18N
        lMapa.setText("jLabel7");
        lMapa.setPreferredSize(new java.awt.Dimension(800, 400));
        lMapa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lMapaMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("Lançador de VANTs");

        buttonGroup1.add(rbOrigem);
        rbOrigem.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rbOrigem.setText("Ponto Origem");

        buttonGroup1.add(rbDestino);
        rbDestino.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rbDestino.setText("Ponto Destino");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Definir pelo Mapa:");

        bLimpar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bLimpar.setText("Limpar Ponto");
        bLimpar.setMaximumSize(new java.awt.Dimension(197, 32));
        bLimpar.setMinimumSize(new java.awt.Dimension(197, 32));
        bLimpar.setPreferredSize(new java.awt.Dimension(171, 32));
        bLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLimparActionPerformed(evt);
            }
        });

        bDefinir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bDefinir.setText("Definir");
        bDefinir.setMaximumSize(new java.awt.Dimension(197, 32));
        bDefinir.setMinimumSize(new java.awt.Dimension(197, 32));
        bDefinir.setPreferredSize(new java.awt.Dimension(171, 32));
        bDefinir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDefinirActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Velocidade:");

        tfVelocidade.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        jlContador.setBackground(new java.awt.Color(102, 255, 102));
        jlContador.setFont(new java.awt.Font("Traditional Arabic", 3, 72)); // NOI18N
        jlContador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlContador.setToolTipText("");

        jLabel9.setText("Km/h");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("Origem: ");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("Destino: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)
                        .addGap(24, 24, 24)
                        .addComponent(tfLatitudeOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel3)
                        .addGap(10, 10, 10)
                        .addComponent(tfLongitudeOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel5)
                        .addGap(21, 21, 21)
                        .addComponent(tfLatitudeDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel6)
                        .addGap(8, 8, 8)
                        .addComponent(tfLongitudeDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel7)
                        .addGap(63, 63, 63)
                        .addComponent(tfVelocidade, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bDefinir, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(bLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(bLancar)
                        .addGap(10, 10, 10)
                        .addComponent(bAbortar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbOrigem)
                                    .addComponent(rbDestino)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(cbHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jlOrigemDefinidoX, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlOrigemDefinidoY, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlDestinoDefinidoX, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlDestinoDefinidoY, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lMapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlContador, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jLabel4))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel1))
                            .addComponent(tfLatitudeOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel3))
                            .addComponent(tfLongitudeOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel5))
                            .addComponent(tfLatitudeDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel6))
                            .addComponent(tfLongitudeDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel7))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfVelocidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bDefinir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bLancar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bAbortar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbOrigem)
                                .addGap(2, 2, 2)
                                .addComponent(rbDestino)))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jlOrigemDefinidoX, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlDestinoDefinidoX, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlOrigemDefinidoY, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlDestinoDefinidoY, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lMapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jlContador, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addComponent(jLabel4)
                .addGap(11, 11, 11)
                .addComponent(cbHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Evento quando seleciona algum item do menu ele vê qual origem o usuário
     * quer da fila de historico e coloca as coordenadas nos Text Field
     */
    private void cbHistoricoPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbHistoricoPopupMenuWillBecomeInvisible
        try {
            if (cbHistorico.getSelectedItem().toString().equals("Ultima origem")) {
                tfLatitudeOrigem.setText(String.valueOf(pixelToGrau(historico.get(historico.size() - 1).y, false)));
                tfLongitudeOrigem.setText(String.valueOf(pixelToGrau(historico.get(historico.size() - 1).x, true)));
            }
            if (cbHistorico.getSelectedItem().toString().equals("Penultima origem")) {
                tfLatitudeOrigem.setText(String.valueOf(pixelToGrau(historico.get(historico.size() - 2).y, false)));
                tfLongitudeOrigem.setText(String.valueOf(pixelToGrau(historico.get(historico.size() - 2).x, true)));
            }
            if (cbHistorico.getSelectedItem().toString().equals("Antepenultima origem")) {
                tfLatitudeOrigem.setText(String.valueOf(pixelToGrau(historico.get(historico.size() - 3).y, false)));
                tfLongitudeOrigem.setText(String.valueOf(pixelToGrau(historico.get(historico.size() - 3).x, true)));

            }
            if (cbHistorico.getSelectedItem().toString().equals("Ante-antepenúltima origem")) {
                tfLatitudeOrigem.setText(String.valueOf(pixelToGrau(historico.get(historico.size() - 4).y, false)));
                tfLongitudeOrigem.setText(String.valueOf(pixelToGrau(historico.get(historico.size() - 4).x, true)));
            }
            if (cbHistorico.getSelectedItem().toString().equals("Ante-anteantepenúltima origem")) {
                tfLatitudeOrigem.setText(String.valueOf(pixelToGrau(historico.get(historico.size() - 5).y, false)));
                tfLongitudeOrigem.setText(String.valueOf(pixelToGrau(historico.get(historico.size() - 5).x, true)));
            }
        } catch (Exception e) {
            System.out.println("foda-se vc fdp");
        }
    }//GEN-LAST:event_cbHistoricoPopupMenuWillBecomeInvisible

    /**
     * Evento do click botão Lancar conta e lança o míssel... digo o vant
     */
    private void bLancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLancarActionPerformed
        if (podeLancarInterrogacao) { //se pode lançar então lança

            // contagem regressiva
            Thread contagem = new Thread(new ContagemRegressiva(jlContador));
            contagem.start();
            Thread x = new Thread(new ContagemSound());
            //x.start();

            //desenhando o lançamento
            Thread desenhista = new Thread(new Desenhando((Label) lMapa, this.velocidade));
            desenhista.start();
        } else {// se não pode lançar aparece mensaginha
            JOptionPane.showMessageDialog(rootPane, "Não foi definido ainda certos itens");
        }


    }//GEN-LAST:event_bLancarActionPerformed

    /**
     * Evento do botão definir Ele define tudo que precisa ser definido.(avá)
     */
    private void bDefinirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDefinirActionPerformed
        try {
            //define os pontos 
            pontoOrigem.x = Integer.valueOf(tfLongitudeOrigem.getText());
            pontoOrigem.y = Integer.valueOf(tfLatitudeOrigem.getText());
            pontoDestino.x = Integer.valueOf(tfLongitudeDestino.getText());
            pontoDestino.y = Integer.valueOf(tfLatitudeDestino.getText());

            //adiciona no histórico
            historico.add(pontoOrigem);
            if (historico.size() > 5) {
                historico.remove(0);
            } else {
                if (cbHistorico.getItemCount() == 4) {
                    cbHistorico.addItem("Ante-anteantepenúltimo origem");
                }
                if (cbHistorico.getItemCount() == 3) {
                    cbHistorico.addItem("Ante-antepenúltimo origem");
                }
                if (cbHistorico.getItemCount() == 2) {
                    cbHistorico.addItem("Antepenultima origem");
                }
                if (cbHistorico.getItemCount() == 1) {
                    cbHistorico.addItem("Penultima origem");
                }
                if (cbHistorico.getItemCount() == 0) {
                    cbHistorico.addItem("Ultima origem");
                }
            }

            //muda o label's dos definidos
            this.jlOrigemDefinidoX.setText(String.valueOf(this.pontoOrigem.x));
            this.jlOrigemDefinidoY.setText(String.valueOf(this.pontoOrigem.y));
            this.jlDestinoDefinidoX.setText(String.valueOf(this.pontoDestino.x));
            this.jlDestinoDefinidoY.setText(String.valueOf(this.pontoDestino.y));

            //passa todos os pontos pra Pixel
            pontoOrigem.x = grauToPixel(pontoOrigem.x, true);
            pontoOrigem.y = grauToPixel(pontoOrigem.y, false);
            pontoDestino.x = grauToPixel(pontoDestino.x, true);
            pontoDestino.y = grauToPixel(pontoDestino.y, false);

            //pinta na tela a bolinha e o xis no mapa
            ((Label) lMapa).setOrigem(pontoOrigem);
            ((Label) lMapa).setDestino(pontoDestino);
            repaint();

            //define a velocidade
            this.velocidade = kmPorHoraToPixelPorSegundo(Double.valueOf(this.tfVelocidade.getText()));

            //se chegou até aqui tudo bem, pode lançar
            podeLancarInterrogacao = true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e);

            //se não passoui por tudo não pode lançar não...
            podeLancarInterrogacao = false;
        }
    }//GEN-LAST:event_bDefinirActionPerformed


    private void bLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLimparActionPerformed

    }//GEN-LAST:event_bLimparActionPerformed

    /**
     * Evendo do clicar no mapa ele transforma em informações útil o clique
     */
    private void lMapaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lMapaMouseClicked
        Point clicado = new Point(getMousePosition());

        //ajustando
        clicado.x -= 503;
        clicado.y -= 30;

        //transforma o ponto clicado em informação pro TextField
        if (rbOrigem.isSelected()) {//
            this.tfLatitudeOrigem.setText(String.valueOf(this.pixelToGrau(clicado.y, false)));
            this.tfLongitudeOrigem.setText(String.valueOf(this.pixelToGrau(clicado.x, true)));
        }
        if (rbDestino.isSelected()) {
            this.tfLatitudeDestino.setText(String.valueOf(this.pixelToGrau(clicado.y, false)));
            this.tfLongitudeDestino.setText(String.valueOf(this.pixelToGrau(clicado.x, true)));
        }
    }//GEN-LAST:event_lMapaMouseClicked

    /**
     * Evento de... iniciar o pro
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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    private double distancia;
    private boolean podeLancarInterrogacao;
    private DataInputStream in;
    private DataOutputStream out;
    private Socket cliente;
    private ArrayList<Point> historico;
    private double velocidade; //em pixel por segundo
    private Point pontoOrigem;
    private Point pontoDestino;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAbortar;
    private javax.swing.JButton bDefinir;
    private javax.swing.JButton bLancar;
    private javax.swing.JButton bLimpar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbHistorico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jlContador;
    private javax.swing.JLabel jlDestinoDefinidoX;
    private javax.swing.JLabel jlDestinoDefinidoY;
    private javax.swing.JLabel jlOrigemDefinidoX;
    private javax.swing.JLabel jlOrigemDefinidoY;
    private javax.swing.JLabel lMapa;
    private javax.swing.JRadioButton rbDestino;
    private javax.swing.JRadioButton rbOrigem;
    private javax.swing.JTextField tfLatitudeDestino;
    private javax.swing.JTextField tfLatitudeOrigem;
    private javax.swing.JTextField tfLongitudeDestino;
    private javax.swing.JTextField tfLongitudeOrigem;
    private javax.swing.JTextField tfVelocidade;
    // End of variables declaration//GEN-END:variables
}

