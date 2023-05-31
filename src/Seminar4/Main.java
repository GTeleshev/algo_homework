package Seminar4;

public class Main {
    public static void main(String[] args) {
        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<Integer, Integer>();
        for (int i = 0; i < 15; i++) {
            myHashMap.put(i, i * 10);
        }
        System.out.println(myHashMap);
        System.out.println("значение с ключом 1: " + myHashMap.get(1));
        System.out.println("содержит ключ 7: " + myHashMap.containsKey(7));
        System.out.println("содержит ключ 20: " + myHashMap.containsKey(20));
        System.out.println("содержит значение 50: " + myHashMap.containsValue(50));
        System.out.println("содержит значение 200: " + myHashMap.containsValue(200));
        System.out.println("размер hashmap: " + myHashMap.size());
        myHashMap.replace(5, 65);
        System.out.println(myHashMap);
        myHashMap.replace(13, 65);
        System.out.println(myHashMap);
    }
}