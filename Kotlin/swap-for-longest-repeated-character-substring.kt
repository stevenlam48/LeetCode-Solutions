package swapforlongestrepeatedcharactersubstring

import kotlin.math.max
import kotlin.math.min

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxRepOpt1(text: String): Int {
        val K = 1
        var result = 0
        var maxCount = 0
        val totalCount = HashMap<Char, Int>()
        val count = HashMap<Char, Int>()
        var left = 0
        for (i in text.indices) {
            totalCount[text[i]] = (totalCount[text[i]] ?: 0) + 1
            count[text[i]] = (count[text[i]] ?: 0) + 1
            maxCount = max(maxCount, count[text[i]]!!)
            if (i - left + 1 - maxCount > K) {
                count[text[left]] = count[text[left]]!! - 1
                ++left
            }
            result = max(result, min(i - left + 1, totalCount[text[i]]!!))
        }
        return result
    }
}
