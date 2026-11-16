package dividearrayinsetsofkconsecutivenumbers
// Time:  O(nlogn)
// Space: O(n)

import java.util.TreeMap

class Solution {
    fun isPossibleDivide(nums: IntArray, k: Int): Boolean {
        val count = TreeMap<Int, Int>()
        for (num in nums) {
            count[num] = (count[num] ?: 0) + 1
        }
        for ((num, c) in count) {
            if (c == 0) {
                continue
            }
            for (i in num until num + k) {
                if ((count[i] ?: 0) < c) {
                    return false
                }
                count[i] = count.getValue(i) - c
            }
        }
        return true
    }
}
