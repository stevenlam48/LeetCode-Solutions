package minimumnumberofstepstomaketwostringsanagramii

// Time:  O(n)
// Space: O(1)

import kotlin.math.abs

class Solution {
    fun minSteps(s: String, t: String): Int {
        val count1 = counter(s)
        val count2 = counter(t)
        var result = 0
        for (i in count1.indices) {
            result += abs(count1[i] - count2[i])
        }
        return result
    }

    private fun counter(s: String): IntArray {
        val count = IntArray(26)
        for (c in s) {
            ++count[c - 'a']
        }
        return count
    }
}
