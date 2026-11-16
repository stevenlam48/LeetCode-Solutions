package minimumrecolorstogetkconsecutiveblackblocks

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minimumRecolors(blocks: String, k: Int): Int {
        var result = k
        var curr = 0
        for (i in blocks.indices) {
            curr += if (blocks[i] == 'W') 1 else 0
            if (i + 1 - k < 0) {
                continue
            }
            result = minOf(result, curr)
            curr -= if (blocks[i + 1 - k] == 'W') 1 else 0
        }
        return result
    }
}
