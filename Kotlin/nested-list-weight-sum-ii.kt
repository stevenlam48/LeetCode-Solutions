package nestedlistweightsumii
// Time:  O(n)
// Space: O(h)

class NestedInteger {
    private var value: Int? = null
    private var list: List<NestedInteger>? = null

    constructor(value: Int) {
        this.value = value
    }

    constructor(list: List<NestedInteger>) {
        this.list = list
    }

    fun isInteger(): Boolean = value != null

    fun getInteger(): Int = value!!

    fun getList(): List<NestedInteger> = list!!
}

class Solution {
    fun depthSumInverse(nestedList: List<NestedInteger>): Int {
        val result = mutableListOf<Int>()
        for (list in nestedList) {
            depthSumInverseHelper(list, 0, result)
        }
        var sum = 0
        for (i in result.indices.reversed()) {
            sum += result[i] * (result.size - i)
        }
        return sum
    }

    private fun depthSumInverseHelper(list: NestedInteger, depth: Int, result: MutableList<Int>) {
        if (result.size < depth + 1) {
            result.add(0)
        }
        if (list.isInteger()) {
            result[depth] += list.getInteger()
        } else {
            for (nested in list.getList()) {
                depthSumInverseHelper(nested, depth + 1, result)
            }
        }
    }
}
