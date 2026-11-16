package shortestdistancetotargetstringinacirculararray

// Time:  O(n)
// Space: O(1)

import kotlin.math.abs

class Solution {
    fun closetTarget(words: List<String>, target: String, startIndex: Int): Int {
        var result = Int.MAX_VALUE
        for (i in words.indices) {
            if (words[i] == target) {
                result = minOf(
                    result,
                    minOf(abs(i - startIndex), abs(words.size - abs(i - startIndex)))
                )
            }
        }
        return if (result != Int.MAX_VALUE) result else -1
    }
}
