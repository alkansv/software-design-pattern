import java.util.Iterator;

public class Demo {

    public static void main(String[] args) {

        Siparis siparis1 = new Siparis("Makarna", 7.50f);
        Siparis siparis2 = new Siparis("Hamburger", 6.00f);
        Siparis siparis3 = new Siparis("Tavuk Sandiviç", 6.50f);

        Menu menu = new Menu();
        menu.siparisEkle(siparis1);
        menu.siparisEkle(siparis2);
        menu.siparisEkle(siparis3);

        System.out.println("Menu İçeriği :");
        Iterator<Siparis> iterator = menu.iterator();
        while (iterator.hasNext()) {
            Siparis siparis = iterator.next();
            System.out.println(siparis);
        }

        System.out.println("\nIteratorden donen son eleman kaldırıldı.");
        iterator.remove();

        System.out.println("\nMenu İçeriği :");
        iterator = menu.iterator();
        while (iterator.hasNext()) {
            Siparis siparis = iterator.next();
            System.out.println(siparis);
        }

    }

}
