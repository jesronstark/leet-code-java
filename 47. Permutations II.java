import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to handle duplicates
        boolean[] visited = new boolean[nums.length];
        backtrack(result, new ArrayList<>(), nums, visited);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] visited) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue; // Skip used elements
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue; // Skip duplicates
            visited[i] = true;
            tempList.add(nums[i]);
            backtrack(result, tempList, nums, visited);
            visited[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
}

