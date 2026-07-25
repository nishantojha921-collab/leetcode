class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null ||prerequisites.length ==0) return true;
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<prerequisites.length; i++){
            inDegree[prerequisites[i][0]]++;
            if(!map.containsKey(prerequisites[i][1])){
                List<Integer> cur =new ArrayList<>();
                cur.add(prerequisites[i][0]);
                map.put(prerequisites[i][1], cur);
            } else{
                map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<inDegree.length;i++){
            if(inDegree[i] == 0) queue.add(i);
        }
        while(!queue.isEmpty()){
            int cur = queue.poll();
            List<Integer> list = map.get(cur);
            for(int i =0; list != null && i<list.size();i++){
                inDegree[list.get(i)]--;
                if(inDegree[list.get(i)] == 0) queue.add(list.get(i));
            }
        }
        for(int i : inDegree){
            if(i != 0) return false;
        }
        return true;
    }
}