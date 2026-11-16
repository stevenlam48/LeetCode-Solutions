package onlinemajorityelementinsubarray

// Time:  ctor:  O(n)
//        query: O(klogn), k = log2(Q/ERROR_RATE)
// Space: O(n)

class MajorityChecker(arr: IntArray) {
    private val arr = arr
    private val invIdx = HashMap<Int, MutableList<Int>>()
    private val gen = java.util.Random(0)

    init {
        for (i in arr.indices) {
            invIdx.getOrPut(arr[i]) { mutableListOf() }.add(i)
        }
    }

    fun query(left: Int, right: Int, threshold: Int): Int {
        for (i in 0 until K) {
            val m = arr[left + gen.nextInt(right - left + 1)]
            if (count(m, left, right) >= threshold) {
                return m
            }
        }
        return -1
    }

    private fun count(m: Int, left: Int, right: Int): Int {
        val list = invIdx[m] ?: return 0
        val l = lowerBound(list, left)
        val r = upperBound(list, right)
        return r - l
    }

    private fun lowerBound(list: List<Int>, target: Int): Int {
        var lo = 0
        var hi = list.size
        while (lo < hi) {
            val mid = (lo + hi) / 2
            if (list[mid] < target) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }
        return lo
    }

    private fun upperBound(list: List<Int>, target: Int): Int {
        var lo = 0
        var hi = list.size
        while (lo < hi) {
            val mid = (lo + hi) / 2
            if (list[mid] <= target) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }
        return lo
    }

    companion object {
        private const val Q = 10000
        private const val ERROR_RATE = 0.001
        private val K = (Math.log(Q / ERROR_RATE) / Math.log(2.0)).toInt() + 1
    }
}
