import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        return generateTreesInRange(1, n);
    }

    private List<TreeNode> generateTreesInRange(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        // Base case: if start > end, add null to represent an empty subtree
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // Iterate through each number as the root value
        for (int i = start; i <= end; i++) {
            // Generate all possible left and right subtrees
            List<TreeNode> leftTrees = generateTreesInRange(start, i - 1);
            List<TreeNode> rightTrees = generateTreesInRange(i + 1, end);

            // Combine each left and right subtree with the current root
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currentTree = new TreeNode(i);
                    currentTree.left = left;
                    currentTree.right = right;
                    allTrees.add(currentTree);
                }
            }
        }
        return allTrees;
    }
}
