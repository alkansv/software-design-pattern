package model.abstractsiparis;

import model.abstractsiparis.model.Icecek;
import model.abstractsiparis.model.Siparis;
import model.abstractsiparis.model.Yiyecek;

public class IcecekFactory implements SiparisAbstractFactory {

    @Override
    public Siparis siparisOlustur() {
        return new Icecek();
    }
}