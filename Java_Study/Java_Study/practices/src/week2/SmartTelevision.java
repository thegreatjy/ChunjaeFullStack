package week2;

public class SmartTelevision implements RemoteControl, Searchable {
    @Override
    public void turnOn() {
        System.out.println("tv를 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("tv를 끕니다.");
    }

    @Override
    public void setVolume(int volume) {
        System.out.println(volume+"을 설정합니다.");
    }

    @Override
    public void search(String url) {
        System.out.println(url+"을 검색합니다.");
    }
}
