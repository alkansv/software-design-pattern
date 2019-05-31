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
