package findclosestperson

// Time:  O(1)
// Space: O(1)

// math
class Solution {
    fun findClosest(x: Int, y: Int, z: Int): Int {
        return if (Math.abs(x - z) == Math.abs(y - z)) 0 else if (Math.abs(x - z) < Math.abs(y - z)) 1 else 2
    }
}
