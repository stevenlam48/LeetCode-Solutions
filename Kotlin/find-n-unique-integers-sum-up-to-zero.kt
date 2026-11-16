package findnuniqueintegerssumuptozero

// Time:  O(n)
// Space: O(1)

class Solution {
    fun sumZero(n: Int): IntArray {
        val result = mutableListOf<Int>()
        for (i in -(n / 2)..(n / 2)) {
            if (i == 0 && n % 2 == 0) {
                continue
            }
            result.add(i)
        }
        return result.toIntArray()
    }
}
