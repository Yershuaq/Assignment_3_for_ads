import java.util.Random;

public class MyTestingClass {
    private int value;

    public MyTestingClass(int value) {
        this.value = value;
    }

    @Override
    public int hashCode() {

        return value % 11; // 11 - простое число)))
    }

    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Integer> table = new MyHashTable<>();
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(random.nextInt(100));
            table.put(key, i);
        }

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
}
