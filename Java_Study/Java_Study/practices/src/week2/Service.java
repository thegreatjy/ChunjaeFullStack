package week2;

public interface Service {
    // 정적 필드
    public static final int VAR = 0;

    // 메서드
    // 추상 메서드
    public abstract void absMthd();

    // static 메서드
    public static void sttMthd(){}
    private static void sttMthd2(){}

    // default 메서드
    public default void dftMthd(){}
    // 구현 객체에서 재정의 시, public void dftMthd(){}

    // private 메서드
    private void dftMthd2(){}
}

