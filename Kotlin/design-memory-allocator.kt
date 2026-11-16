package designmemoryallocator

// Time:  ctor:     O(1)
//        allocate: O(logn)
//        free:     O(logn)
// Space: O(n)
import java.util.TreeMap

class Allocator(n: Int) {
    private val available = TreeMap<Int, Int>()
    private val lookup = HashMap<Int, MutableList<Pair<Int, Int>>>()

    init {
        available[0] = n
    }

    fun allocate(size: Int, mID: Int): Int {
        for ((location, availableSize) in available) {
            if (availableSize < size) {
                continue
            }
            available.remove(location)
            lookup.getOrPut(mID) { mutableListOf() }.add(location to size)
            if (availableSize - size > 0) {
                available[location + size] = availableSize - size
            }
            return location
        }
        return -1
    }

    fun free(mID: Int): Int {
        val allocations = lookup[mID] ?: return 0
        var result = 0
        for ((location, size) in allocations) {
            available[location] = size
            val next = available.higherEntry(location)
            if (next != null && location + available.getValue(location) == next.key) {
                available[location] = available.getValue(location) + next.value
                available.remove(next.key)
            }
            val previous = available.lowerEntry(location)
            if (previous != null && previous.key + previous.value == location) {
                available[previous.key] = previous.value + available.getValue(location)
                available.remove(location)
            }
            result += size
        }
        lookup.remove(mID)
        return result
    }
}
