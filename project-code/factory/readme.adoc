# Factory Pattern

Davranış olarak birbirine benzer olan fakat aynı sekilde olmayan sınıflar için sadece fonksiyonun adını tanımladığımız , fonksiyon gövdesinin o abstract sınıfı extend eden alt sınıfta kendine göre dolduruldugu yapı ile factory pattern oluşturulmustur. Yani aslında abstract class ve onu extend classlar seklinde olusturuldu.
<hr>

## Siparis Sınıfı
```java

public abstract class Siparis {
    public abstract void siparisiHazirla();

    public void siparisHazirlaniyor() {
        System.out.println("Sipariş hazırlanıyor..");
    }
}

```

Siparislerin Yiycek ve İcecek seklinde iki farkli tipi olacagını varsayarsak ikisininde sipariş oldugunu ama hazırlanıs bakımından farklı olduklarını biliyoruz bundan dolayı siparis sınıfınde siparisiHazirla isminde abstract bir method tanımlıyoruz ve siparis sınıfını extend eden sınıfların bu methodu Override ederek içini doldurmasını istiyoruz.

<hr>

## Siparis Sınıfından Türetilen Yiyecek Sınıfı

```java
public class Yiyecek extends Siparis {
    @Override
    public void siparisiHazirla() {
        System.out.println("Yiyecek aşcı tarafından pişirildi.");
        System.out.println("Yiyecek siparişi hazırlandı.");
    }
}

```

##  Siparis Sınıfından Türetilen İcecek Sınıfı
```java
public class Icecek extends Siparis {
    @Override
    public void siparisiHazirla() {
        System.out.println("İcecekler buzdolabından alındı.");
        System.out.println("İcecek siparişi hazırlandı.");
    }
}

```
Yukarıdaki Yiyecek ve İcecek sınıfı abstract olarak olusturulmus olan Siparis sinifindan Extend edilerek kendi siparis hazirlama sekillerini kendilerine göre oluşturmuslardır. 
<hr>



## BaseFactory sınıfı
```java
public abstract class BaseSiparisFactory {
    public abstract Siparis siparisOlustur(String siparisTipi);
}

```
Bu sınıf Siparis Factory sınıfının ne yapacagını belirtmek için oluşturulmuştur. Yanı siparisOlustur fonksiyonu ile siparis  olusturacagını belirtmiş ama nasıl yapacagını belirtmemiştir. SiparisFactory sınıfını bu sınıftan türettiğimizde siparisOlustur fonksiyonunun gövdesini doldurulacaktır.


<hr>

## SiparisFactory Sınıfı
```java
public class SiparisFactory extends BaseSiparisFactory {

    @Override
    public Siparis siparisOlustur(String siparisTipi) {
        Siparis siparis;

        switch (siparisTipi.toLowerCase()) {
            case "yiyecek":
                siparis = new Yiyecek();
                break;
            case "icecek":
                siparis = new Icecek();
                break;
            default:
                throw new IllegalArgumentException("Girilen Siparis Tipine uygun yoktur!");
        }
        siparis.siparisHazirlaniyor();
        siparis.siparisIcerigiEkle();
        return siparis;
    }
}

```

SiparisFactory sınıfı BaseSiparisFactory sınıfını extend ederek siparisOlustur fonksiyonunu override etmektedir.
siparis olustur fonksiyonu String tipinde siparisTipi diye bir parametre almaktadır. Bu aldıgı değişkene göre ya "Yiyecek" ya da "İcecek" sınıfından bir nesne olusturarak o nesneyi geriye donmektedir. 

siparisOlustur fonksiyonunun dönüş tipine dikkat edersek dönüş tipi "Siparis" sınıfı olarak gözükmektedir. Oysa biz duruma göre ya  "Yiyecek" ya da "İcecek" sınıfından bir nesne  dönüyoruz demiştik. Yiyecek ve İcecek sınıfı Siparis sınıfını kalıtım aldıgı için bu durum "Polymorphism" ile mümkün olmaktadır. 





## Main
```java
  public static void main(String[] args) {
        System.out.println("----------------FACTORY PATTERN TEST---------------------------------");
        BaseSiparisFactory siparisFactory = new SiparisFactory();
        Siparis pizza = siparisFactory.siparisOlustur("yiyecek");
        System.out.println("-------------------------------------------------");
        Siparis kola = siparisFactory.siparisOlustur("icecek");
    }

```
SiparisFactory uzerinden siparisOlustur fonksiyonuna "yiyecek" parametresi geçerek cagrı yaptıgımızda "yiyecek" sınıfından bir nesne olusturulup bize geriye dondugunu , aynı sekilde "icecek" parametresi ile cagrıldıgında "icecek" sınıfından bir nesne olusturuldugunu ve dondugunu goruyoruz.

<hr>

# Sonuç 
```java
----------------FACTORY PATTERN TEST---------------------------------
Sipariş hazırlanıyor..
Yiyecek aşcı tarafından pişirildi.
Yiyecek siparişi hazırlandı.
-------------------------------------------------
Sipariş hazırlanıyor..
İcecekler buzdolabından alındı.
İcecek siparişi hazırlandı.

```
