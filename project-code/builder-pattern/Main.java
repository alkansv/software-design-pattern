public class Main {

    public static void main(String[] args) {

        Masa masa = new Masa
                .MasaBuilder(1)
                .hesap(27)
                .build();

        System.out.println(masa);
    }
}    
