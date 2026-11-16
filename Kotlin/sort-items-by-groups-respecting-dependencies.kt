package sortitemsbygroupsrespectingdependencies

// Time:  O(n + e)
// Space: O(n + e)

class Solution {
    fun sortItems(n: Int, m: Int, groupId: IntArray, beforeItems: Array<IntArray>): IntArray {
        var groupCount = m
        for (i in 0 until n) {
            if (groupId[i] == -1) {
                groupId[i] = groupCount++
            }
        }
        val globalGroup = Topo()
        for (i in 0 until groupCount) {
            globalGroup.addNode(i)
        }
        val localGroups = HashMap<Int, Topo>()
        for (i in 0 until n) {
            localGroups.getOrPut(groupId[i]) { Topo() }.addNode(i)
        }
        for (i in 0 until n) {
            for (j in beforeItems[i]) {
                if (groupId[i] == groupId[j]) {
                    localGroups.getValue(groupId[i]).addEdge(j, i)
                } else {
                    globalGroup.addEdge(groupId[j], groupId[i])
                }
            }
        }
        val result = ArrayList<Int>()
        val globalOrder = globalGroup.sort() ?: return IntArray(0)
        for (i in globalOrder) {
            val localOrder = localGroups.getOrPut(i) { Topo() }.sort() ?: return IntArray(0)
            for (x in localOrder) {
                result.add(x)
            }
        }
        return result.toIntArray()
    }

    private class Topo {
        private val nodes = mutableSetOf<Int>()
        private val inDegree = HashMap<Int, MutableSet<Int>>()
        private val outDegree = HashMap<Int, MutableSet<Int>>()

        fun addNode(node: Int) {
            nodes.add(node)
        }

        fun addEdge(from: Int, to: Int) {
            addNode(from)
            addNode(to)
            inDegree.getOrPut(to) { mutableSetOf() }.add(from)
            outDegree.getOrPut(from) { mutableSetOf() }.add(to)
        }

        fun sort(): IntArray? {
            val queue = ArrayDeque<Int>()
            val result = ArrayList<Int>()
            for (node in nodes) {
                if (!inDegree.containsKey(node)) {
                    queue.addLast(node)
                }
            }
            while (queue.isNotEmpty()) {
                val node = queue.removeFirst()
                result.add(node)
                for (neighbor in outDegree.getOrPut(node) { mutableSetOf() }) {
                    inDegree.getValue(neighbor).remove(node)
                    if (inDegree.getValue(neighbor).isEmpty()) {
                        inDegree.remove(neighbor)
                        queue.addLast(neighbor)
                    }
                }
            }
            if (result.size < nodes.size) {
                return null
            }
            return result.toIntArray()
        }
    }
}
