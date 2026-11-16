package minimumnumberofoperationstomakearrayxorequaltok

// Time:  O(n)
// Space: O(1)

// bit manipulation
class Solution {
    fun minOperations(nums: IntArray, k: Int): Int {
        var acc = k
        for (x in nums) {
            acc = acc xor x
        }
        return Integer.bitCount(acc)
    }
}
