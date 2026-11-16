package minimumoperationstomakexorofallelementszero

// Time:  O(n + r * d), r = max(nums), d = len(set(nums))
// Space: O(r + d)

// bi-bfs
class Solution {
    fun minOperations(nums: IntArray): Int {
        var total = 0
        for (x in nums) {
            total = total xor x
        }
        if (total == 0) {
            return 0
        }
        val numsSet = nums.toHashSet()
        if (numsSet.size == 1) {
            return -1
        }

        fun biBfs(start: Int, target: Int): Int {
            var left = hashSetOf(start)
            var right = hashSetOf(target)
            val lookup = HashSet<Int>()
            var steps = 0
            while (left.isNotEmpty()) {
                if (left.size > right.size) {
                    val tmp = left
                    left = right
                    right = tmp
                }
                for (x in left) {
                    lookup.add(x)
                }
                val newLeft = HashSet<Int>()
                for (x in left) {
                    if (x in right) {
                        return steps
                    }
                    for (v in numsSet) {
                        val nx = x xor v
                        if (nx in lookup) {
                            continue
                        }
                        newLeft.add(nx)
                    }
                }
                left = newLeft
                ++steps
            }
            return -1
        }

        val steps = biBfs(0, total)
        return if (steps != nums.size) steps else -1
    }
}
