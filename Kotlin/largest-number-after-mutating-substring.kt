package largestnumberaftermutatingsubstring

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maximumNumber(num: String, change: IntArray): String {
        val result = num.toCharArray()
        var mutated = false
        for (i in result.indices) {
            val d = result[i] - '0'
            if (change[d] < d) {
                if (mutated) {
                    break
                }
            } else if (change[d] > d) {
                result[i] = '0' + change[d]
                mutated = true
            }
        }
        return String(result)
    }
}
