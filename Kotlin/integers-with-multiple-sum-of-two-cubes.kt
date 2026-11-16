package integerswithmultiplesumoftwocubes
// Time:  O(n^(2/3) * logn)
// Space: O(n^(2/3))

class Solution {
    fun findGoodIntegers(n: Int): IntArray {
        val counts = HashMap<Int, Int>()
        var i = 1
        while (i * i * i <= n) {
            var j = i
            while (j * j * j <= n - i * i * i) {
                val sum = i * i * i + j * j * j
                counts[sum] = counts.getOrDefault(sum, 0) + 1
                ++j
            }
            ++i
        }
        return counts.filterValues { it >= 2 }.keys.sorted().toIntArray()
    }
}
