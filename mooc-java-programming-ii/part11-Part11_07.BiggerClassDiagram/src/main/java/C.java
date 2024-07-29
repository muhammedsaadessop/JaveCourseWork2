import java.util.List;

public class C extends B implements IC  {
    private List<E> es;

    public void setEs(List<E> es) {
        this.es = es;
    }

    public List<E> getEs() {
        return es;
    }
}
