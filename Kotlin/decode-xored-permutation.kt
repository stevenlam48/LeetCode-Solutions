package decodexoredpermutation

// Time:  O(n)
// Space: O(1)

class Solution {
    fun decode(encoded: IntArray): IntArray {
        var curr = 0
        for (i in 1..encoded.size + 1) {
            curr = curr xor i
            if (i < encoded.size && i % 2 == 1) {
                curr = curr xor encoded[i]
            }
        }
        val result = IntArray(encoded.size + 1)
        result[0] = curr
        for (i in encoded.indices) {
            result[i + 1] = result[i] xor encoded[i]
        }
        return result
    }
}
