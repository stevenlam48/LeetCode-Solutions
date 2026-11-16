package leastnumberofuniqueintegersafterkremovals
// Time:  O(n)
// Space: O(n)

class Solution {
    fun findLeastNumOfUniqueInts(arr: IntArray, k: Int): Int {
        var remaining = k
        val count = counter(arr)
        val countCount = counter(count)
        var result = count.size
        for (c in 1..arr.size) {
            val frequency = countCount[c] ?: continue
            if (remaining < c * frequency) {
                result -= remaining / c
                break
            }
            remaining -= c * frequency
            result -= frequency
        }
        return result
    }

    private fun counter(arr: IntArray): HashMap<Int, Int> {
        val result = HashMap<Int, Int>()
        for (i in arr) {
            result[i] = result.getOrDefault(i, 0) + 1
        }
        return result
    }

    private fun counter(count: Map<Int, Int>): HashMap<Int, Int> {
        val result = HashMap<Int, Int>()
        for ((_, i) in count) {
            result[i] = result.getOrDefault(i, 0) + 1
        }
        return result
    }
}
