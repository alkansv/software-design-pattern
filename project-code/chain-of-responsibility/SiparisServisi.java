
public class SiparisServisi extends AbstractAdim {

    public SiparisServisi(int adim) {
        this.adim = adim;
    }

    @Override
    protected void bilgiVer() {
        System.out.println("Sipariş hazırlandı..\nServis ediliyor");
    }
}
