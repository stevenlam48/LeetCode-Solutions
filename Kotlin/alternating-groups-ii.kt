package alternatinggroupsii

// Time:  O(n)
// Space: O(1)

// sliding window, two pointers
class Solution {
    fun numberOfAlternatingGroups(colors: IntArray, k: Int): Int {
        val n = colors.size
        var result = 0
        var left = 0
        var curr = 0
        for (right in 0 until n + k - 1) {
            if (right - left + 1 == k) {
                result += if (curr == k - 1) 1 else 0
                curr -= if (colors[left] != colors[(left + 1) % n]) 1 else 0
                ++left
            }
            curr += if (colors[right % n] != colors[(right + 1) % n]) 1 else 0
        }
        return result
    }
}
