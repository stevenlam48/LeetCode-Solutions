package minimumnumberofincrementsonsubarraystoformatargetarray

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minNumberOperations(target: IntArray): Int {
        var result = 0
        for (i in 0..target.size) {
            val cur = if (i < target.size) target[i] else 0
            val prev = if (i - 1 >= 0) target[i - 1] else 0
            result += maxOf(cur - prev, 0)
        }
        return result
    }
}
