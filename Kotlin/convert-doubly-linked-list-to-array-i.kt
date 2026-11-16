package convertdoublylinkedlisttoarrayi
// Time:  O(n)
// Space: O(1)

class Node(var `val`: Int) {
    var next: Node? = null
    var prev: Node? = null
}

class Solution {
    fun toArray(head: Node?): IntArray {
        val result = mutableListOf<Int>()
        var current = head
        while (current != null) {
            result.add(current.`val`)
            current = current.next
        }
        return result.toIntArray()
    }
}
