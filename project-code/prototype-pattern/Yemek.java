//abstract class kullanıyoruz çünkü
//bu bir base class olacak ve buradan nesne üretmeyeceğiz
public abstract class Yemek implements Cloneable {
    protected String tip;
    private String id;

    //hazirla adında bu sınıfı base alanlar kullanması gereken boş metod
    abstract void hazirla();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    //ve buda bizim kopyalama işlemini yapıp
    //yeni nesneleri tanımladığımız alan
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clone;
    }
}
