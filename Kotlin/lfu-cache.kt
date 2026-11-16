package lfucache

// Time:  O(1), per operation
// Space: O(k), k is the capacity of cache

class LFUCache(private val capacity: Int) {
    private class Node(val key: Int, val value: Int, val freq: Int)

    private var size = 0
    private var minFreq = Int.MAX_VALUE
    private val freqToNodes = HashMap<Int, LinkedHashSet<Node>>()
    private val keyToNode = HashMap<Int, Node>()

    fun get(key: Int): Int {
        val node = keyToNode[key] ?: return -1
        update(key, node.value)
        return node.value
    }

    fun put(key: Int, value: Int) {
        if (capacity <= 0) {
            return
        }
        if (!keyToNode.containsKey(key) && size == capacity) {
            val nodes = freqToNodes.getValue(minFreq)
            val node = nodes.first()
            keyToNode.remove(node.key)
            nodes.remove(node)
            if (nodes.isEmpty()) {
                freqToNodes.remove(minFreq)
            }
            --size
        }
        update(key, value)
    }

    private fun update(key: Int, value: Int) {
        var freq = 0
        keyToNode[key]?.let { oldNode ->
            freq = oldNode.freq
            val nodes = freqToNodes.getValue(freq)
            nodes.remove(oldNode)
            if (nodes.isEmpty()) {
                freqToNodes.remove(freq)
                if (minFreq == freq) {
                    ++minFreq
                }
            }
            --size
        }
        minFreq = minOf(minFreq, ++freq)
        val node = Node(key, value, freq)
        freqToNodes.getOrPut(freq) { LinkedHashSet() }.add(node)
        keyToNode[key] = node
        ++size
    }
}
