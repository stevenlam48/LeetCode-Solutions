package earliestpossibledayoffullbloom

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun earliestFullBloom(plantTime: IntArray, growTime: IntArray): Int {
        val order = (plantTime.indices).sortedByDescending { growTime[it] }
        var result = 0
        var curr = 0
        for (i in order) {
            curr += plantTime[i]
            result = maxOf(result, curr + growTime[i])
        }
        return result
    }
}
