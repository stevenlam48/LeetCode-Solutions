package flippinganimage

// Time:  O(n^2)
// Space: O(1)

class Solution {
    fun flipAndInvertImage(A: Array<IntArray>): Array<IntArray> {
        for (row in A) {
            for (i in 0 until (row.size + 1) / 2) {
                val j = row.size - 1 - i
                row[i] = row[i] xor 1
                if (i != j) {
                    row[j] = row[j] xor 1
                    val temp = row[i]
                    row[i] = row[j]
                    row[j] = temp
                }
            }
        }
        return A
    }
}
