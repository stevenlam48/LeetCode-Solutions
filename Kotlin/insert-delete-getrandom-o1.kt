package insertdeletegetrandomo1
// Time:  O(1)
// Space: O(n)

import java.util.Random

class RandomizedSet {
    private val values = mutableListOf<Int>()
    private val indices = HashMap<Int, Int>()
    private val random = Random()

    fun insert(`val`: Int): Boolean {
        if (indices.containsKey(`val`)) {
            return false
        }
        values.add(`val`)
        indices[`val`] = values.size - 1
        return true
    }

    fun remove(`val`: Int): Boolean {
        val index = indices[`val`] ?: return false
        val last = values.last()
        indices[last] = index
        values[index] = last
        indices.remove(`val`)
        values.removeAt(values.lastIndex)
        return true
    }

    fun getRandom(): Int = values[random.nextInt(values.size)]
}
