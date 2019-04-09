import java.util.Objects;
import java.util.StringJoiner;

public class Kullanici {
    private long id;
    private String isim;
    private static int kullaniciId = 0;

    Kullanici() {
        this.id = ++kullaniciId;
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

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add("id = " + id)
                .add("isim = " + isim)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Kullanici that = (Kullanici) o;

        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.isim, that.isim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isim);
    }
}
