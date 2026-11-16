package maximumnumberofremovablecharacters

// Time:  O(rlogn)
// Space: O(r)

class Solution {
    fun maximumRemovals(s: String, p: String, removable: IntArray): Int {
        var left = 0
        var right = removable.size
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (!check(s, p, removable, mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return right
    }

    private fun check(s: String, p: String, removable: IntArray, x: Int): Boolean {
        val lookup = HashSet<Int>()
        for (i in 0 until x) {
            lookup.add(removable[i])
        }
        var j = 0
        for (i in s.indices) {
            if (lookup.contains(i) || s[i] != p[j]) {
                continue
            }
            if (++j == p.length) {
                return true
            }
        }
        return false
    }
}
