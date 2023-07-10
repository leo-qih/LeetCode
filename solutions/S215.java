package solutions;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * 215. Kth Largest Element in an Array
 */

public class S215 {
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // for (int num : nums) {
        //     pq.offer(num);
        //     if (pq.size() > k) {
        //         pq.poll();
        //     }
        // }

        // return pq.peek();
        int n = nums.length;
        return quickSelect(nums, 0, n - 1, n - k);
    }

    public int quickSelect(int[] nums, int left, int right, int idx) {
        int pivot = randomPartition(nums, left, right);
        if (pivot == idx) {
            return nums[pivot];
        } else {
            return pivot > idx ? quickSelect(nums, left, pivot - 1, idx) : quickSelect(nums, pivot + 1, right, idx);
        }
    }

    public int randomPartition(int[] nums, int left, int right) {
        int r = random.nextInt(right - left + 1) + left;
        swap(nums, r, right);

        return partition(nums, left, right); 
    }

    public int partition(int[] nums, int left, int right) {
        int val = nums[right], pivot = left;
        for (int i = left; i < right; i++) {
            if (nums[i] <= val) {
                swap(nums, i, pivot);
                pivot++;
            }
        }
        swap(nums, pivot, right);

        return pivot;
    }

    public void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}
