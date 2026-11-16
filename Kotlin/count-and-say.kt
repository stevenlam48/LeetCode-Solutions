package countandsay

// Time:  O(n * 2^n)
// Space: O(2^n)

class Solution {
    fun countAndSay(n: Int): String {
        var seq = "1"
        for (i in 0 until n - 1) {
            seq = getNext(seq)
        }
        return seq
    }

    private fun getNext(seq: String): String {
        val nextSeq = StringBuilder()
        var i = 0
        while (i < seq.length) {
            var j = i
            while (j < seq.length && seq[j] == seq[i]) {
                ++j
            }
            nextSeq.append(j - i)
            nextSeq.append(seq[i])
            i = j
        }
        return nextSeq.toString()
    }
}
