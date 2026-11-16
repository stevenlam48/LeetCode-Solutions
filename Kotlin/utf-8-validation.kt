package utf8validation

// Time:  O(n)
// Space: O(1)

class Solution {
    fun validUtf8(data: IntArray): Boolean {
        var count = 0
        for (c in data) {
            if (count == 0) {
                if ((c shr 5) == 0b110) {
                    count = 1
                } else if ((c shr 4) == 0b1110) {
                    count = 2
                } else if ((c shr 3) == 0b11110) {
                    count = 3
                } else if ((c shr 7) != 0) {
                    return false
                }
            } else {
                if ((c shr 6) != 0b10) {
                    return false
                }
                --count
            }
        }
        return count == 0
    }
}
