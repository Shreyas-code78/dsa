class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int size = nums.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) ->{
                if(a.first!=b.first){
                    return a.first-b.first;
                }
                return a.second-b.second;
            }

        );
        Map<Integer , Integer> f = new HashMap<>();
        for(int i = 0 ; i<size ; i++){
            if (f.containsKey(nums[i])) {
                f.put(nums[i], f.get(nums[i]) + 1);
            } else {
                f.put(nums[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> i : f.entrySet()) {

            int element = i.getKey();
            int frequ = i.getValue();

            Pair curr = new Pair(frequ, element);

            if (pq.size() < k) {
                pq.offer(curr);
                continue;
            }

            if (pq.peek().first > curr.first) {
                continue;
            }
            pq.poll();
            pq.offer(curr);
            

        }
        int [] res = new int[k];
        int index = 0;
        while(!pq.isEmpty()){
            res[index] = pq.peek().second;
            pq.poll();
            index++;
        }
        return res;
        


    }
    
}