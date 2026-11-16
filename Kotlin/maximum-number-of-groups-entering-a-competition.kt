package maximumnumberofgroupsenteringacompetition
// Time:  O(1)
// Space: O(1)

import kotlin.math.sqrt

class Solution {
    fun maximumGroups(grades: IntArray): Int {
        return ((sqrt(1.0 + 8 * grades.size) - 1) / 2.0).toInt()
    }
}
