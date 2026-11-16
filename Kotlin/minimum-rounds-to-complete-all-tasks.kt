package minimumroundstocompletealltasks

// Time:  O(n)
// Space: O(n)

class Solution {
    fun minimumRounds(tasks: IntArray): Int {
        val cnt = HashMap<Int, Int>()
        for (x in tasks) {
            cnt[x] = cnt.getOrDefault(x, 0) + 1
        }
        var result = 0
        for (v in cnt.values) {
            if (v == 1) {
                return -1
            }
            result += (v + 2) / 3
        }
        return result
    }
}
