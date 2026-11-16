package countthenumberofsubstringswithdominantones
// Time:  O(n * sqrt(n)) = O(n^(3/2))
// Space: O(n)

import kotlin.math.min
import kotlin.math.sqrt

class Solution {
    fun numberOfSubstrings(s: String): Int {
        var result = 0
        val idxs = mutableListOf(-1)
        for (i in s.indices) {
            if (s[i] == '0') {
                idxs.add(i)
            }
        }
        idxs.add(s.length)
        var curr = 1
        for (i in s.indices) {
            if (idxs[curr] == i) {
                ++curr
            }
            val l = ((-1 + sqrt(1.0 + 4 * (i + 1))) / 2).toInt()
            for (c in 0..min(l, curr - 1)) {
                if (c * c <= (i - idxs[(curr - c) - 1]) - c) {
                    result += min(
                        min(idxs[curr - c], i) - idxs[(curr - c) - 1],
                        ((i - idxs[(curr - c) - 1]) - c) - c * c + 1
                    )
                }
            }
        }
        return result
    }
}
