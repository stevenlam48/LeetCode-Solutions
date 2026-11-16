package assignelementstogroupswithconstraints

// Time:  O(m + r * logn), m = len(groups), n = len(elements), r = max(groups)
// Space: O(r)

// hash table, number theory
class Solution {
    fun assignElements(groups: IntArray, elements: IntArray): IntArray {
        val mx = groups.max()
        val lookup = IntArray(mx) { -1 }
        for (i in elements.indices) {
            if (elements[i] > mx || lookup[elements[i] - 1] != -1) {
                continue
            }
            var x = elements[i]
            while (x <= mx) {
                if (lookup[x - 1] == -1) {
                    lookup[x - 1] = i
                }
                x += elements[i]
            }
        }
        val result = IntArray(groups.size)
        for (i in result.indices) {
            result[i] = lookup[groups[i] - 1]
        }
        return result
    }
}
