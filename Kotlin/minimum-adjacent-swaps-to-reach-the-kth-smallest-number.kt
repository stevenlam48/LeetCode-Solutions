package minimumadjacentswapstoreachthekthsmallestnumber

// Time:  O((k + n) * n)
// Space: O(n)

class Solution {
    fun getMinSwaps(num: String, k: Int): Int {
        val newNum = num.toCharArray()
        repeat(k) {
            nextPermutation(newNum)
        }
        var result = 0
        for (i in newNum.indices) {
            if (newNum[i] == num[i]) {
                continue
            }
            var j = i + 1
            while (j < newNum.size && newNum[j] != num[i]) {
                ++j
            }
            result += j - i
            while (j > i) {
                val temp = newNum[j - 1]
                newNum[j - 1] = newNum[j]
                newNum[j] = temp
                --j
            }
        }
        return result
    }

    private fun nextPermutation(num: CharArray) {
        var i = num.size - 2
        while (i >= 0 && num[i] >= num[i + 1]) {
            --i
        }
        if (i >= 0) {
            var j = num.size - 1
            while (num[j] <= num[i]) {
                --j
            }
            val temp = num[i]
            num[i] = num[j]
            num[j] = temp
        }
        var left = i + 1
        var right = num.size - 1
        while (left < right) {
            val temp = num[left]
            num[left] = num[right]
            num[right] = temp
            ++left
            --right
        }
    }
}
