package decorator;

public class Yiyecek implements Yemek {

    @Override
    public void hazirla() {
        System.out.println("Yemek : Yiyecek");
    }
}
