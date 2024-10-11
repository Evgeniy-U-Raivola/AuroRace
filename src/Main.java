import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main extends JFrame {
    static JFrame Nring=new JFrame("Весёлые старты");
    static boolean isFin=false;
    static String vinner="";

    public static void main(String[] args) throws Exception {

        String[][] cars=new String[][] {new String[]{"Black","10"}, new String[] {"Yellow","135"},
        new String[]{"Red","245"},new String[] {"Blue","370"}, new String[]{"Green","490"}};
        String vehickle;
        int coordX,coordY;

        Nring.add(new Design());
        Nring.setBounds(0,0,1250,650);
        Nring.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Nring.setLocationRelativeTo(null);
        Nring.setResizable(true);
        Nring.getContentPane().setBackground(Color.GRAY);

           for (int i = 0; i < 5; i++) {
               vehickle=cars[i][0];
                coordX=10;
                coordY=Integer.valueOf(cars[i][1]);
               new Race(new Car(vehickle,coordX,coordY)).start();
           }

        Nring.add(new Design());
        Nring.setVisible(true);
// .   .    .   . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . .

        System.out.println("  start ");


        if (isFin==true && vinner!="") { System.out.println("from main "+ vinner);}
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
        int deltaX=0,delay=20;
        public Race(Car Car) {
            this.carXX=Car;
        }

        @Override
        public void run(){
// delta <900
                while (deltaX < 200) {
                    try {
                        Thread.sleep(delay);
                        carXX.carIcon.setBounds(carXX.coordX + deltaX, carXX.coordY, carXX.wimg, carXX.himg);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    deltaX = deltaX + (int) ((Math.random() * 5) + 1);
                }
                System.out.println(carXX.vehickle+"stop");
                System.out.println(Thread.currentThread().getName());
                if (isFin == false) { isFin = true; }
                if (vinner == "") {  vinner = carXX.vehickle;
                System.out.println("vinner "+vinner);}
        }

   }

}
