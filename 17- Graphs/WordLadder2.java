import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder2 {
    static  List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();

        for(String word: wordList){
            set.add(word);
        }
        Queue<ArrayList<String>> q = new LinkedList<>();

        List<List<String>> ans = new ArrayList<>();

        ArrayList<String> ls = new ArrayList<>();
        ls.add(beginWord);
        q.add(ls);
        set.remove(beginWord);

        ArrayList<String> lastUsed = new ArrayList<>();
        int level = 0;

        while(!q.isEmpty()){
            List<String> vec = q.poll();
            if(!ans.isEmpty() && vec.size() > ans.get(0).size()) break;

            String word = vec.get(vec.size()-1);

            if(vec.size()>level){
                level++;
                for(String it: lastUsed) set.remove(it);
                lastUsed.clear();
        
            }

            if(word.equals(endWord)){
                if(ans.size()==0) ans.add(vec);
                else if(ans.get(0).size()== vec.size()) ans.add(vec);
                continue;
            }

            for(int i = 0; i<word.length(); i++){
                for(char ch = 'a'; ch<='z'; ch++){
                    char[] replacedArray = word.toCharArray();
                    replacedArray[i] = ch;

                    String newWord = new String(replacedArray);
                    if(set.contains(newWord)){
                        vec.add(newWord);

                        ArrayList<String> temp = new ArrayList<>(vec);

                        q.add(temp);

                        lastUsed.add(newWord);
                        vec.remove(vec.size()-1);
                    }
                }
            }
        }

    return ans;

    }
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = List.of("hot","dot","dog","lot","log","cog");
        System.out.println(findLadders(beginWord, endWord, wordList));
    }
}
