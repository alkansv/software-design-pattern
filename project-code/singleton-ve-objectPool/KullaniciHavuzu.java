package model.kullanici;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

// Singleton ve Object Pool Pattern birlikte uygulandı
// Singleton pattern şu sekilde uygulandı :  KullanıcıHavuzu isimli bu sınıftan new KullaniciHavuzu(); seklinde yeni bir object olusturulamayacaktır.
// oluşturulamamasının sebebi constructor fonksiyonun private yapılarak dışarıya gizlenmesidir.
// sınıfın içinde bu sınıfın kendisinden bir instance'ı olusturulup getKullaniciHavuzu() isimli fonksiyon ile geriye dondurulmustur.
// bu sınıf haricinde bu sınıftan asla ama asla new kelimesi ile yeni bir instance  oluşturulamayacaktır ,sadece bu dondurulen instance üzerinden işlem yapılabilir.
// bu sekilde singleton pattern uygulanmıs oldu.
public class KullaniciHavuzu {

    // object pool'un size'ı
    private static final int SIZE = 3;
    // Kullanici sınıfından olusturulan ve  nesneler kullanımdayken nesnenin tutulacağı , "Kullanici" objesi tipinde boş bir liste tanımlıyoruz.
    private static List<Kullanici> kullanilanKullanicilar = new ArrayList<>();
    // bosta olan kullanıcı nesnelerinin tutulacagı listeyi tanımlıyoruz
    private static List<Kullanici> bostaOlanKullanicilar = new ArrayList<>();
    // Kullanici nesnesini talep edildiğinde  boşta Kullanici nesnesi olmadığı durumda talep eden  clientı duplicate olmayacak sekilde tutabilmek için boş bir set tanımlıyoruz.
    // boşta nesne yoksa client'ın ismini bu set'in içine ekliyoruz.
    private static Set<String> bekleyenClientlar = new LinkedHashSet<>();

    // singleton pattern uygulamak için bu sınıfın kendisinden bir instance oluşturuyoruz.
    // ve sadece ve sadece getKullaniciHavuzu isimli method ile bu instance'a erişim saglıyoruz
    private static KullaniciHavuzu kullaniciHavuzu = new KullaniciHavuzu();

    // Constructor methodumuz dısarıdan erişilerek new KullaniciHavuzu(); seklinde cagıralamaması için private olarak tanımlandı.
    // Varsayılan olarak belirlenen boyut kadar yeni kullanıcı olusturularak bosta olan kullanıcılar listesine ekleniyor.
    private KullaniciHavuzu() {
        IntStream.rangeClosed(1, SIZE).forEach(i -> bostaOlanKullanicilar.add(new Kullanici()));
    }

    //Bekleyenler listesini görmek için  deneme amaçlı eklendi
    private static void bekleyenler() {
        System.out.println("Kullanici nesnesini bekleyenler:");
        bekleyenClientlar.forEach(System.out::println);
        System.out.println();
    }

    // Objeyi kullanıp işini bitiren client , kullandıgı objeyi bu methoda gonderir ,
    // gelen "Kullanici" objesi kullanilanKullanicilar listesinden silinir
    // bostaOlanKullanicilar listesine eklenir
    public static void objeyiBirak(Kullanici kullanici) {
        kullanilanKullanicilar.remove(kullanici);
        bostaOlanKullanicilar.add(kullanici);
        System.out.println(kullanici + " nesnesi havuza geri bırakıldı!");
    }

    // sınıf içerisinde tanımlanmıs olan instance'a erişim saglanan method.
    public static KullaniciHavuzu getKullaniciHavuzu() {
        return kullaniciHavuzu;
    }

    public Kullanici kullaniciGetir(String clientName) {

        if (!bostaOlanKullanicilar.isEmpty()) {
            Kullanici kullanici = bostaOlanKullanicilar.get(0);
            kullanilanKullanicilar.add(kullanici);
            bostaOlanKullanicilar.remove(kullanici);
            // eğer "Kullanici" nesnesini talep eden "client" daha önce "bekleyenClientlar" içerisinde varsa bekleyenler listesinden sil!
            bekleyenClientlar.remove(clientName);
            System.out.println("\n" + clientName + " havuzdan obje aldı!");
            return kullanici;
        }

        System.out.println("\n" + clientName + " havuzdan obje talep etti fakat havuzda obje yok.!");
        // eğer belirlenen adet olan 3'ten fazla kullanici nesnesi suan kullanimda ise client'ın adını bekleyenler listesine ekle ve null dön.
        bekleyenClientlar.add(clientName);
        bekleyenler();
        return null;
    }
}

