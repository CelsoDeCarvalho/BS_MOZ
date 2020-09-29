
package com.mz.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

/**
 *
 * @author celso
 */
public class Mascara implements KeyListener{

    private final int tamanho=4;
    public void keyTyped(KeyEvent ke) {
        JTextField jtf=(JTextField) ke.getSource();
        char key= ke.getKeyChar();
        boolean press=(key ==KeyEvent.VK_SPACE || key ==KeyEvent.VK_DELETE || Character.isDigit(key));
        if(!press || jtf.getText().length()==tamanho){
            ke.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
    
}
