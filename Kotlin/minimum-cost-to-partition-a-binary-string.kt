package minimumcosttopartitionabinarystring

// Time:  O(n)
// Space: O(n)

class Solution {
    fun minCost(s: String, encCost: Int, flatCost: Int): Long {
        val prefix = LongArray(s.length + 1)
        for (i in s.indices) {
            prefix[i + 1] = prefix[i] + if (s[i] == '1') 1 else 0
        }

        fun divideAndConquer(left: Int, right: Int): Long {
            val l = right - left + 1
            val x = prefix[right + 1] - prefix[left]
            var result = if (x != 0L) l * x * encCost else flatCost.toLong()
            if (x != 0L && l % 2 == 0) {
                result = minOf(
                    result,
                    divideAndConquer(left, left + l / 2 - 1) + divideAndConquer(left + l / 2, right)
                )
            }
            return result
        }

        return divideAndConquer(0, s.length - 1)
    }
}
