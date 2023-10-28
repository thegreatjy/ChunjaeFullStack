package week3.ch14;

import java.awt.*;

public class BeepPrintExample2 {
    public static void main(String[] args) {
        // 작업 스레드 생성
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Toolkit toolkit = Toolkit.getDefaultToolkit();

                for(int i=0; i<5; i++){
                    toolkit.beep();
                    try{
                        Thread.sleep(500);
                    }catch(Exception e){}
                }
            }
        });

        // 작업 스레드 실행
        thread.run();

        // 메인 스레드
        for (int i=0; i<5; i++){
            System.out.println("beep");
        }
        try{
            Thread.sleep(500);
        }catch (Exception e){}
    }
}
