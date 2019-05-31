
abstract class AbstractAdim {
    protected static int YEMEK_HAZIRLA = 1;
    protected static int ICECEK_HAZIRLA = 2;
    protected static int SERVIS_YAP = 3;

    protected int adim;

    //chain or responsibility patternindeki bir sonraki adım'ı belirlemek için 
    private AbstractAdim sonrakiAdim;

    void setSonrakiAdim(AbstractAdim sonrakiAdim) {
        this.sonrakiAdim = sonrakiAdim;
    }

    void islemiYap(int adim) {
        if (this.adim <= adim) {
            bilgiVer();
        }
        if (sonrakiAdim != null) {
            sonrakiAdim.islemiYap(adim);
        }
    }

    abstract void bilgiVer();
}
