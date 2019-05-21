# Iterator Pattern

![](https://github.com/alkansv/software-design-pattern/blob/master/project-code/chain-of-responsibility/cor.png?raw=true)


```java
abstract class AbstractAdim {
    protected static int YEMEK_HAZIRLA = 1;
    protected static int ICECEK_HAZIRLA = 2;
    protected static int SERVIS_YAP = 3;

    protected int adim;

    //chain or responsibility patternindeki bir sonraki adım'ı belirlemek için
    private AbstractAdim sonrakiAdim;

    void setSonrakiAdim(AbstractAdim sonrakiAdim) {
        this.sonrakiAdim = sonrakiAdim;
    }

    void islemiYap(int adim) {
        if (this.adim <= adim) {
            bilgiVer();
        }
        if (sonrakiAdim != null) {
            sonrakiAdim.islemiYap(adim);
        }
    }

    abstract void bilgiVer();
}

```


```java
public class YemekHazirla extends AbstractAdim {

    public YemekHazirla(int adim) {
        this.adim = adim;
    }

    @Override
    protected void bilgiVer() {
        System.out.println("Yemek Hazırlanıyor..\nYemek Hazırlandı\n-----");
    }
}

```


```java
public class IcecekHazirla extends AbstractAdim {

    public IcecekHazirla(int level) {
        this.adim = level;
    }

    @Override
    protected void bilgiVer() {
        System.out.println("Icecek hazırlanıyor.\nIcecek hazırlandı\n-----");
    }
}

```

```java
public class SiparisServisi extends AbstractAdim {

    public SiparisServisi(int adim) {
        this.adim = adim;
    }

    @Override
    protected void bilgiVer() {
        System.out.println("Sipariş hazırlandı..\nServis ediliyor");
    }
}

```


```java
public class ChainPatternOrnek {

    public static void main(String[] args) {
        AbstractAdim yemekHazirla = new YemekHazirla(AbstractAdim.YEMEK_HAZIRLA);
        AbstractAdim icecekHazirla = new IcecekHazirla(AbstractAdim.ICECEK_HAZIRLA);
        AbstractAdim servisYap = new SiparisServisi(AbstractAdim.SERVIS_YAP);

        yemekHazirla.setSonrakiAdim(icecekHazirla);
        icecekHazirla.setSonrakiAdim(servisYap);

        yemekHazirla.islemiYap(AbstractAdim.SERVIS_YAP);
    }
}

```

# Çıktı: 
 
```java

Yemek Hazırlanıyor..
Yemek Hazırlandı
-----
Icecek hazırlanıyor.
Icecek hazırlandı
-----
Sipariş hazırlandı..
Servis ediliyor
```




<hr>

# UML kodu

```java
@startuml
class Demo {
  void main()
}


class AbstractAdim {
  - {static} int YEMEK_HAZIRLA = 1
  - {static} int ICECEK_HAZIRLA = 2
  - {static} int SERVIS_YAP = 3
  - int adim
  - AbstractAdim sonrakiAdim

   + void islemiYap(int adim)
   + {abstract} void bilgiVer()
}

class YemekHazirla {
   + void bilgiVer()
}

class IcecekHazirla {
   + void bilgiVer()
}

class ServisYap {
   + void bilgiVer()
}



AbstractAdim <|-- YemekHazirla : implenete eder
AbstractAdim <|-- IcecekHazirla : implenete eder
AbstractAdim <|-- ServisYap : implenete eder
Demo --> AbstractAdim : Sorar
@enduml

```
