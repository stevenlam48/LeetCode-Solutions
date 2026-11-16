package designhashset

// Time:  O(1)
// Space: O(n)
class MyHashSet {
    private val data = Array(10000) { mutableListOf<Int>() }

    fun add(key: Int) {
        val entries = data[key % data.size]
        if (!entries.contains(key)) {
            entries.add(key)
        }
    }

    fun remove(key: Int) {
        data[key % data.size].remove(key)
    }

    fun contains(key: Int): Boolean = data[key % data.size].contains(key)
}
