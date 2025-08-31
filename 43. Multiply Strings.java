public class Solution {
    public String multiply(String num1, String num2) {
        // Edge case: if either number is "0", the product is "0"
        if (num1.equals("0") || num2.equals("0")) return "0";

        int len1 = num1.length();
        int len2 = num2.length();
        int[] product = new int[len1 + len2];

        // Reverse both strings to facilitate multiplication from least significant digit
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();

        // Multiply each digit and accumulate results in the product array
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                int digit1 = n1.charAt(i) - '0';
                int digit2 = n2.charAt(j) - '0';
                product[i + j] += digit1 * digit2;
                // Handle carry-over
                if (product[i + j] >= 10) {
                    product[i + j + 1] += product[i + j] / 10;
                    product[i + j] %= 10;
                }
            }
        }

        // Convert product array to string, skipping leading zeros
        StringBuilder result = new StringBuilder();
        for (int i = product.length - 1; i >= 0; i--) {
            if (!(result.length() == 0 && product[i] == 0)) {
                result.append(product[i]);
            }
        }



        return result.toString();
    }
}
