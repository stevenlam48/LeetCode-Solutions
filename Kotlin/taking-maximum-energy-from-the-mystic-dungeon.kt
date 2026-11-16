package takingmaximumenergyfromthemysticdungeon
// Time:  O(n)
// Space: O(1)

class Solution {
    fun maximumEnergy(energy: IntArray, k: Int): Int {
        var result = Int.MIN_VALUE
        for (i in 0 until k) {
            var curr = 0
            var j = energy.size - 1 - i
            while (j >= 0) {
                curr += energy[j]
                result = maxOf(result, curr)
                j -= k
            }
        }
        return result
    }
}
