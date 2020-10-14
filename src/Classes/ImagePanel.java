/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 *
 * @author K00243015
 */
public class ImagePanel extends JPanel
{
    Image image;
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    public ImagePanel()
    {
        image = toolkit.getImage("IMG/splash.gif");
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (image != null)
            g.drawImage(image, 0, 0, this);
    }
}
