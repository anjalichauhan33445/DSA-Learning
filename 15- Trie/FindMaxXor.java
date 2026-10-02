
class Node{
    Node[] arr = new Node[2];

    boolean containsKey(int bit){
        return arr[bit]!=null;
    }
    void put(int bit, Node node){
        arr[bit]= node;
    }

    Node get(int bit){
        return arr[bit];
    }
}

class Trie{
    Node root;

    Trie(){
        root = new Node();
    }

    void insert(int num){
        Node node = root;
        for(int i = 31;i>=0;i--){
            int bit = num>>i & 1;

            if(!node.containsKey(bit)){
                node.put(bit,new Node());
            }
            node = node.get(bit);
        }
    }

    int getMax(int num){
        Node node = root;
        int maxm = 0;
        for(int i = 31; i>=0;i--){
            int bit= num>>i & 1;

            if(node.containsKey(1-bit)){
                maxm = maxm | 1<<i;
                node = node.get(1-bit);
            }
            else{
                node = node.get(bit);
            }
        }
        return maxm;
    }

}

class FindMaxXor {
    public static int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for(int i = 0;i<nums.length;i++){
            trie.insert(nums[i]);
        }

        int maxi = 0;
        for(int i = 0; i<nums.length;i++){
            maxi = Math.max(trie.getMax(nums[i]),maxi);
        }
        return maxi;
    }
    public static void main(String[] args) {
        int[] nums = {14,70,53,83,49,91,36,80,92,51,66,70};
        System.out.println("Output: "+findMaximumXOR(nums));
    }
}
