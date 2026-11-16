package guessthemajorityinahiddenarray

// Time:  O(n), n queries
// Space: O(1)

interface ArrayReader {
    fun length(): Int
    fun query(a: Int, b: Int, c: Int, d: Int): Int
}

class Solution {
    fun guessMajority(reader: ArrayReader): Int {
        var countA = 1
        var countB = 0
        var idxB = -1
        val value0123 = reader.query(0, 1, 2, 3)
        var value012I = -1
        for (i in reader.length() - 1 downTo 4) {
            value012I = reader.query(0, 1, 2, i)
            if (value012I == value0123) {
                ++countA
            } else {
                ++countB
                idxB = i
            }
        }
        val value0124 = value012I
        for (i in 0..2) {
            val aB = ArrayList<Int>()
            for (j in 0..2) {
                if (j == i) {
                    continue
                }
                aB.add(j)
            }
            val valueAB34 = reader.query(aB[0], aB[1], 3, 4)
            if (valueAB34 == value0124) {
                ++countA
            } else {
                ++countB
                idxB = i
            }
        }
        if (countA == countB) {
            return -1
        }
        return if (countA > countB) 3 else idxB
    }
}
