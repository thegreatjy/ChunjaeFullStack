package week2;

public class ServiceImpl implements Service{
    @Override
    public void absMthd() {
        System.out.println("absMthd");
    }

    @Override
    public void dftMthd() {
        Service.super.dftMthd();
    }
}
