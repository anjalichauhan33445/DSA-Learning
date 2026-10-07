import java.util.*;

class Node{
    Node[] links = new Node[26];
    List<String> str = new ArrayList<>();

    void put(Node node, char ch){
        links[ch-'a'] = node;
    }

    Node get(char ch){
        return links[ch-'a'];
    }

    boolean containsKey(char ch){
        return links[ch-'a'] != null;
    }

    void putString(String word){
        str.add(word);
    }
}

class Trie{
    Node root;

    Trie(){
        root = new Node();
    }

    void insert(String word){
        Node node = root;

        for(int i = 0; i < word.length(); i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(new Node(), word.charAt(i));
            }

            node = node.get(word.charAt(i));

            if(node.str.size() < 3){
                node.putString(word);
            }
        }
    }
}

public class SearchSuggestions{

    public static List<List<String>> suggestedProducts(String[] products, String searchWord){

        Arrays.sort(products);

        Trie trie = new Trie();
        Node node = trie.root;
        boolean chk = true;

        for(String product : products){
            trie.insert(product);
        }

        List<List<String>> ans = new ArrayList<>();

        for(int i = 0; i < searchWord.length(); i++){

            if(!chk || !node.containsKey(searchWord.charAt(i))){
                chk = false;
                ans.add(new ArrayList<>());
            }
            else{
                node = node.get(searchWord.charAt(i));
                ans.add(new ArrayList<>(node.str));
            }
        }

        return ans;
    }

    public static void main(String[] args){

        String[] products = {
            "mobile",
            "mouse",
            "moneypot",
            "monitor",
            "mousepad"
        };

        String searchWord = "mouse";

        List<List<String>> ans = suggestedProducts(products, searchWord);

        System.out.println(ans);
    }
}