import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

// Singleton ve Object Pool Pattern uygulandı
public class KullaniciHavuzu {
    private static final int SIZE = 3;
    private static List<Kullanici> kullanicilar = new ArrayList<>();
    private static Set<String> bekleyenClientlar = new LinkedHashSet<>();

    private KullaniciHavuzu() {
    }

    public static Kullanici kullaniciGetir(String clientName) {

        if (kullanicilar.size() < SIZE) {
            Kullanici kullanici = new Kullanici();
            kullanicilar.add(kullanici);
            // eğer client bekleyenler listesinde varsa bekleyenler listesinden sil!
            bekleyenClientlar.remove(clientName);
            return kullanici;
        }

        bekleyenClientlar.add(clientName);
        bekleyenler();
        return null;
    }

    private static void bekleyenler() {
        System.out.println("Kullanici nesnesini bekleyenler:");
        bekleyenClientlar.forEach(System.out::println);
    }

    public static void objeyiBirak(Kullanici kullanici) {
        kullanicilar.remove(kullanici);
    }

}
