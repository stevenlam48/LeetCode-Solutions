package findtriangularsumofanarray
// Time:  O(n)
// Space: O(1)

class Solution {
    fun triangularSum(nums: IntArray): Int {
        fun expMod(p: Int, mod: Int): List<Int> {
            val result = mutableListOf(p)
            while (result.last() * p % mod != result[0]) {
                result.add(result.last() * p % mod)
            }
            result.add(0, result.removeAt(result.lastIndex))
            return result
        }

        fun invMod(x: Int, mod: Int): Int {
            var y = x
            while (y * x % mod != 1) {
                y = y * x % mod
            }
            return y
        }

        fun factorP(value: Int, p: Int, count: Int, diff: Int): Pair<Int, Int> {
            var x = value
            var cnt = count
            if (x == 0) {
                return Pair(x, cnt)
            }
            while (x % p == 0) {
                x /= p
                cnt += diff
            }
            return Pair(x, cnt)
        }

        val exp = mapOf(2 to expMod(2, 10), 5 to expMod(5, 10))
        val inv = mapOf(1 to invMod(1, 10), 3 to invMod(3, 10), 7 to invMod(7, 10), 9 to invMod(9, 10))
        val cnt = mutableMapOf(2 to 0, 5 to 0)
        var result = 0
        var nCr = 1
        for (i in nums.indices) {
            if (cnt[2] == 0 && cnt[5] == 0) {
                result = (result + nCr * nums[i]) % 10
            } else if (cnt[2] != 0 && cnt[5] == 0) {
                result = (result + nCr * exp.getValue(2)[cnt.getValue(2) % exp.getValue(2).size] * nums[i]) % 10
            } else if (cnt[2] == 0 && cnt[5] != 0) {
                result = (result + nCr * exp.getValue(5)[cnt.getValue(5) % exp.getValue(5).size] * nums[i]) % 10
            }
            var mul = nums.size - 1 - i
            factorP(mul, 2, cnt.getValue(2), 1).also { mul = it.first; cnt[2] = it.second }
            factorP(mul, 5, cnt.getValue(5), 1).also { mul = it.first; cnt[5] = it.second }
            var div = i + 1
            factorP(div, 2, cnt.getValue(2), -1).also { div = it.first; cnt[2] = it.second }
            factorP(div, 5, cnt.getValue(5), -1).also { div = it.first; cnt[5] = it.second }
            nCr = nCr * mul % 10
            nCr = nCr * inv.getValue(div % 10) % 10
        }
        return result
    }
}
