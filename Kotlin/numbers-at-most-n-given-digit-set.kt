package numbersatmostngivendigitset

// Time:  O(logn)
// Space: O(logn)

class Solution {
    fun atMostNGivenDigitSet(D: List<String>, N: Int): Int {
        val strN = N.toString()
        val setD = D.toHashSet()
        var result = 0
        for (i in 1 until strN.length) {
            result += Math.pow(D.size.toDouble(), i.toDouble()).toInt()
        }
        var i = 0
        while (i < strN.length) {
            for (d in D) {
                if (d[0] < strN[i]) {
                    result += Math.pow(D.size.toDouble(), (strN.length - i - 1).toDouble()).toInt()
                } else {
                    break
                }
            }
            if (strN[i].toString() !in setD) {
                break
            }
            ++i
        }
        return result + if (i == strN.length) 1 else 0
    }
}
