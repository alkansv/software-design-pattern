package model.abstractsiparis;

import model.abstractsiparis.model.Siparis;
import model.abstractsiparis.model.Yiyecek;

public class YiyecekFactory implements SiparisAbstractFactory {

    @Override
    public Siparis siparisOlustur() {
        return new Yiyecek();
    }
}