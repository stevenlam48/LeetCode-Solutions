package intervalsbetweenidenticalelements

// Time:  O(n)
// Space: O(n)

class Solution {
    fun getDistances(arr: IntArray): LongArray {
        val lookup = HashMap<Int, MutableList<Long>>()
        for (i in arr.indices) {
            lookup.getOrPut(arr[i]) { mutableListOf() }.add(i.toLong())
        }
        val result = LongArray(arr.size)
        for ((_, idxs) in lookup) {
            val prefix = mutableListOf(0L)
            for (i in idxs) {
                prefix.add(prefix[prefix.size - 1] + i)
            }
            for (i in idxs.indices) {
                result[idxs[i].toInt()] = (idxs[i] * (i + 1) - prefix[i + 1]) +
                    ((prefix[idxs.size] - prefix[i]) - idxs[i] * (idxs.size - i))
            }
        }
        return result
    }
}
