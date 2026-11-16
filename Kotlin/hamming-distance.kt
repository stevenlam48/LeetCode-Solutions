package hammingdistance

// Time:  O(1)
// Space: O(1)

class Solution {
    fun hammingDistance(x: Int, y: Int): Int {
        var distance = 0
        var z = x xor y
        while (z != 0) {
            ++distance
            z = z and (z - 1)
        }
        return distance
    }
}
