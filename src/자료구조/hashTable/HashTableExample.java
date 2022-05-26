package 자료구조.hashTable;

public class HashTableExample {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.put("one", 1);
        hashTable.put("two", 2);
        hashTable.put("three", 3);

        System.out.println("hashTable = " + hashTable.get("two"));

        hashTable.remove("two");

        System.out.println("hashTable.toString() = " + hashTable.toString());

        String key = "two";
        System.out.println("key = " + key.hashCode());
        System.out.println("hashTable.getHash(key) = " + hashTable.getHash(key));
    }

    public static class Item {
        public String key;
        public Object value;

        public Item(String key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    public static class HashTable {
        private static int HASH_TABLE_CAPACITY = 1000;
        private Item[] data = new Item[HASH_TABLE_CAPACITY];
        private int size = 0;

        private int getHash(String key) {
            int hash = 0;
            for (int i = 0; i < key.length(); i++) {
                char val = key.charAt(i);
                hash = (hash + val*(i + 1)) % HASH_TABLE_CAPACITY;
            }
            return hash;
        }

        public Object get(String key) {
            if (key != null) {
                int hash = getHash(key);
                while (data[hash] != null && !data[hash].key.equals(key)) {
                    hash = (hash + 1) % HASH_TABLE_CAPACITY;
                }
                return data[hash] != null ? data[hash].value : null;
            }
            return null;
        }

        public void put(String key, Object value) {
            if (key != null) {
                int hash = getHash(key);
                while (data[hash] != null && !data[hash].key.equals(key)) {
                    hash = (hash + 1) % HASH_TABLE_CAPACITY;
                }
                data[hash] = new Item(key, value);
                size++;
            }
        }

        public Object remove(String key) {
            Object removed = null;
            if (key != null) {
                int hash = getHash(key);
                while (data[hash] != null && !data[hash].key.equals(key)) {
                    hash = (hash + 1) % HASH_TABLE_CAPACITY;
                }
                if (data[hash] != null) {
                    removed = data[hash];
                    data[hash] = null;
                    size--;
                }
            }
            return removed;
        }

        public int size() {
            return size;
        }

        public String toString() {
            String out = "<HashTable>\n";
            for (int i = 0; i < data.length; i++) {
                Item item = data[i];
                if (item != null) {
                    out += "  Key(hash, index): " + data[i].key
                            + "(" + getHash(data[i].key) + ", " + i + ")"
                            + ", Value: " + data[i].value + "\n";
                }
            }
            return out;
        }
    }
}
