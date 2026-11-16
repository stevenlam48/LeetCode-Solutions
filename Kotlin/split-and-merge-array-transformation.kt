package splitandmergearraytransformation

// Time:  O(n^4 * n!)
// Space: O(n * n!)

class Solution {
    fun minSplitMerge(nums1: IntArray, nums2: IntArray): Int {
        fun join(vals: IntArray): String {
            val sb = StringBuilder()
            for (x in vals) {
                sb.append(x)
                sb.append(',')
            }
            return sb.toString()
        }

        var d = 0
        if (nums1.contentEquals(nums2)) {
            return d
        }
        val lookup = HashSet<String>()
        lookup.add(join(nums1))
        var q = mutableListOf(nums1)
        ++d
        while (q.isNotEmpty()) {
            val newQ = mutableListOf<IntArray>()
            for (u in q) {
                for (l in u.indices) {
                    for (r in l until u.size) {
                        val sub = u.copyOfRange(l, r + 1)
                        val rem = u.copyOfRange(0, l) + u.copyOfRange(r + 1, u.size)
                        for (i in 0..rem.size) {
                            if (i == l) {
                                continue
                            }
                            val v = rem.copyOfRange(0, i) + sub + rem.copyOfRange(i, rem.size)
                            val key = join(v)
                            if (key in lookup) {
                                continue
                            }
                            if (v.contentEquals(nums2)) {
                                return d
                            }
                            lookup.add(key)
                            newQ.add(v)
                        }
                    }
                }
            }
            q = newQ
            ++d
        }
        return -1
    }
}
