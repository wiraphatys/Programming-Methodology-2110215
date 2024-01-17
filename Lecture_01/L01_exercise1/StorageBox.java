import java.util.ArrayList;

public class StorageBox {
    private ArrayList<Object> storage;
    private int capacity;

    public StorageBox(int capacity) {
        this.capacity = capacity;
        this.storage = new ArrayList<>(capacity);
    }

    public StorageBox() {
        this.capacity = 1;
        this.storage = new ArrayList<>(this.capacity);
    }

    public boolean isEmpty() {
        return storage.isEmpty();
    }

    public boolean isFull() {
        return storage.size() == capacity;
    }


    public void push(Object x) {
        if (isFull()) {
            int newCapacity = capacity * 2;
            ArrayList<Object> newStorage = new ArrayList<>(newCapacity);
            newStorage.addAll(storage);

            capacity = newCapacity;
            storage = newStorage;
        }
        storage.add(x);
    }



    public Object pop() {
        if (!isEmpty()) {
            return storage.remove(storage.size() - 1);
        } else {
            return null;
        }
    }

    public Object top() {
        if (!isEmpty()) {
            return storage.get(storage.size() - 1);
        } else {
            return null;
        }
    }
}
