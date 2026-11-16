package lexicographicalnumbers

// Time:  O(n)
// Space: O(1)

class Solution {
    fun lexicalOrder(n: Int): List<Int> {
        val result = ArrayList<Int>()
        var i = 1
        var num = 1

        while (result.size < n) {
            var k = 0
            while (i * Math.pow(10.0, k.toDouble()) <= n) {
                result.add((i * Math.pow(10.0, k.toDouble())).toInt())
                ++k
            }

            num = result.last() + 1
            while (num <= n && num % 10 != 0) {
                result.add(num)
                ++num
            }

            if (num % 10 == 0) {
                --num
            } else {
                num /= 10
            }

            while (num % 10 == 9) {
                num /= 10
            }

            i = num + 1
        }

        return result
    }
}
