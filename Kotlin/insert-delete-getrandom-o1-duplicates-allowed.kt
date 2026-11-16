package insertdeletegetrandomo1duplicatesallowed
// Time:  O(1)
// Space: O(n)

import java.util.Random

class RandomizedCollection {
    private val values = mutableListOf<Pair<Int, Int>>()
    private val indices = HashMap<Int, MutableList<Int>>()
    private val random = Random()

    fun insert(`val`: Int): Boolean {
        val has = indices.containsKey(`val`)
        val positions = indices.getOrPut(`val`) { mutableListOf() }
        values.add(Pair(`val`, positions.size))
        positions.add(values.size - 1)
        return !has
    }

    fun remove(`val`: Int): Boolean {
        val positions = indices[`val`] ?: return false
        val index = positions.last()
        val last = values.last()
        indices.getValue(last.first)[last.second] = index
        values[index] = last
        positions.removeAt(positions.lastIndex)
        if (positions.isEmpty()) {
            indices.remove(`val`)
        }
        values.removeAt(values.lastIndex)
        return true
    }

    fun getRandom(): Int = values[random.nextInt(values.size)].first
}
