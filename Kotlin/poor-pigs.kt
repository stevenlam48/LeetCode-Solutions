package poorpigs
import kotlin.math.ceil
import kotlin.math.ln
// Time:  O(1)
// Space: O(1)

class Solution {
    fun poorPigs(buckets: Int, minutesToDie: Int, minutesToTest: Int): Int {
        return ceil(ln(buckets.toDouble()) / ln((minutesToTest / minutesToDie + 1).toDouble())).toInt()
    }
}
