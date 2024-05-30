/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vantcliente;

import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class Desenhando implements Runnable {

    final static int ESQUERDA_CIMA = 0;
    final static int ESQUERDA_BAIXO = 1;
    final static int DIREITA_CIMA = 3;
    final static int DIREITA_BAIXO = 4;
    int praQualLado;
    Label mapa;
    double velocidade;

    public Desenhando(Label mapa, double velocidade) {
        this.mapa = mapa;
        this.velocidade = velocidade;
    }

    @Override
    public void run() {

        //preparativos
        mapa.setDesenhando(true);
        mapa.setOndeTaX(mapa.getOrigem().x);
        mapa.setOndeTaY(mapa.getOrigem().y);
        try {
            Thread.sleep(5250);
        } catch (InterruptedException ex) {
            Logger.getLogger(Desenhando.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //pra qual lado ta indo
        if (mapa.getOrigem().x < mapa.getDestino().x) {//esquerda
            if (mapa.getOrigem().y < mapa.getOrigem().y) {//cima
                this.praQualLado = ESQUERDA_CIMA;
            } else {//baixo
                this.praQualLado = ESQUERDA_BAIXO;
            }
        } else { //direita 
            if (mapa.getOrigem().y < mapa.getOrigem().y) {//cima
                this.praQualLado = DIREITA_CIMA;
            } else {//baixo
                this.praQualLado = DIREITA_BAIXO;
            }
        }

        //desenha
        try {
            switch (praQualLado) {
                case DIREITA_BAIXO:
                    while ((mapa.getDestino().x > mapa.getOndeTa().x) && (mapa.getDestino().y > mapa.getOndeTa().y)) {
                        Thread.sleep(1000);
                        mapa.setOndeTaX((int) (mapa.getOndeTa().x + velocidade));
                        mapa.setOndeTaY((int) (mapa.getOndeTa().y - velocidade));
                        mapa.repaint();
                    }
                    break;
                case DIREITA_CIMA:
                    while ((mapa.getDestino().x > mapa.getOndeTa().x) && (mapa.getDestino().y < mapa.getOndeTa().y)) {
                        Thread.sleep(1000);
                        mapa.setOndeTaX((int) (mapa.getOndeTa().x + velocidade));
                        mapa.setOndeTaY((int) (mapa.getOndeTa().y + velocidade));
                        mapa.repaint();
                    }
                    break;
                case ESQUERDA_BAIXO:
                    while ((mapa.getDestino().x < mapa.getOndeTa().x) && (mapa.getDestino().y > mapa.getOndeTa().y)) {
                        Thread.sleep(1000);
                        mapa.setOndeTaX((int) (mapa.getOndeTa().x - velocidade));
                        mapa.setOndeTaY((int) (mapa.getOndeTa().y - velocidade));
                        mapa.repaint();
                    }
                    break;
                case ESQUERDA_CIMA:
                    while ((mapa.getDestino().x < mapa.getOndeTa().x) && (mapa.getDestino().y < mapa.getOndeTa().y)) {
                        Thread.sleep(1000);
                        mapa.setOndeTaX((int) (mapa.getOndeTa().x - velocidade));
                        mapa.setOndeTaY((int) (mapa.getOndeTa().y + velocidade));
                        mapa.repaint();
                    }
                    break;
            }
        } catch (InterruptedException e) {

        }

    }

}
