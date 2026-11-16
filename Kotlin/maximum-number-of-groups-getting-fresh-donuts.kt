package maximumnumberofgroupsgettingfreshdonuts
// Time:  O((b/2) * (n/(b/2)+1)^(b/2))
// Space: O((n/(b/2)+1)^(b/2))

class Solution {
    fun maxHappyGroups(batchSize: Int, groups: IntArray): Int {
        val count = IntArray(batchSize)
        for (i in groups) {
            ++count[i % count.size]
        }
        var result = count[0]
        count[0] = 0
        for (i in 1..count.size / 2) {
            val pairCount = if (2 * i != count.size) {
                minOf(count[i], count[count.size - i])
            } else {
                count[i] / 2
            }
            result += pairCount
            count[i] -= pairCount
            count[count.size - i] -= pairCount
        }
        val newCount = HashMap<Int, Int>()
        for (i in count.indices) {
            if (count[i] != 0) {
                newCount[i] = count[i]
            }
        }
        var maxMask = 1
        for ((_, c) in newCount) {
            maxMask *= c + 1
        }
        val lookup = IntArray(maxMask)
        return result + memoization(batchSize, newCount, maxMask - 1, 0, lookup)
    }

    private fun memoization(
        batchSize: Int,
        count: HashMap<Int, Int>,
        mask: Int,
        remain: Int,
        lookup: IntArray
    ): Int {
        if (lookup[mask] == 0) {
            var aRemain = 0
            var curr = mask
            var basis = 1
            if (count.containsKey(remain)) {
                for ((i, c) in count) {
                    if (i == remain) {
                        break
                    }
                    basis *= c + 1
                    curr /= c + 1
                }
                aRemain = curr % (count.getValue(remain) + 1)
            }
            var result = 0
            if (aRemain != 0) {
                result = maxOf(
                    result,
                    (if (remain == 0) 1 else 0) + memoization(
                        batchSize, count, mask - basis, 0, lookup
                    )
                )
            } else {
                curr = mask
                basis = 1
                for ((i, c) in count) {
                    if (curr % (c + 1) != 0) {
                        result = maxOf(
                            result,
                            (if (remain == 0) 1 else 0) + memoization(
                                batchSize,
                                count,
                                mask - basis,
                                (remain - i + batchSize) % batchSize,
                                lookup
                            )
                        )
                    }
                    basis *= c + 1
                    curr /= c + 1
                }
            }
            lookup[mask] = result
        }
        return lookup[mask]
    }
}
