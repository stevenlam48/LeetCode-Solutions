package twosumiiidatastructuredesign

// Time:  O(n)
// Space: O(n)

class TwoSum {
    private val lookup = HashMap<Int, Int>()

    fun add(number: Int) {
        lookup[number] = (lookup[number] ?: 0) + 1
    }

    fun find(value: Int): Boolean {
        for ((key, count) in lookup) {
            val num = value - key
            if (lookup.containsKey(num) && (num != key || count > 1)) {
                return true
            }
        }
        return false
    }
}
