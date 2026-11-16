package rotatingthebox

// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun rotateTheBox(box: Array<CharArray>): Array<CharArray> {
        val result = Array(box[0].size) { CharArray(box.size) { '.' } }
        for (i in box.indices) {
            var k = box[0].size - 1
            for (j in box[0].size - 1 downTo 0) {
                if (box[i][j] == '.') {
                    continue
                }
                if (box[i][j] == '*') {
                    k = j
                }
                result[k--][box.size - 1 - i] = box[i][j]
            }
        }
        return result
    }
}
