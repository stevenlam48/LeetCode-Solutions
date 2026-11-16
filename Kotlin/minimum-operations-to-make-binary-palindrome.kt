package minimumoperationstomakebinarypalindrome

// Time:  precompute: O(sqrt(r) * logr + r) = O(sqrt(r) * logr), r = max(nums)
//        runtime:    O(n)
// Space: O(r)

private fun precompute(n: Int): IntArray {
    fun bitLength(x: Int): Int {
        return (if (x != 0) 31 - Integer.numberOfLeadingZeros(x) else -1) + 1
    }

    val l = bitLength(n)
    val palindromes = ArrayList<Int>()
    for (d in 1..l) {
        val h = (d + 1) / 2
        for (prefix in (1 shl (h - 1)) until (1 shl h)) {
            var p = prefix
            var t = prefix
            t = t shr (d % 2)
            for (i in 0 until h - d % 2) {
                p = (p shl 1) or (t and 1)
                t = t shr 1
            }
            if (p <= n) {
                palindromes.add(p)
            }
        }
    }
    val lookup = IntArray(n + 1) { Int.MAX_VALUE }
    var i = 0
    for (x in 1..n) {
        while (i < palindromes.size) {
            if (palindromes[i] > x) {
                break
            }
            ++i
        }
        if (i < palindromes.size) {
            lookup[x] = minOf(lookup[x], palindromes[i] - x)
        }
        if (i - 1 >= 0) {
            lookup[x] = minOf(lookup[x], x - palindromes[i - 1])
        }
    }
    return lookup
}

private const val MAX_NUM = 5000
private val LOOKUP = precompute(MAX_NUM)

class Solution {
    fun minOperations(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        for (i in nums.indices) {
            result[i] = LOOKUP[nums[i]]
        }
        return result
    }
}
