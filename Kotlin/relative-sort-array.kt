package relativesortarray
// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
        val lookup = HashMap<Int, Int>()
        for (i in arr2.indices) {
            lookup[arr2[i]] = i
        }
        val sorted = arr1.sortedWith(Comparator { a, b ->
            val i = if (lookup.containsKey(a)) lookup.getValue(a) else arr2.size + a
            val j = if (lookup.containsKey(b)) lookup.getValue(b) else arr2.size + b
            i.compareTo(j)
        })
        for (i in arr1.indices) {
            arr1[i] = sorted[i]
        }
        return arr1
    }
}
