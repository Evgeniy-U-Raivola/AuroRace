package Repeat;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    static JFrame BackGr=new JFrame(" Трава повсюду");
    static int widthF=800,heightF=600;

          public static void main(String[] args) {
              BackGr.setBounds(0,0,widthF,heightF);
              BackGr.setResizable(false);
              BackGr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              BackGr.setLocationRelativeTo(null);
              BackGr.add(new Picture());
              BackGr.setVisible(true);
          }

    public static class Picture extends JComponent {
           Image grass = new ImageIcon("C:\\08_JAVA\\Grass\\src\\grass.png").getImage();
           private int coordX=0,coordY=0;
           private int himg=grass.getHeight(null), wimg=grass.getWidth(null);

            public void paint (Graphics g){
            Graphics2D g1 = (Graphics2D) g;
                for (int i=0;i<800;i+=100) {
                       for (int j=0;j<600;j+=100) {
                           g1.drawImage(grass, coordX + i, coordY+j, wimg, himg, null);
                       }
                }
            }
    }

}
