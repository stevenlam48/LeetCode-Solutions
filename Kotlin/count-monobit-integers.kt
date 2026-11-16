package countmonobitintegers

// Time:  O(logn)
// Space: O(1)

// bitmasks
class Solution {
    fun countMonobit(n: Int): Int {
        return 32 - Integer.numberOfLeadingZeros(n + 1)
    }
}
