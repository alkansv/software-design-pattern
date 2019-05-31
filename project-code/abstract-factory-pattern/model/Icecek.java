package model.abstractsiparis.model;

public class Icecek implements Siparis {
    @Override
    public void siparisHazirla() {
        System.out.println("Icecek Siparisi Hazırlama fonksiyonu calıstı!");
    }

    @Override
    public void siparisHazirlaniyor() {
        System.out.println("Icecek Siparisi Hazırlanıyor..");
    }
}
