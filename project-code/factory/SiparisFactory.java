package model.siparis;

public class SiparisFactory extends BaseSiparisFactory {

    @Override
    public Siparis siparisOlustur(String siparisTipi) {
        Siparis siparis;

        switch (siparisTipi.toLowerCase()) {
            case "yiyecek":
                siparis = new Yiyecek();
                break;
            case "icecek":
                siparis = new Icecek();
                break;
            default:
                throw new IllegalArgumentException("Girilen Siparis Tipine uygun yoktur!");
        }
        siparis.siparisHazirlaniyor();
        siparis.siparisIcerigiEkle();
        return siparis;
    }
}