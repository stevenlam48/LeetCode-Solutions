package smallestallonesmultiple

// Time:  O(k)
// Space: O(1)

class Solution {
    fun minAllOneMultiple(k: Int): Int {
        if (k % 2 == 0 || k % 5 == 0) {
            return -1
        }
        var r = 0
        for (n in 1..k) {
            r = (r * 10 + 1) % k
            if (r == 0) {
                return n
            }
        }
        return -1
    }
}
