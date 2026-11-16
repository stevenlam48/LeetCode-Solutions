package lrucache

// Time:  O(1), per operation.
// Space: O(k), k is the capacity of cache.

class LRUCache(capacity: Int) {
    private val capa = capacity
    private val cache = object : LinkedHashMap<Int, Int>(capacity.coerceAtLeast(0), 0.75f, true) {
        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<Int, Int>?): Boolean {
            return size > capa
        }
    }

    fun get(key: Int): Int {
        return cache[key] ?: -1
    }

    fun put(key: Int, value: Int) {
        if (capa <= 0) {
            return
        }
        cache[key] = value
    }
}
