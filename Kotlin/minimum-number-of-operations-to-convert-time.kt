package minimumnumberofoperationstoconverttime

// Time:  O(1)
// Space: O(1)

// greedy
class Solution {
    fun convertTime(current: String, correct: String): Int {
        val ops = intArrayOf(60, 15, 5, 1)
        var diff = (correct.substring(0, 2).toInt() * 60 + correct.substring(3).toInt()) -
                   (current.substring(0, 2).toInt() * 60 + current.substring(3).toInt())
        var result = 0
        for (x in ops) {
            val q = diff / x
            diff %= x
            result += q
        }
        return result
    }
}
