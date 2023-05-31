package Seminar4;

public class MyHashMap<K, V> {
    private final int SIZE = 5;
    private final Node<K, V>[] bundles;

    public MyHashMap() {
        bundles = new Node[SIZE];
    }

    public void replace(K key, V value) {
        int hash = key.hashCode() % SIZE;
        Node<K, V> kvNode = bundles[hash];
        if (kvNode == null) {
            System.out.println("Ключ не найден");
            return;
        }
        while (kvNode != null) {
            if (kvNode.getKey() == key) {
                kvNode.setValue(value);
                return;
            }
            kvNode = kvNode.getNext();
        }
        System.out.println("Ключ не найден");
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public int size() {
        int size = 0;
        if (bundles.length == 0) {
            return 0;
        } else {
            for (Node<K, V> kvNode : bundles) {
                size++;
                while (kvNode.getNext() != null) {
                    size++;
                    kvNode = kvNode.getNext();
                }
            }
        }
        return size;
    }

    public boolean containsValue(V value) {
        for (Node<K, V> kvNode : bundles) {
            while (kvNode.getNext() != null) {
                if (kvNode.getValue() == value) {
                    return true;
                }
                kvNode = kvNode.getNext();
            }
        }
        return false;
    }

    public void put(K key, V value) {
        // добавить проверку на null
        int hash = key.hashCode() % SIZE;
        Node<K, V> node = bundles[hash];
        if (node == null) {
            bundles[hash] = new Node<K, V>(key, value);
        } else {
            while (node.getNext() != null) {
                if (node.getKey() == key) {
                    node.setValue(value);
                    return;
                }
                node = node.getNext();
            }
            if (node.getKey() == key) {
                node.setValue(value);
                return;
            }
            node.setNext(new Node<K, V>(key, value));
        }
    }

    public V get(K key) {
        int hash = key.hashCode() % SIZE;
        Node<K, V> e = bundles[hash];
        if (e == null) {
            return null;
        }
        while (e != null) {
            if (e.getKey() == key) {
                return e.getValue();
            }
            e = e.getNext();
        }
        return null;
    }

    public Node<K, V> remove(K key) {
        int hash = key.hashCode() % SIZE;
        Node<K, V> node = bundles[hash];
        if (node == null) {
            return null;
        }
        if (node.getKey() == key) {
            bundles[hash] = node.getNext();
            node.setNext(null);
            return node;
        }
        Node<K, V> previous = node;
        while (node != null) {
            if (node.getKey() == key) {
                previous.setNext(node.getNext());
                node.setNext(null);
                return node;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            if (bundles[i] != null) {
                sb.append(i + " -> " + bundles[i] + "\n");
            } else {
                sb.append(i + " -> " + "null" + "\n");
            }
        }
        return sb.toString();
    }
}