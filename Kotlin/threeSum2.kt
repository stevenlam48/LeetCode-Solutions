package threeSum2
// Time Complexity: O(n^2)
// Space Complexity: O(1)

class Solution {
    fun threeSum(num: IntArray): Array<IntArray> {
        val ans = mutableListOf<IntArray>()
        val target = 0
        num.sort()
        var a = num.lastIndex
        while (a >= 2) {
            if (a < num.lastIndex && num[a] == num[a + 1]) {
                --a
                continue
            }
            var b = a - 1
            var c = 0
            while (c < b) {
                if (b < a - 1 && num[b] == num[b + 1]) {
                    --b
                } else if (c > 0 && num[c] == num[c - 1]) {
                    ++c
                } else {
                    val sum = num[a] + num[b] + num[c]
                    if (sum < target) {
                        ++c
                    } else if (sum > target) {
                        --b
                    } else {
                        ans.add(intArrayOf(num[c], num[b], num[a]))
                        --b
                        ++c
                    }
                }
            }
            --a
        }
        return ans.toTypedArray()
    }
}
