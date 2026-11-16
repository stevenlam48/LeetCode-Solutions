package flattennestedlistiterator

// Time:  O(n), n is the number of the integers.
// Space: O(h), h is the depth of the nested lists.

class NestedInteger {
    private var integer: Int? = null
    private var list: MutableList<NestedInteger>? = null

    constructor()

    constructor(value: Int) {
        integer = value
    }

    fun isInteger(): Boolean {
        return integer != null
    }

    fun getInteger(): Int {
        return integer!!
    }

    fun getList(): MutableList<NestedInteger> {
        if (list == null) {
            list = mutableListOf()
        }
        return list!!
    }

    fun add(elem: NestedInteger) {
        getList().add(elem)
    }
}

class NestedIterator(nestedList: List<NestedInteger>) {
    private class Frame(val list: List<NestedInteger>, var idx: Int = 0)

    private val depth = ArrayDeque<Frame>()

    init {
        depth.addLast(Frame(nestedList))
    }

    fun next(): Int {
        val cur = depth.last()
        return cur.list[cur.idx++].getInteger()
    }

    fun hasNext(): Boolean {
        while (depth.isNotEmpty()) {
            val cur = depth.last()
            if (cur.idx == cur.list.size) {
                depth.removeLast()
            } else if (cur.list[cur.idx].isInteger()) {
                return true
            } else {
                val nestedList = cur.list[cur.idx++].getList()
                depth.addLast(Frame(nestedList))
            }
        }
        return false
    }
}
