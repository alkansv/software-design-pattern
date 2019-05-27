package decorator;

public class DecoratorPatternDemo {
    public static void main(String[] args) {

        Yemek yiyecek = new Yiyecek();
        Yemek sicakYiyecek = new SicakYemekDecorator(new Yiyecek());
        Yemek sicakIcecek = new SicakYemekDecorator(new Icecek());

        System.out.println("Normal yiyecek hazırlama");
        yiyecek.hazirla();

        System.out.println("\nSıcak yiyecek hazırlanıyor");
        sicakYiyecek.hazirla();

        System.out.println("\nSıcak icecek hazırlanıyor");
        sicakIcecek.hazirla();
    }
}