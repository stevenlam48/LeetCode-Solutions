package intersectionofthreesortedarrays
// Time:  O(n)
// Space: O(1)

class Solution {
    fun arraysIntersection(arr1: IntArray, arr2: IntArray, arr3: IntArray): IntArray {
        val result = mutableListOf<Int>()
        var i = 0
        var j = 0
        var k = 0
        while (i != arr1.size && j != arr2.size && k != arr3.size) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                result.add(arr1[i])
                ++i
                ++j
                ++k
            } else {
                val current = maxOf(arr1[i], arr2[j], arr3[k])
                while (i != arr1.size && arr1[i] < current) ++i
                while (j != arr2.size && arr2[j] < current) ++j
                while (k != arr3.size && arr3[k] < current) ++k
            }
        }
        return result.toIntArray()
    }
}
