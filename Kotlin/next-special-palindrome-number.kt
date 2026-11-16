package nextspecialpalindromenumber
// Time:  precompute: O(9 * 2^9 + 16 * p + plogp), p = len(PALINDROMES)
//        runtime:    O(logp)
// Space: O(p)

private const val MAX_LEN = 16

private fun leftPermutation(left: CharArray): Boolean {
    var pivot = left.size - 2
    while (pivot >= 0 && left[pivot] >= left[pivot + 1]) {
        --pivot
    }
    if (pivot < 0) {
        return false
    }
    var change = left.lastIndex
    while (left[change] <= left[pivot]) {
        --change
    }
    val temp = left[pivot]
    left[pivot] = left[change]
    left[change] = temp
    var l = pivot + 1
    var r = left.lastIndex
    while (l < r) {
        val swap = left[l]
        left[l] = left[r]
        left[r] = swap
        ++l
        --r
    }
    return true
}

private fun precompute(): List<Long> {
    val result = mutableListOf<Long>()
    for (mask in 1 until (1 shl 9)) {
        val left = StringBuilder()
        var mid = ""
        var valid = true
        for (i in 0 until 9) {
            if (mask and (1 shl i) == 0) {
                continue
            }
            if ((i + 1) % 2 != 0) {
                if (mid.isNotEmpty()) {
                    valid = false
                    break
                }
                mid = (i + 1).toString()
            }
            repeat((i + 1) / 2) {
                left.append('0' + i + 1)
            }
        }
        if (!valid) {
            continue
        }
        val digits = left.toString().toCharArray()
        do {
            val half = String(digits)
            val palindrome = half + mid + half.reversed()
            if (palindrome.length > MAX_LEN) {
                break
            }
            result.add(palindrome.toLong())
        } while (leftPermutation(digits))
    }
    result.sort()
    return result
}

private val PALINDROMES = precompute()

class Solution {
    fun specialPalindrome(n: Long): Long {
        var left = 0
        var right = PALINDROMES.size
        while (left < right) {
            val mid = left + (right - left) / 2
            if (PALINDROMES[mid] <= n) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return PALINDROMES[left]
    }
}
