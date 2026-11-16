package checkiftwochessboardsquareshavethesamecolor

// Time:  O(1)
// Space: O(1)

class Solution {
    fun checkTwoChessboards(coordinate1: String, coordinate2: String): Boolean {
        fun parity(a: String): Int {
            var result = 0
            for (x in a) {
                result = (result + x.code) % 2
            }
            return result
        }

        return parity(coordinate1) == parity(coordinate2)
    }
}
