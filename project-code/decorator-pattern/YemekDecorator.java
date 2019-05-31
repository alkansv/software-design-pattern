package decorator;

public abstract class YemekDecorator implements Yemek {
    public Yemek decoratedYemek;

    public YemekDecorator(Yemek decoratedYemek) {
        this.decoratedYemek = decoratedYemek;
    }

    @Override
    public void hazirla() {
        decoratedYemek.hazirla();
    }
}


