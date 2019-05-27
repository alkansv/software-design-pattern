package decorator;

public class SicakYemekDecorator extends YemekDecorator {

    public SicakYemekDecorator(Yemek decoratedYemek) {
        super(decoratedYemek);
    }

    @Override
    public void hazirla() {
        decoratedYemek.hazirla();
        yemegiSicakYap(decoratedYemek);
    }

    private void yemegiSicakYap(Yemek decoratedYemek) {
        System.out.println("Yiyecek durumu : sıcak");
    }
}