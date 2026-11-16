package findthechildwhohastheballafterkseconds

// Time:  O(1)
// Space: O(1)
class Solution {
    fun numberOfChild(n: Int, k: Int): Int {
        val q = k / (n - 1)
        val r = k % (n - 1)
        return if ((q and 1) == 0) r else (n - 1) - r
    }
}
