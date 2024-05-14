import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Тестирование MyHashTable
        testHashTable();

        // Тестирование BST
        testBST();
    }

    private static void testHashTable() {
        MyHashTable<MyTestingClass, Integer> table = new MyHashTable<>();
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(random.nextInt(100));
            table.put(key, i);
        }
        // Печать количества элементов в каждом бакете
        for (int i = 0; i < 11; i++) {
            System.out.println("Bucket " + i + ": " + countElementsInBucket(table, i));
        }
    }

    private static <K, V> int countElementsInBucket(MyHashTable<K, V> table, int index) {
        int count = 0;
        MyHashTable.HashNode<K, V> current = table.chainArray[index];
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    private static void testBST() {
        BST<Integer, String> bst = new BST<>();
        bst.put(5, "Five");
        bst.put(3, "Three");
        bst.put(7, "Seven");
        bst.put(2, "Two");
        bst.put(4, "Four");
        bst.put(6, "Six");
        bst.put(8, "Eight");

        System.out.println("Value for key 4: " + bst.get(4));
        System.out.println("Size of BST: " + bst.size);

        System.out.println("Iterating through BST:");
        for (BST<Integer, String>.Node node : bst) {
            System.out.println("Key: " + node.key + ", Value: " + node.val);
        }
    }
}
