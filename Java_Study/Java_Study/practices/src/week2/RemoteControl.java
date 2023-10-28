package week2;

public interface RemoteControl {
    // 상수 필드 (static final)
    int MAX_VOLUME = 10;
    int MIN_VOLUME = 0;

    // 추상 메서드
    void turnOn();
    void turnOff();
    void setVolume(int volume);

    // 디폴트 메서드
    public default void setMute(boolean mute){
        if(mute){
            System.out.println("무음 처리 합니다.");
            setVolume(MIN_VOLUME);
        }else{
            System.out.println("무음 제거합니다.");
        }
    }

    // 정적 메서드
    public static void changeBattery(){
        System.out.println("리모컨 건전지를 교환합니다.");
    }
}
