import java.util.Scanner;

class Node {
    Node[] arr = new Node[26];
    boolean flag = false;

    boolean containsKey(char ch) {
        return arr[ch - 'a'] != null;
    }

    void put(Node node, char ch) {
        arr[ch - 'a'] = node;
    }

    Node get(char ch) {
        return arr[ch - 'a'];
    }

    boolean isEnd() {
        return flag;
    }

    void setEnd() {
        flag = true;
    }
}

class Trie {
    Node root;

    Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(new Node(), word.charAt(i));
            }

            node = node.get(word.charAt(i));
        }

        node.setEnd();
    }

    boolean checkPrefix(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));

                if (!node.isEnd()) {
                    return false;
                }
            }
            else {
                return false;
            }
        }

        return true;
    }
}

public class LongestWordAllPrefixes {

    public String longestString(String[] words) {

        Trie trie = new Trie();

        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }

        String longest = "";

        for (String s : words) {

            if (trie.checkPrefix(s)) {

                if (s.length() > longest.length()) {
                    longest = s;
                }

                else if (s.length() == longest.length()
                        && s.compareTo(longest) < 0) {
                    longest = s;
                }
            }
        }

        return longest;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of words: ");
        int n = sc.nextInt();

        String[] words = new String[n];

        System.out.println("Enter the words:");

        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }

        LongestWordAllPrefixes obj = new LongestWordAllPrefixes();

        String ans = obj.longestString(words);

        System.out.println("Longest String: " + ans);

        sc.close();
    }
}
