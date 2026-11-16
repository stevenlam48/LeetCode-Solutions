package makearrayzerobysubtractingequalamounts

// Time:  O(n)
// Space: O(n)

class Solution {
    fun minimumOperations(nums: IntArray): Int {
        val lookup = HashSet<Int>()
        for (x in nums) {
            if (x != 0) {
                lookup.add(x)
            }
        }
        return lookup.size
    }
}
