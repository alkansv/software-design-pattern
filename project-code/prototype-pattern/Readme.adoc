# Prototype Pattern

![](https://github.com/alkansv/software-design-pattern/blob/master/project-code/prototype-pattern/prototype.png?raw=true)


```java
//abstract class kullanıyoruz çünkü
//bu bir base class olacak ve buradan nesne üretmeyeceğiz
public abstract class Yemek implements Cloneable {
    protected String tip;
    private String id;

    //hazirla adında bu sınıfı base alanlar kullanması gereken boş metod
    abstract void hazirla();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    //ve buda bizim kopyalama işlemini yapıp
    //yeni nesneleri tanımladığımız alan
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clone;
    }
}

```


```java
public class Yiyecek extends Yemek {

    public Yiyecek() {
        setTip("Yiyecek");

    }

    @Override
    void hazirla() {
        System.out.println(" Yiyecek hazirla method");
    }
}
```


```java

public class Icecek extends Yemek {

    public Icecek() {
        setTip("Icecek");

    }

    @Override
    void hazirla() {
        System.out.println(" Icecek hazirla method");
    }
}   

```

```java
public abstract class YemekDecorator implements Yemek {
    public Yemek decoratedYemek;

    public YemekDecorator(Yemek decoratedYemek) {
        this.decoratedYemek = decoratedYemek;
    }

    @Override
    public void hazirla() {
        decoratedYemek.hazirla();
    }
}

```


```java
public class YemekCache {
    //ilk değerimiz key ikinci değeerimiz value
    //bir koleksyion class şeklinde bir eleman olduğundan hashlemeyi tercih etik
    private static Hashtable<String, Yemek> yemekMap = new Hashtable<>();

    //getyemek metodumuz gelen id'yi alıp hashmap içinden cagiriyor
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
```



```java
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

```

# Çıktı: 
 
```java
Yiyecek tipi : Yiyecek
Yiyecek Tipi : Icecek
```


<hr>

# UML kodu

```java
@startuml
class Demo {
  void main()
}


class Yemek {
  -  String id 
  -  String tip

   + {abstract} void hazirla()
   + Object clone()
}

class Yiyecek {
   + Yiyecek()
   + void hazirla()
}

class Iceecek {
   + Iceecek()
   + void hazirla()
}

class YemekCache {
  - {static} Hashtable<String, Yemek> yemekMap
    
  + {static} Yemek getYemek(String yemekId)
  + {static}  void loadCache() {
}


interface Clonable

Clonable <|-- Yemek : implemente eder
Yemek <|-- Yiyecek : implenete eder
Yemek <|-- Iceecek : implenete eder
Yemek <|-- YemekCache : klonlar
Demo --> YemekCache : Sorar
@enduml

```
