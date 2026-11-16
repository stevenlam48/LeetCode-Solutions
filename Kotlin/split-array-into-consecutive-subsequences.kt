package splitarrayintoconsecutivesubsequences
// Time:  O(n)
// Space: O(1)

class Solution {
    fun isPossible(nums: IntArray): Boolean {
        var pre = Int.MIN_VALUE
        var cur = 0
        var cnt1 = 0
        var cnt2 = 0
        var cnt3 = 0
        var i = 0
        while (i < nums.size) {
            var cnt = 0
            cur = nums[i]
            while (i < nums.size && cur == nums[i]) {
                ++cnt
                ++i
            }

            if (cur != pre + 1) {
                if (cnt1 != 0 || cnt2 != 0) {
                    return false
                }
                cnt1 = cnt
                cnt2 = 0
                cnt3 = 0
            } else {
                if (cnt < cnt1 + cnt2) {
                    return false
                }
                val nextCnt1 = maxOf(0, cnt - (cnt1 + cnt2 + cnt3))
                val nextCnt2 = cnt1
                val nextCnt3 = cnt2 + minOf(cnt3, cnt - (cnt1 + cnt2))
                cnt1 = nextCnt1
                cnt2 = nextCnt2
                cnt3 = nextCnt3
            }
            pre = cur
        }
        return cnt1 == 0 && cnt2 == 0
    }
}
