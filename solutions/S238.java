package solutions;

/**
 * 238. Product of Array Except Self
 */

public class S238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] products = new int[n];
        products[0] = 1;
        for (int i = 1; i < n; i++) {
            products[i] = products[i - 1] * nums[i - 1];
        }
        int rightProduct = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            products[i] = products[i] * rightProduct;
            rightProduct *= nums[i];
        }

        return products;
    }
}
