package maximizethenumberofpartitionsafteroperations

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maxPartitionsAfterOperations(s: String, k: Int): Int {
        val n = s.length
        val left = IntArray(n + 1)
        val leftMask = IntArray(n + 1)
        var cnt = 0
        var mask = 0
        for (i in 0 until n) {
            mask = mask or (1 shl (s[i] - 'a'))
            if (Integer.bitCount(mask) > k) {
                ++cnt
                mask = 1 shl (s[i] - 'a')
            }
            left[i + 1] = cnt
            leftMask[i + 1] = mask
        }
        val right = IntArray(n + 1)
        val rightMask = IntArray(n + 1)
        cnt = 0
        mask = 0
        for (i in n - 1 downTo 0) {
            mask = mask or (1 shl (s[i] - 'a'))
            if (Integer.bitCount(mask) > k) {
                ++cnt
                mask = 1 shl (s[i] - 'a')
            }
            right[i] = cnt
            rightMask[i] = mask
        }

        var result = 0
        for (i in 0 until n) {
            var curr = left[i] + right[i + 1]
            val merged = leftMask[i] or rightMask[i + 1]
            if (Integer.bitCount(leftMask[i]) == k &&
                Integer.bitCount(rightMask[i + 1]) == k &&
                Integer.bitCount(merged) != 26
            ) {
                curr += 3
            } else if (Integer.bitCount(merged) + (if (Integer.bitCount(merged) != 26) 1 else 0) > k) {
                curr += 2
            } else {
                curr += 1
            }
            result = maxOf(result, curr)
        }
        return result
    }
}
