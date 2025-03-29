import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result; // Early return if the string length is not suitable for an IP address
        }
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> path, List<String> result) {
        // If we have 4 segments and we've used all characters, it's a valid IP address
        if (path.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", path));
            }
            return;
        }
        // Try to create segments of length 1, 2, and 3
        for (int length = 1; length <= 3; length++) {
            if (start + length <= s.length()) {
                String segment = s.substring(start, start + length);
                if (isValid(segment)) {
                    path.add(segment); // Add the segment to the current path
                    backtrack(s, start + length, path, result); // Recurse with updated start and path
                    path.remove(path.size() - 1); // Backtrack by removing the last segment
                }
            }
        }
    }

    private boolean isValid(String segment) {
        // A segment is invalid if it has a leading zero and its length is more than 1
        if (segment.length() > 1 && segment.startsWith("0")) {
            return false;
        }
        // A segment is invalid if its value is not between 0 and 255
        int num = Integer.parseInt(segment);
        return num >= 0 && num <= 255;
    }
}
