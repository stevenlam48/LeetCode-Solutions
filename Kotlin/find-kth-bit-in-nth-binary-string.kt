package findkthbitinnthbinarystring
// Time:  O(n)
// Space: O(1)

class Solution {
    fun findKthBit(n: Int, k: Int): Char {
        var flip = 0
        var position = k
        var length = (1 shl n) - 1
        while (position > 1) {
            if (position == length / 2 + 1) {
                flip = flip xor 1
                break
            }
            if (position > length / 2) {
                position = length + 1 - position
                flip = flip xor 1
            }
            length /= 2
        }
        return ('0'.code + flip).toChar()
    }
}
