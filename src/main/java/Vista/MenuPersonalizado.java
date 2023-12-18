/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import javax.swing.plaf.basic.BasicPopupMenuUI;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author yumii
 */
public class MenuPersonalizado extends BasicPopupMenuUI {
    @Override
    public void paint(Graphics g, JComponent c) {
        g.setColor(new Color(57, 145, 151));
        g.fillRect(0, 0, c.getWidth(), c.getHeight());
        super.paint(g, c);
    }
}