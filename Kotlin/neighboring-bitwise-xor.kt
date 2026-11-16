package neighboringbitwisexor
// Time:  O(n)
// Space: O(1)

class Solution {
    fun doesValidArrayExist(derived: IntArray): Boolean {
        return derived.fold(0) { total, x -> total xor x } == 0
    }
}
