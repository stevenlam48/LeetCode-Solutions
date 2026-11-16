package findxorsumofallpairsbitwiseand
// Time:  O(n)
// Space: O(1)

class Solution {
    fun getXORSum(arr1: IntArray, arr2: IntArray): Int {
        var xor1 = 0
        var xor2 = 0
        for (x in arr1) {
            xor1 = xor1 xor x
        }
        for (x in arr2) {
            xor2 = xor2 xor x
        }
        return xor1 and xor2
    }
}
