package beautifularray

// Time:  O(n)
// Space: O(n)

class Solution {
    fun beautifulArray(N: Int): IntArray {
        var result = mutableListOf(1)
        while (result.size < N) {
            val tmp = ArrayList<Int>()
            for (i in result) {
                tmp.add(i * 2 - 1)
            }
            for (i in result) {
                tmp.add(i * 2)
            }
            result = tmp
        }
        val tmp = result
        result = ArrayList<Int>()
        for (i in tmp) {
            if (i <= N) {
                result.add(i)
            }
        }
        return result.toIntArray()
    }
}
