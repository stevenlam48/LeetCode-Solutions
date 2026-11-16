package convertdoublylinkedlisttoarrayii
// Time:  O(n)
// Space: O(1)

class Node(var `val`: Int) {
    var next: Node? = null
    var prev: Node? = null
}

class Solution {
    fun toArray(node: Node): IntArray {
        var current = node
        while (current.prev != null) {
            current = current.prev!!
        }
        val result = mutableListOf<Int>()
        var head: Node? = current
        while (head != null) {
            result.add(head.`val`)
            head = head.next
        }
        return result.toIntArray()
    }
}
