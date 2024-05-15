package Class;

import java.util.Random;

public class MyTestingClass {
    public static void main(String[] args) {
        // Создал экземпляр хеш-таблицы))
        MyHashTable<User, String> table = new MyHashTable<>();


        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            User user = new User("User" + i, random.nextInt(30) + 18);
            table.put(user, "Value" + i);
        }


        for (int i = 0; i < table.size(); i++) {
            int count = 0;
            MyHashTable.HashNode<User, String> current = table.getChainAtIndex(i);
            while (current != null) {
                count++;
                current = current.getNext();
            }
            System.out.println("Bucket " + i + ": " + count + " elements");
        }
    }
}
