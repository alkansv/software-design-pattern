public class Main {

    public static void main(String[] args) {
        System.out.println("----------------FACTORY PATTERN TEST---------------------------------");
        BaseSiparisFactory siparisFactory = new SiparisFactory();
        Siparis pizza = siparisFactory.siparisOlustur("yiyecek");
        System.out.println("-------------------------------------------------");
        Siparis kola = siparisFactory.siparisOlustur("icecek");
    }
}    
