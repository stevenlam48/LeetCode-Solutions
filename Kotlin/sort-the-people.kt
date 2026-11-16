package sortthepeople

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun sortPeople(names: Array<String>, heights: IntArray): Array<String> {
        val order = Array(names.size) { it }
        order.sortWith(Comparator { x, y -> heights[y].compareTo(heights[x]) })
        return Array(names.size) { i -> names[order[i]] }
    }
}
