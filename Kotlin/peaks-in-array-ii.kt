package peaksinarrayii

// Time:  O(nlogn + qlogn)
// Space: O(n)

private class BIT(n: Int) {
    private val bit = LongArray(n + 1)

    fun add(i: Int, value: Long) {
        var idx = i + 1
        while (idx < bit.size) {
            bit[idx] += value
            idx += lowerBit(idx)
        }
    }

    fun query(i: Int): Long {
        var idx = i + 1
        var total = 0L
        while (idx > 0) {
            total += bit[idx]
            idx -= lowerBit(idx)
        }
        return total
    }

    fun kthElement(k: Long): Int {
        if (k <= 0) {
            return -1
        }
        var total = 0L
        var pos = 0
        for (i in floorLog2X(bit.size - 1) downTo 0) {
            if (pos + (1 shl i) < bit.size && !(total + bit[pos + (1 shl i)] >= k)) {
                total += bit[pos + (1 shl i)]
                pos += (1 shl i)
            }
        }
        return (pos + 1) - 1
    }

    private fun lowerBit(i: Int): Int {
        return i and -i
    }

    private fun floorLog2X(x: Int): Int {
        return 31 - Integer.numberOfLeadingZeros(x)
    }
}

class Solution {
    fun countOfPeaks(nums: IntArray, queries: Array<IntArray>): List<Long> {
        fun count(x: Long): Long {
            return x * (x - 1) / 2
        }

        val bit = BIT(nums.size)
        val bit2 = BIT(nums.size)
        val lookup = IntArray(nums.size)

        fun update(i: Int) {
            if (!(0 < i && i < nums.size - 1)) {
                return
            }
            val x = if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) 1 else 0
            if (lookup[i] == x) {
                return
            }
            val d = (x - lookup[i]).toLong()
            lookup[i] = x
            bit.add(i, d)
            val j = bit.kthElement(bit.query(i - 1))
            if (j >= 0) {
                bit2.add(j, d * count((i - j).toLong()))
            }
            val k = bit.kthElement(bit.query(i) + 1)
            if (k < nums.size) {
                bit2.add(i, d * count((k - i).toLong()))
            }
            if (j >= 0 && k < nums.size) {
                bit2.add(j, -d * count((k - j).toLong()))
            }
        }

        var prev = -1
        for (i in 1 until nums.size - 1) {
            if (!(nums[i - 1] < nums[i] && nums[i] > nums[i + 1])) {
                continue
            }
            lookup[i] = 1
            bit.add(i, 1L)
            if (prev >= 0) {
                bit2.add(prev, count((i - prev).toLong()))
            }
            prev = i
        }
        val result = mutableListOf<Long>()
        for (q in queries) {
            if (q[0] == 1) {
                val l = q[1]
                val r = q[2]
                val base = bit.query(l)
                val cnt = bit.query(r - 1) - base
                if (cnt == 0L) {
                    result.add(0L)
                    continue
                }
                val left = bit.kthElement(base + 1)
                val right = bit.kthElement(base + cnt)
                result.add(
                    count((r - l).toLong()) -
                        (count((left - l).toLong()) +
                            (bit2.query(right - 1) - bit2.query(left - 1)) +
                            count((r - right).toLong()))
                )
            } else {
                nums[q[1]] = q[2]
                for (i in q[1] - 1..q[1] + 1) {
                    update(i)
                }
            }
        }
        return result
    }
}
