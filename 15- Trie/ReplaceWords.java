import java.util.*;

class Node{
    Node[] links = new Node[26];
    boolean flag = false;

    boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    }

    void put(Node node, char ch){
        links[ch - 'a'] = node;
    }

    Node get(char ch){
        return links[ch - 'a'];
    }

    void setEnd(){
        flag = true;
    }

    boolean getEnd(){
        return flag;
    }
}

class Solution {
    Node root = new Node();

    void insert(String word){
        Node node = root;

        for(int i = 0; i < word.length(); i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(new Node(), word.charAt(i));
            }

            node = node.get(word.charAt(i));
        }

        node.setEnd();
    }

    String helper(String word){
        Node node = root;
        String temp = "";

        for(char ch : word.toCharArray()){
            if(node.get(ch) == null){
                return word;
            }

            node = node.get(ch);
            temp += ch;

            if(node.getEnd()){
                return temp;
            }
        }

        return word;
    }

    public String replaceWords(List<String> dictionary, String sentence){
        for(int i = 0; i < dictionary.size(); i++){
            insert(dictionary.get(i));
        }

        String ans = "";
        String temp = "";

        for(int i = 0; i < sentence.length(); i++){
            if(sentence.charAt(i) == ' '){
                ans += helper(temp);
                ans += " ";
                temp = "";
            }
            else{
                temp += sentence.charAt(i);
            }
        }

        ans += helper(temp);

        return ans;
    }
}

public class ReplaceWords {
    public static void main(String[] args) {

        Solution obj = new Solution();

        List<String> dictionary = Arrays.asList(
            "cat", "bat", "rat"
        );

        String sentence = "the cattle was rattled by the battery";

        String ans = obj.replaceWords(dictionary, sentence);

        System.out.println(ans);
    }
}