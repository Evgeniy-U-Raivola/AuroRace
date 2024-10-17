import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.AttributedString;

public class Main extends JFrame {
    static JFrame Nring=new JFrame("Весёлые старты");
    static boolean isFin=false;
    static String vinner="";
    static Race[] r=new Race[5];
    static int  coordYbanner=0;

    public static void main(String[] args) throws Exception {
         String[] vehickle=new String[] {"Black","Yellow","Red","Blue","Green"};
         int[] coordY=new int[] {10,135,245,370,490};
         int[] coordX=new int[] {10,10,10,10,10};

        Nring.setBounds(0,0,1250,650);
        Nring.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Nring.setLocationRelativeTo(null);
        Nring.setResizable(true);
        Nring.getContentPane().setBackground(Color.GRAY);

        for (int i = 0; i < 5; i++) {
            r[i] = new Race(new Car(vehickle[i], coordX[i], coordY[i]));
            r[i].start();
        }
        Design d1=new Design();
        Nring.add(d1);
        Nring.setVisible(true);
// .   .    .   . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . .
        for (Race out: r) { out.join(); }
          Nring.add(new Banner()).setVisible(true);
          Nring.revalidate();
    }

   public static class Car{
   private String vehickle;
   private int coordX,coordY,wimg,himg ;
   public JLabel carIcon;

         public Car(String vehickle,int coordX, int coordY) throws IOException {
             this.vehickle=vehickle;
             this.coordY=coordY;
             this.coordX=coordX;

             BufferedImage img= ImageIO.read(new File("C:\\08_JAVA\\AutoRacing\\src\\Media\\"+vehickle+".png"));
             wimg=img.getWidth();
             himg=img.getHeight();
             carIcon=new JLabel(new ImageIcon(img));
             carIcon.setBounds(coordX,coordY,wimg,himg);
             Nring.add(carIcon);
         }
   }
   public static class Race extends Thread{
        Car carXX;
        int deltaX=0,delay=13;

        public Race(Car Car) {
            this.carXX=Car;
         }

        @Override
        public void run(){
                while (deltaX < 900) {
                    deltaX = deltaX + (int) ((Math.random() * 3) + 1);
                    try {
                        Thread.sleep(delay);
                        carXX.carIcon.setBounds(carXX.coordX + deltaX, carXX.coordY, carXX.wimg, carXX.himg);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
//              System.out.println(Thread.currentThread().getName());  // контроль запуска потоков
                if (isFin == false) { isFin = true; }
                if (vinner == "") {  vinner = carXX.vehickle;
                                     coordYbanner=carXX.coordY;}
        }
   }
   public static class Banner extends JComponent{

       @Override
       public void paint (Graphics g) {
           super.paint(g);
           Color clr2=new Color(203, 4, 4, 255);
           Font font2=new Font("Arial",Font.BOLD, 40);
           Font font3=new Font("Century",Font.BOLD,50);
           AttributedString text1=new AttributedString("ПОБЕДИТЕЛЬ ГОНКИ : ");
           AttributedString text3=new AttributedString(vinner);
           text1.addAttribute(TextAttribute.FONT,font2);
           text1.addAttribute(TextAttribute.FOREGROUND, clr2);
           g.drawString(text1.getIterator(),100,coordYbanner+60);
           text3.addAttribute(TextAttribute.FONT,font3);
           text3.addAttribute(TextAttribute.FOREGROUND, Color.BLACK);
           g.drawString(text3.getIterator(),570,coordYbanner+60);
       }
   }

}
