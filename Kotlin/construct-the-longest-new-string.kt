package constructthelongestnewstring

// Time:  O(1)
// Space: O(1)

// constructive algorithms, math
class Solution {
    fun longestString(x: Int, y: Int, z: Int): Int {
        return ((minOf(x, y) * 2 + if (x != y) 1 else 0) + z) * 2
    }
}
