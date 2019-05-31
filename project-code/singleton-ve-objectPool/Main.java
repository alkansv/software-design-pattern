public class Main {

    public static void main(String[] args) {
        KullaniciHavuzu kullaniciHavuzu = KullaniciHavuzu.getKullaniciHavuzu();

        Kullanici kullanici1 = kullaniciHavuzu.kullaniciGetir("a");
        System.out.println(kullanici1);

        Kullanici kullanici2 = kullaniciHavuzu.kullaniciGetir("b");
        System.out.println(kullanici2);

        Kullanici kullanici3 = kullaniciHavuzu.kullaniciGetir("c");
        System.out.println(kullanici3);

        Kullanici kullanici4 = kullaniciHavuzu.kullaniciGetir("d");

        kullaniciHavuzu.objeyiBirak(kullanici1);

        kullaniciHavuzu.kullaniciGetir("d");
        kullaniciHavuzu.objeyiBirak(kullanici1);

        kullaniciHavuzu.kullaniciGetir("b");
        kullaniciHavuzu.kullaniciGetir("c");

        kullaniciHavuzu.objeyiBirak(kullanici2);
        kullaniciHavuzu.kullaniciGetir("c");
    }
}    
