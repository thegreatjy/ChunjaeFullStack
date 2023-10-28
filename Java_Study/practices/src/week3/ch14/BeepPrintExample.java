package week3.ch14;

import java.awt.*;

public class BeepPrintExample {
    public static void main(String[] args) {
        // toolkit 객체 얻기
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        for(int i=0; i<5; i++){
            toolkit.beep();
            try{
                Thread.sleep(500);
            }catch(Exception e){}
        }

        for (int i=0; i<5; i++){
            System.out.println("beep"   );
        }
        try{
            Thread.sleep(500);
        }catch (Exception e){}

    }
}
