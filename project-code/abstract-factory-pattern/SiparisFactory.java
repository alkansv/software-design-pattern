package model.abstractsiparis;

import model.abstractsiparis.model.Siparis;

public class SiparisFactory {

    public static Siparis siparisOlustur(SiparisAbstractFactory saf) {
        return saf.siparisOlustur();
    }
}