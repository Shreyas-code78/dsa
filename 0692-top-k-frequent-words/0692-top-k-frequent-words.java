class Pair {
    int first;
    String second;

    Pair(int first,String second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        int size = words.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) ->{
                if(a.first!=b.first){
                    return a.first-b.first;
                }
                return b.second.compareTo(a.second);
            }

        );
        Map<String , Integer> f = new HashMap<>();
        for(int i = 0 ; i<size ; i++){
            if (f.containsKey(words[i])) {
                f.put(words[i], f.get(words[i]) + 1);
            } else {
                f.put(words[i], 1);
            }
        }
        for (Map.Entry<String, Integer> i : f.entrySet()) {

            String element = i.getKey();
            int frequ = i.getValue();

            Pair curr = new Pair(frequ, element);

            if (pq.size() < k) {
                pq.offer(curr);
                continue;
            }
            Pair top = pq.peek();

             if (curr.first > top.first ||
                    (curr.first == top.first &&
                     curr.second.compareTo(top.second) < 0)){
                        pq.poll();
                        pq.offer(curr);

                     }
            
            

        }
        
        List<String> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(pq.poll().second);
            
        }
        Collections.reverse(res);
        return res;
        

    }
}