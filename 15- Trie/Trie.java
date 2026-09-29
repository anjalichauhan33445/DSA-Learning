class Node {
    Node[] links = new Node[26];
    boolean flag = false;

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    void put(Node node, char ch) {
        links[ch - 'a'] = node;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void setEnd() {
        flag = true;
    }

    boolean isEnd() {
        return flag;
    }
}

public class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;

        for(int i = 0; i < word.length(); i++) {
            if(!node.containsKey(word.charAt(i))) {
                node.put(new Node(), word.charAt(i));
            }

            node = node.get(word.charAt(i));
        }

        node.setEnd();
    }

    public boolean search(String word) {
        Node node = root;

        for(int i = 0; i < word.length(); i++) {
            if(!node.containsKey(word.charAt(i))) {
                return false;
            }

            node = node.get(word.charAt(i));
        }

        return node.isEnd();
    }

    public boolean startsWith(String prefix) {
        Node node = root;

        for(int i = 0; i < prefix.length(); i++) {
            if(!node.containsKey(prefix.charAt(i))) {
                return false;
            }

            node = node.get(prefix.charAt(i));
        }

        return true;
    }

    public static void main(String[] args) {

        Trie trie = new Trie();

        trie.insert("apple");
        trie.insert("app");
        trie.insert("application");
        trie.insert("banana");

        System.out.println("Search apple: " + trie.search("apple"));
        System.out.println("Search app: " + trie.search("app"));
        System.out.println("Search appl: " + trie.search("appl"));
        System.out.println("Search banana: " + trie.search("banana"));
        System.out.println("Search orange: " + trie.search("orange"));

        System.out.println("Starts with app: " + trie.startsWith("app"));
        System.out.println("Starts with ban: " + trie.startsWith("ban"));
        System.out.println("Starts with ora: " + trie.startsWith("ora"));
    }
}