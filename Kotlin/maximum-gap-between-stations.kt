package maximumgapbetweenstations

// Time:  O(n)
// Space: O(n)

// prefix sum, greedy
class Solution {
    fun maximumGap(skill: String, station: String): Int {
        val right = IntArray(skill.length)
        var j = station.length - 1
        for (i in skill.length - 1 downTo 0) {
            while (station[j] != skill[i]) {
                --j
            }
            right[i] = j--
        }
        var result = 0
        j = 0
        for (i in 0 until skill.length - 1) {
            while (station[j] != skill[i]) {
                ++j
            }
            result = maxOf(result, right[i + 1] - j++)
        }
        return result
    }
}
