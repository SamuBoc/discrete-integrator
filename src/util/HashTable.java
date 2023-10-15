package util;

public class HashTable<K,V> {

    private LinkedListRecursive<V>[] hashTable;

    public HashTable() {

        hashTable = new LinkedListRecursive[10];
        for (int i = 0; i < hashTable.length; i++) {

            hashTable[i] = new LinkedListRecursive<>();

        }
    }

    public boolean removeElement(K key, V value) {
        int placement = 0;
        if (key instanceof String) {
            placement = stringSlotFinder((String) key);
        } else if (key instanceof Integer) {
            placement = kModM((int) key, hashTable.length);
        } else if (key instanceof Double) {
            placement = kM((Double) key, hashTable.length);
        }

        LinkedListRecursive<V> list = hashTable[placement];
        if (list.delete(value)) {
            return true;
        }

        return false;
    }


    public boolean addElement(K key, V value) {

        int placement = 0;
        if (key instanceof String) {

            placement = stringSlotFinder((String) key);
            hashTable[placement].addLast(value);
            return true;

        } else if (key instanceof Integer) {

            if ((Integer) key > 0) {

                placement = kModM((int) key, hashTable.length);
                hashTable[placement].addLast(value);
                return true;

            }

        } else if (key instanceof Double) {

            if ((Double) key > 0 && (Double) key < 1) {

                placement = kM((Double) key, hashTable.length);
                hashTable[placement].addLast(value);
                return true;
            }

        }

        return false;

    }

    public int stringSlotFinder(String name) {
        return Math.abs(name.hashCode() % hashTable.length);
    }

    public int kM(double key, int m) {

        return (int) Math.floor(key * m);

    }

    public int kModM(int k, int m) {

        return k % m;

    }

    public String showTable() {
        String print = "";
        for (int i = 0; i < hashTable.length; i++) {
            print += "Subdivision " + (i + 1) + "\n";
            print += "\n" + hashTable[i].print() + "\n\n";

        }

        return print;
    }

    public V search(int keyMajor, int keyMinor) {

        return hashTable[keyMajor - 1].searchWithId(keyMinor);

    }

    public boolean editElement(K key, V oldValue, V newValue) {
        int placement = 0;
        if (key instanceof String) {
            placement = stringSlotFinder((String) key);
        } else if (key instanceof Integer) {
            placement = kModM((int) key, hashTable.length);
        } else if (key instanceof Double) {
            placement = kM((Double) key, hashTable.length);
        }

        LinkedListRecursive<V> list = hashTable[placement];
        if (list.edit(oldValue, newValue)) {
            return true;
        }

        return false;
    }





}
