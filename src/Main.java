import Class.*;

public class Main {
    public static void main(String[] args) {
        // Тест MyHashTableа
        MyTestingClass.main(args);

        // Тестирование BSTа
        BST<Integer, String> bst = new BST<>();
        bst.put(5, "Five");
        bst.put(3, "Three");
        bst.put(7, "Seven");

        System.out.println("Value for key 3: " + bst.get(3)); // Output: Three
        System.out.println("Size of BST: " + bst.size()); // Output: 3
        System.out.println("In-order traversal of BST:");
        for (Integer key : bst.iterator()) {
            System.out.println("Key is " + key + " and value is " + bst.get(key));
        }
    }
}
