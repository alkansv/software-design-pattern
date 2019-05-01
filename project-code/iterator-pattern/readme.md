

```java
public class Siparis {

	String isim;
	float fiyat;

	public Siparis(String isim, float fiyat) {
		this.isim = isim;
		this.fiyat = fiyat;
	}

	public String toString() {
		return isim + ": " + fiyat + "₺";
	}
}

```


```java
public class Menu {

    List<Siparis> siparisListesi;

    public Menu() {
        siparisListesi = new ArrayList<Siparis>();
    }

    public void siparisEkle(Siparis siparis) {
        siparisListesi.add(siparis);
    }

    public Iterator<Siparis> iterator() {
        return new MenuIterator();
    }

    class MenuIterator implements Iterator<Siparis> {
        int gecerliIndex = 0;

        @Override
        public boolean hasNext() {
            if (gecerliIndex >= siparisListesi.size()) {
                return false;
            } else {
                return true;
            }
        }

        @Override
        public Siparis next() {
            return siparisListesi.get(gecerliIndex++);
        }

        @Override
        public void remove() {
            siparisListesi.remove(--gecerliIndex);
        }

    }
}

```


```java
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

```

# Çıktı: 
 
```java

Menu İçeriği :
Makarna: 7.5₺
Hamburger: 6.0₺
Tavuk Sandiviç: 6.5₺

Iteratorden donen son eleman kaldırıldı.

Menu İçeriği :
Makarna: 7.5₺
Hamburger: 6.0₺
```




<hr>
# UML kodu
```uml
@startuml
class Demo {
  void main()
}


class Menu {
   + List<Siparis> siparisListesi
   + Menu()
   + void siparisEkle(Siparis)
   +Iterator<Siparis> iterator()
}

class MenuIterator {
  - int gecerliIndex
  + boolean hasNext()
  + Siparis next()
  + void remove()
}


interface Iterator

Demo --> Menu : kullanır
Menu --> MenuIterator : sahiptir
Iterator <|-- MenuIterator : implenete eder
@enduml

```
