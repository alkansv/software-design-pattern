#  Singleton ve Object Pool Örneği
### İki pattern birlikte uygulanmıstır.
 Singleton pattern için KullaniciHavuzu sınıfını constructor'ı private yapılarak dışarıdan erişilemez hale getirilerek 

```java
 private static KullaniciHavuzu kullaniciHavuzu = new KullaniciHavuzu();
```
sadece kendi içersinde yukarıdaki sekilde yeni bir instance'ı olusturulabilir hale getirilmiştir.
Diğer detaylı acıklamalar kodun içerisinde mevcuttur.
<hr>


```java
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

```


```java
public class Kullanici {
    private long id;
    private String isim;
    private static int kullaniciId = 0; // her bir kullanıcı olustugunda eşsiz bir id değerine sahip olabilmesi için statik olarak bu değeri tutuyoruz

    Kullanici() {
        this.id = ++kullaniciId;  // her bir yeni kullanıcı nesnesi olusturuldugunda kullaniciId değerini bir arttırıp set ediyoruz.
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }
}

```


```java
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
```

yukarıdaki sekilde main fonksiyonu calıstıgında cıktı asagıdaki gibidir.

```

a havuzdan obje aldı!
Kullanici[id = 1, isim = null]

b havuzdan obje aldı!
Kullanici[id = 2, isim = null]

c havuzdan obje aldı!
Kullanici[id = 3, isim = null]

d havuzdan obje talep etti fakat havuzda obje yok.!
Kullanici nesnesini bekleyenler:
d

Kullanici[id = 1, isim = null] nesnesi havuza geri bırakıldı!

d havuzdan obje aldı!
Kullanici[id = 1, isim = null] nesnesi havuza geri bırakıldı!

b havuzdan obje aldı!

c havuzdan obje talep etti fakat havuzda obje yok.!
Kullanici nesnesini bekleyenler:
c

Kullanici[id = 2, isim = null] nesnesi havuza geri bırakıldı!

c havuzdan obje aldı!
```
