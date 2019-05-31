public class IcecekHazirla extends AbstractAdim {

    public IcecekHazirla(int level) {
        this.adim = level;
    }

    @Override
    protected void bilgiVer() {
        System.out.println("Icecek hazırlanıyor.\nIcecek hazırlandı\n-----");
    }
}
