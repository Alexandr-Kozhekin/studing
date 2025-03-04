package Maps;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class AssociationArray<K, V> {

    private Object[][] pairs;
    private int index;

    public AssociationArray(int length) {
        pairs = new Object[length][2];
    }

    public void put(K key, V value) {
        if(index >= pairs.length)
            throw new ArrayIndexOutOfBoundsException();
        pairs[index++] = new Object[]{key, value};
    }

    @SuppressWarnings("unchecked")
    public V get(K key) {
        for(int i = 0; i < index; i++)
            if (key.equals(pairs[i][0]))
                return (V) pairs[i][1];
        return null;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < index; i++) {

            result.append(pairs[i][0].toString());
            result.append(" : ");
            result.append(pairs[i][1].toString());

            if(index < index-1) {
                result.append("\n");
            }

        }

        return result.toString();
    }

    public static void main(String[] args) {

        Map<String, String> hashMap = new HashMap<>();

        hashMap.put("sky", "blue");
        hashMap.put("grass", "green");
        hashMap.put("ocean", "dancing");
        hashMap.put("tree", "tall");
        hashMap.put("earth", "brown");
        hashMap.put("sun", "warm");

        System.out.println("Print HasMap:");
        System.out.println(hashMap);

        Map<String, String> treeMap = new TreeMap<>();

        treeMap.put("sky", "blue");
        treeMap.put("grass", "green");
        treeMap.put("ocean", "dancing");
        treeMap.put("tree", "tall");
        treeMap.put("earth", "brown");
        treeMap.put("sun", "warm");

        System.out.println("Print ThreeMap:");
        System.out.println(hashMap);

        Map<String, String> linkedHashMap = new LinkedHashMap<>();

        linkedHashMap.put("sky", "blue");
        linkedHashMap.put("grass", "green");
        linkedHashMap.put("ocean", "dancing");
        linkedHashMap.put("tree", "tall");
        linkedHashMap.put("earth", "brown");
        linkedHashMap.put("sun", "warm");

        System.out.println("Print LinkedHashMap:");
        System.out.println(hashMap);

        AssociationArray<String, String> map = new AssociationArray<>(6);

        map.put("sky", "blue");
        map.put("grass", "green");
        map.put("ocean", "dancing");
        map.put("tree", "tall");
        map.put("earth", "brown");
        map.put("sun", "warm");

        System.out.println("Print Map:");

        try {
            map.put("extra", "object");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Too many object!");
        }

        System.out.println(map);
        System.out.println(map.get("ocean"));

    }
}
