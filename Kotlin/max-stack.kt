package maxstack

// Time:  push:    O(logn)
//        pop:     O(logn)
//        popMax:  O(logn)
//        top:     O(1)
//        peekMax: O(1)
// Space: O(n), n is the number of values in the current stack

import java.util.TreeMap

class MaxStack {
    private val idxToVal = TreeMap<Int, Int>(reverseOrder())
    private val valToIdxs = TreeMap<Int, MutableList<Int>>(reverseOrder())

    fun push(x: Int) {
        val idx = if (idxToVal.isEmpty()) 0 else idxToVal.firstKey() + 1
        idxToVal[idx] = x
        valToIdxs.getOrPut(x) { mutableListOf() }.add(idx)
    }

    fun pop(): Int {
        val value = idxToVal.firstEntry().value
        remove(value)
        return value
    }

    fun top(): Int {
        return idxToVal.firstEntry().value
    }

    fun peekMax(): Int {
        return valToIdxs.firstKey()
    }

    fun popMax(): Int {
        val value = valToIdxs.firstKey()
        remove(value)
        return value
    }

    private fun remove(value: Int) {
        val indices = valToIdxs[value]!!
        val idx = indices.removeAt(indices.lastIndex)
        if (indices.isEmpty()) {
            valToIdxs.remove(value)
        }
        idxToVal.remove(idx)
    }
}
