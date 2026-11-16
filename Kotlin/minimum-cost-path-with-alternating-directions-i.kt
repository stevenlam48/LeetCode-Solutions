package minimumcostpathwithalternatingdirectionsi

// Time:  O(1)
// Space: O(1)

class Solution {
    fun minCost(m: Int, n: Int): Int {
        if (m == 1 && n == 1) {
            return 1
        }
        if ((m == 1 && n == 2) || (m == 2 && n == 1)) {
            return 3
        }
        return -1
    }
}
