
import java.util.*;

class Node {
    Node[] arr = new Node[26];

    boolean containsKey(char ch) {
        return arr[ch - 'a'] != null;
    }

    void put(char ch, Node node) {
        arr[ch - 'a'] = node;
    }

    Node get(char ch) {
        return arr[ch - 'a'];
    }
}

public class CountDistinctSubstring {

    public static int countSubs(String s) {

        Node root = new Node();
        int ct = 0;

        for (int i = 0; i < s.length(); i++) {

            Node node = root;

            for (int j = i; j < s.length(); j++) {

                if (!node.containsKey(s.charAt(j))) {
                    node.put(s.charAt(j), new Node());
                    ct++;
                }

                node = node.get(s.charAt(j));
            }
        }

        return ct;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String s = sc.nextLine();

        int ans = countSubs(s);

        System.out.println("Number of distinct substrings: " + ans);
    }
}