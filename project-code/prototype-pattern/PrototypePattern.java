package prototype;

public class PrototypePattern {

    public static void main(String[] args) {

        //değerleri kayıt ediyoruz
        YemekCache.loadCache();

        //burada diğer ekledikleriniz
        //ve sizin kendi eklenitlerinizi istediğiniz şekilde çağırabilirsiniz
        Yemek yiyecek = YemekCache.getYemek("1");
        System.out.println("Yiyecek tipi : " + yiyecek.getTip());

        Yemek icecek = YemekCache.getYemek("2");
        System.out.println("Yiyecek Tipi : " + icecek.getTip());

    }

}