package decorator;

public class Icecek implements Yemek {

    @Override
    public void hazirla() {
        System.out.println("Yemek : Icecek");
    }
}
