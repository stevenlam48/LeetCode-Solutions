package mostfrequentevenelement
// Time:  O(n)
// Space: O(n)

class Solution {
    fun mostFrequentEven(nums: IntArray): Int {
        val cnt = HashMap<Int, Int>()
        var mx = 0
        var result = -1
        for (x in nums) {
            if (x % 2 != 0) {
                continue
            }
            cnt[x] = cnt.getOrDefault(x, 0) + 1
            if (mx == 0 || mx < cnt.getValue(x) || (mx == cnt.getValue(x) && x < result)) {
                mx = cnt.getValue(x)
                result = x
            }
        }
        return result
    }
}
