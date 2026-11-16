package firstuniquenumber

// Time:  ctor: O(k)
//        add: O(1)
//        showFirstUnique: O(1)
// Space: O(n)

class FirstUnique(nums: IntArray) {
    private val unique = LinkedHashSet<Int>()
    private val dup = HashSet<Int>()

    init {
        for (num in nums) {
            add(num)
        }
    }

    fun showFirstUnique(): Int {
        return unique.firstOrNull() ?: -1
    }

    fun add(value: Int) {
        if (value !in dup && value !in unique) {
            unique.add(value)
            return
        }
        if (value in unique) {
            unique.remove(value)
            dup.add(value)
        }
    }
}
