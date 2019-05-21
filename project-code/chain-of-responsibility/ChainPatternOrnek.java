public class ChainPatternOrnek {

    public static void main(String[] args) {
        AbstractAdim yemekHazirla = new YemekHazirla(AbstractAdim.YEMEK_HAZIRLA);
        AbstractAdim icecekHazirla = new IcecekHazirla(AbstractAdim.ICECEK_HAZIRLA);
        AbstractAdim servisYap = new SiparisServisi(AbstractAdim.SERVIS_YAP);

        yemekHazirla.setSonrakiAdim(icecekHazirla);
        icecekHazirla.setSonrakiAdim(servisYap);

        yemekHazirla.islemiYap(AbstractAdim.SERVIS_YAP);
    }
}
