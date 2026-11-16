package nestedlistweightsum
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
    fun depthSum(nestedList: List<NestedInteger>): Int {
        return depthSumHelper(nestedList, 1)
    }

    private fun depthSumHelper(nestedList: List<NestedInteger>, depth: Int): Int {
        var sum = 0
        for (list in nestedList) {
            if (list.isInteger()) {
                sum += list.getInteger() * depth
            } else {
                sum += depthSumHelper(list.getList(), depth + 1)
            }
        }
        return sum
    }
}
