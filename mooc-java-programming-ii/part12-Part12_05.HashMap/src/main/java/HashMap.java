import java.util.ArrayList;

public class HashMap<K, V> {
    private ArrayList<Pair<K, V>>[] values;
    private int size;

    public HashMap() {
        this.values = new ArrayList[32];
        this.size = 0;
    }

    public void put(K key, V value) {
        int hashValue = Math.abs(key.hashCode() % this.values.length);
        if (this.values[hashValue] == null) {
            this.values[hashValue] = new ArrayList<>();
        }

        ArrayList<Pair<K, V>> bucket = this.values[hashValue];
        int index = getIndexOfKey(bucket, key);

        if (index < 0) {
            bucket.add(new Pair<>(key, value));
            this.size++;
        } else {
            bucket.get(index).setValue(value);
        }

        if ((1.0 * this.size) / this.values.length > 0.75) {
            grow();
        }
    }

    public V get(K key) {
        int hashValue = Math.abs(key.hashCode() % this.values.length);
        if (this.values[hashValue] == null) {
            return null;
        }

        ArrayList<Pair<K, V>> bucket = this.values[hashValue];
        int index = getIndexOfKey(bucket, key);

        if (index < 0) {
            return null;
        }

        return bucket.get(index).getValue();
    }

    public V remove(K key) {
        int hashValue = Math.abs(key.hashCode() % this.values.length);
        if (this.values[hashValue] == null) {
            return null;
        }

        ArrayList<Pair<K, V>> bucket = this.values[hashValue];
        int index = getIndexOfKey(bucket, key);

        if (index < 0) {
            return null;
        }

        Pair<K, V> removedPair = bucket.remove(index);
        this.size--;

        return removedPair.getValue();
    }

    private int getIndexOfKey(ArrayList<Pair<K, V>> bucket, K key) {
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).getKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }

    private void grow() {
        ArrayList<Pair<K, V>>[] newValues = new ArrayList[this.values.length * 2];
        for (int i = 0; i < this.values.length; i++) {
            if (this.values[i] != null) {
                for (Pair<K, V> pair : this.values[i]) {
                    int hashValue = Math.abs(pair.getKey().hashCode() % newValues.length);
                    if (newValues[hashValue] == null) {
                        newValues[hashValue] = new ArrayList<>();
                    }
                    newValues[hashValue].add(pair);
                }
            }
        }
        this.values = newValues;
    }
}
