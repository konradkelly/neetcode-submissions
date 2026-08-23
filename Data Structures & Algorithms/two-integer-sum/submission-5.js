class Solution {
    /**
     * @param {number[]} nums
     * @param {number} target
     * @return {number[]}
     */
    twoSum(nums, target) {
        const indices = {};

        for (let i = 0; i < nums.length; i++) {
            indices[nums[i]] = i;
        }
        for (let i = 0; i < nums.length; i++) {
            let diff = target - nums[i];
            if (indices[diff] !== i && indices[diff] !== undefined) {
                return [i, indices[diff]];
            }
        }
        return [];
    }
}
