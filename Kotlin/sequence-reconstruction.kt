package sequencereconstruction

// Time:  O(n * s), n is the size of org, s is the size of seqs
// Space: O(n)

class Solution {
    fun sequenceReconstruction(org: IntArray, seqs: Array<IntArray>): Boolean {
        if (seqs.isEmpty()) {
            return false
        }
        val pos = IntArray(org.size + 1)
        for (i in org.indices) {
            pos[org[i]] = i
        }
        val isMatched = BooleanArray(org.size + 1)
        var cntToMatch = org.size - 1
        for (seq in seqs) {
            for (i in seq.indices) {
                if (seq[i] <= 0 || seq[i] > org.size) {
                    return false
                }
                if (i == 0) {
                    continue
                }
                if (pos[seq[i - 1]] >= pos[seq[i]]) {
                    return false
                }
                if (!isMatched[seq[i - 1]] && pos[seq[i - 1]] + 1 == pos[seq[i]]) {
                    isMatched[seq[i - 1]] = true
                    --cntToMatch
                }
            }
        }
        return cntToMatch == 0
    }
}
