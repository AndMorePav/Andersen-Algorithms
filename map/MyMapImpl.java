package andersen.map;

import java.util.Arrays;

public class MyMapImpl<K,V>  implements MyMap<K,V> {
    private static final int MAX_SIZE = Integer.MAX_VALUE / 2;
    private Object[][] arr;
    private int size = 16;

    public MyMapImpl() {
        arr = new Object[size][2];
    }

    public MyMapImpl(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " +
                    initialCapacity);

        if (initialCapacity < MAX_SIZE) {
            size = initialCapacity;
            arr = new Object[size][2];
        } else new MyMapImpl();
    }

    @Override
    public void put(Object k, Object v) {
        int index = k.hashCode() & (size  - 1);
        Object[] bucket = {k, v};
        arr[index] = bucket;
    }

    @Override
    @SuppressWarnings("unchecked")
    public V get(Object k) {
        if (arr.length > 0) {
            int index = k.hashCode() & (size  - 1);
            Object[] bucket = arr[index];
            return (V)bucket[1];
        } else throw new IndexOutOfBoundsException();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(Object[] bucket : arr) {
            if (bucket[0] != null)
                builder.append(Arrays.toString(bucket));
        }

        return builder.toString();
    }
}
