public class Hideout<T> {
    private T hiddenObject;

    public Hideout() {
        this.hiddenObject = null;
    }

    public void putIntoHideout(T toHide) {
        this.hiddenObject = toHide;
    }

    public T takeFromHideout() {
        T object = this.hiddenObject;
        this.hiddenObject = null;
        return object;
    }

    public boolean isInHideout() {
        return this.hiddenObject != null;
    }

  
}
