public class List {
    private int[] elements;
    private int size;

    public List() {
        this.elements = new int[10];
        this.size = 0;
    }

    public void add(int value) {
        if (this.size == this.elements.length) {
            grow();
        }
        this.elements[this.size] = value;
        this.size++;
    }

    private void grow() {
        int[] newElements = new int[this.elements.length * 2];
        for (int i = 0; i < this.elements.length; i++) {
            newElements[i] = this.elements[i];
        }
        this.elements = newElements;
    }

    public int get(int index) {
        if (index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " out of bounds");
        }
        return this.elements[index];
    }

    public int size() {
        return this.size;
    }
    
    public boolean contains(int value) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i] == value) {
                return true;
            }
        }
        return false;
    }

    public void remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " out of bounds");
        }
        for (int i = index; i < this.size - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.size--;
    }
}
