import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
class Pair{
    String first;
    int second;

    Pair(String first, int second){
        this.first = first;
        this.second = second;
    }
}
public class WordLadder {
    
    static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        for(int i = 0 ; i<wordList.size(); i++ ){
            set.add(wordList.get(i));
        }

        set.remove(beginWord);

        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;
            if(word.equals(endWord)) return steps;    
            q.remove();
            for(int i = 0; i<word.length(); i++){                
                for(char ch = 'a'; ch<='z'; ch++){
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);    
                    if(set.contains(replacedWord)){
                        set.remove(replacedWord);
                        q.add(new Pair(replacedWord,steps+1));
                    }
                }
            }
            
        }
        return 0;
    }
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = List.of("hot","dot","dog","lot","log","cog");
        System.out.println("Output: "+ladderLength(beginWord, endWord, wordList));

    }
}
