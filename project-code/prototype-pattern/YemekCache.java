package prototype;

import java.util.Hashtable;

public class YemekCache {
    //ilk değerimiz key ikinci değeerimiz value
    //bir koleksyion class şeklinde bir eleman olduğundan hashlemeyi tercih etik
    private static Hashtable<String, Yemek> yemekMap = new Hashtable<String, Yemek>();


    //getyemek metodumuz gelen id'yi alıp hashmap sınıfından cagiriyor
    public static Yemek getYemek(String yemekId) {
        Yemek cachedYemek = yemekMap.get(yemekId);
        //ve buradan gelen değeri clone özelliğiyle objeyi geri döndürüyoruz
        return (Yemek) cachedYemek.clone();
    }

    public static void loadCache() {
        //biz manuel olarak elle değer yüklüyoruz
        //burası veritabanından da doldurabilir
        Yiyecek yiyecek = new Yiyecek();
        yiyecek.setId("1");
        yemekMap.put(yiyecek.getId(), yiyecek);

        Icecek icecek = new Icecek();
        icecek.setId("2");
        yemekMap.put(icecek.getId(), icecek);
    }

}