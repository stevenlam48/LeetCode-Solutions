package threeequalparts
// Time:  O(n)
// Space: O(1)

class Solution {
    fun threeEqualParts(A: IntArray): IntArray {
        val total = A.sum()
        if (total % 3 != 0) {
            return intArrayOf(-1, -1)
        }
        if (total == 0) {
            return intArrayOf(0, A.size - 1)
        }

        val count = total / 3
        val nums = IntArray(3)
        var c = 0
        for (i in A.indices) {
            if (A[i] == 1) {
                if (c % count == 0) {
                    nums[c / count] = i
                }
                ++c
            }
        }

        while (nums[2] != A.size) {
            if (A[nums[0]] != A[nums[1]] || A[nums[0]] != A[nums[2]]) {
                return intArrayOf(-1, -1)
            }
            ++nums[0]
            ++nums[1]
            ++nums[2]
        }
        return intArrayOf(nums[0] - 1, nums[1])
    }
}
