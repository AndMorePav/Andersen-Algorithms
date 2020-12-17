package andersen.map;

public interface MyMap<K, V> {
    void put(K k, V v);
    V get(K k);
}
