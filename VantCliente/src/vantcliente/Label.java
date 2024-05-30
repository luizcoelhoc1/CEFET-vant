/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vantcliente;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Luiz Carlos, Gabriel Silva, Matheus, Gabriel Megda
 */
public class Label extends javax.swing.JLabel {

    private Point origem;
    private Point destino;
    private Point ondeTa;
    private boolean podePintarInterrogacao;
    private boolean desenhando;

    public Label(Point origem, Point destino) {
        this.origem = new Point(origem);
        this.destino = new Point(destino);
        this.podePintarInterrogacao = false;

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (podePintarInterrogacao) {
            g.setColor(Color.YELLOW);
            g.fillOval(origem.x, origem.y, 10, 10);
            g.setColor(Color.RED);
            g.drawLine(destino.x - 5, destino.y + 5, destino.x + 5, destino.y - 5);
            g.drawLine(destino.x + 5, destino.y + 5, destino.x - 5, destino.y - 5);
        }
        if (isDesenhando()) {
            g.drawLine(origem.x, origem.y, ondeTa.x, ondeTa.y);
        }
    }

    public Point getOrigem() {
        return origem;
    }

    public void setOrigem(Point origem) {
        this.origem = origem;
        this.podePintarInterrogacao = true;
    }

    public Point getDestino() {
        return destino;
    }

    public void setDestino(Point destino) {
        this.destino = destino;
        this.podePintarInterrogacao = true;
    }

    public Point getOndeTa() {
        return ondeTa;
    }

    public void setOndeTaX(int ondeTa) {
        this.ondeTa.x = ondeTa;
    }

    public void setOndeTaY(int ondeTa) {
        this.ondeTa.y = ondeTa;
    }

    public boolean isDesenhando() {
        return desenhando;
    }

    public void setDesenhando(boolean desenhando) {
        this.desenhando = desenhando;
    }

}
