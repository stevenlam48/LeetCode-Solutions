package addingtwonegabinarynumbers

// Time:  O(n)
// Space: O(n)

class Solution {
    fun addNegabinary(arr1: IntArray, arr2: IntArray): IntArray {
        val result = mutableListOf<Int>()
        var carry = 0
        var i = arr1.size - 1
        var j = arr2.size - 1
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) {
                carry += arr1[i--]
            }
            if (j >= 0) {
                carry += arr2[j--]
            }
            result.add(carry and 1)
            carry = -(carry shr 1)
        }
        while (result.size > 1 && result.last() == 0) {
            result.removeAt(result.lastIndex)
        }
        result.reverse()
        return result.toIntArray()
    }
}
