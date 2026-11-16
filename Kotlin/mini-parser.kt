package miniparser

// Time:  O(n)
// Space: O(h)

class NestedInteger {
    private var value: Int? = null
    private val list = mutableListOf<NestedInteger>()

    constructor()

    constructor(value: Int) {
        this.value = value
    }

    fun isInteger(): Boolean = value != null

    fun getInteger(): Int = value!!

    fun setInteger(value: Int) {
        this.value = value
    }

    fun add(ni: NestedInteger) {
        list.add(ni)
    }

    fun getList(): List<NestedInteger> = list
}

class Solution {
    fun deserialize(s: String): NestedInteger {
        if (s.isEmpty()) {
            return NestedInteger()
        }
        if (s[0] != '[') {
            return NestedInteger(s.toInt())
        }
        val stk = ArrayDeque<NestedInteger>()
        var i = 0
        var j = 0
        while (j < s.length) {
            when (s[j]) {
                '[' -> {
                    stk.addLast(NestedInteger())
                    i = j + 1
                }
                ',', ']' -> {
                    if (s[j - 1].isDigit()) {
                        stk.last().add(NestedInteger(s.substring(i, j).toInt()))
                    }
                    if (s[j] == ']' && stk.size > 1) {
                        val cur = stk.removeLast()
                        stk.last().add(cur)
                    }
                    i = j + 1
                }
            }
            ++j
        }
        return stk.last()
    }
}
