public class YemekHazirla extends AbstractAdim {

    public YemekHazirla(int adim) {
        this.adim = adim;
    }

    @Override
    protected void bilgiVer() {
        System.out.println("Yemek Hazırlanıyor..\nYemek Hazırlandı\n-----");
    }
}
