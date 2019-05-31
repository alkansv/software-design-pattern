package model.abstractsiparis.model;

public class Yiyecek implements Siparis {
    @Override
    public void siparisHazirla() {
        System.out.println("Yemek Siparisi Hazırlama fonksiyonu calıstı!");
    }

    @Override
    public void siparisHazirlaniyor() {
        System.out.println("Yemek Siparisi Hazırlanıyor..");
    }
}
