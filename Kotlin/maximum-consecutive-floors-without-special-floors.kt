package maximumconsecutivefloorswithoutspecialfloors

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun maxConsecutive(bottom: Int, top: Int, special: IntArray): Int {
        special.sort()
        var result = maxOf(special[0] - bottom, top - special.last())
        for (i in 1 until special.size) {
            result = maxOf(result, special[i] - special[i - 1] - 1)
        }
        return result
    }
}
