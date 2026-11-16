package designhashmap

// Time:  O(1)
// Space: O(n)
class MyHashMap {
    private val data = Array(10000) { mutableListOf<Pair<Int, Int>>() }

    fun put(key: Int, value: Int) {
        val entries = data[key % data.size]
        val index = entries.indexOfFirst { it.first == key }
        if (index != -1) {
            entries[index] = key to value
        } else {
            entries.add(key to value)
        }
    }

    fun get(key: Int): Int {
        val entries = data[key % data.size]
        val index = entries.indexOfFirst { it.first == key }
        return if (index != -1) entries[index].second else -1
    }

    fun remove(key: Int) {
        val entries = data[key % data.size]
        val index = entries.indexOfFirst { it.first == key }
        if (index != -1) {
            entries.removeAt(index)
        }
    }
}
