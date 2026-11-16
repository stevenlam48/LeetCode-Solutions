package maximumnumberofsubsequencesafteroneinserting

// Time:  O(n)
// Space: O(1)

class Solution {
    fun numOfSubsequences(s: String): Long {
        var cntL = 0L
        var cntC = 0L
        var cntT = s.count { it == 'T' }.toLong()
        var mxCntLT = 0L
        var cntLCT = 0L
        var cntLC = 0L
        var cntCT = 0L
        for (x in s) {
            mxCntLT = maxOf(mxCntLT, cntL * cntT)
            when (x) {
                'L' -> ++cntL
                'C' -> {
                    ++cntC
                    cntLC += cntL
                }
                'T' -> {
                    --cntT
                    cntCT += cntC
                    cntLCT += cntLC
                }
            }
        }
        mxCntLT = maxOf(mxCntLT, cntL * cntT)
        return cntLCT + maxOf(cntCT, mxCntLT, cntLC)
    }
}
