package findtheencryptedstring

// Time:  O(n)
// Space: O(1)
class Solution {
    fun getEncryptedString(s: String, k: Int): String {
        val rotated = s.toCharArray()
        val shift = k % s.length
        rotated.reverse(0, shift)
        rotated.reverse(shift, rotated.size)
        rotated.reverse()
        return String(rotated)
    }
}
