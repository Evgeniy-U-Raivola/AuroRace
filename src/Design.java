import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.geom.AffineTransform;
import java.text.AttributedString;

public class Design extends JComponent {
     float[] dash=new float[] {10,20,10,20};

     public  void paint (Graphics g) {
          Graphics2D g1=(Graphics2D)g;
          Color clr=new Color(220, 30, 90, 255);
          Font font1=new Font("Arial",Font.TRUETYPE_FONT, 55);
          AttributedString text=new AttributedString("ФИНИШ");
          text.addAttribute(TextAttribute.FONT,font1);
          text.addAttribute(TextAttribute.FOREGROUND, clr);

          BasicStroke pen1=new BasicStroke(2);
          BasicStroke pen2=new BasicStroke(3,1,1,1,dash,0);
          g1.setColor(Color.BLACK);
          g1.setStroke(pen1);
          g1.drawLine(100,120,1110,120);
          g1.drawLine(100,240,1110,240);
          g1.drawLine(100,360,1110,360);
          g1.drawLine(100,480,1110,480);
          g1.setColor(Color.RED);
          g1.setStroke(pen2);
          g1.drawLine(1100,50,1100,550);

          AffineTransform origLabel;
          origLabel=g1.getTransform();
          AffineTransform newLabel=(AffineTransform)origLabel.clone();
          newLabel.rotate(7.85,920,320);
          g1.setTransform(newLabel);
          g1.drawString(text.getIterator(),790,100);
          g1.setTransform(origLabel);
     }
}
