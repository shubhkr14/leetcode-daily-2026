class Solution{
    public List<String> findItinerary(List<List<String>> tickets){
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> ticket : tickets){
            graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>())
                 .offer(ticket.get(1));
        }

        LinkedList<String> ans = new LinkedList<>();
        dfs("JFK", graph, ans);

        return ans;
    }

    private void dfs(String airport,
                     Map<String, PriorityQueue<String>> graph,
                     LinkedList<String> ans){

        PriorityQueue<String> pq = graph.get(airport);

        while (pq != null && !pq.isEmpty()){
            dfs(pq.poll(), graph, ans);
        }

        ans.addFirst(airport);
    }
}