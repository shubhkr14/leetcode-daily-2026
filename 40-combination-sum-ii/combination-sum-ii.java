class Solution {
    public void backtrack(int start, List<List<Integer>> ans, int[] arr, int target, List<Integer> temp){
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<arr.length;i++){
            if(i>start && arr[i]==arr[i-1]) continue;
            if(arr[i]>target) break;
            temp.add(arr[i]);
            backtrack(i+1,ans,arr,target-arr[i],temp);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0,ans,candidates,target,new ArrayList<>());
        return ans;
    }
}
