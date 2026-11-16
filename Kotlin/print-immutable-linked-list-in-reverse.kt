package printimmutablelinkedlistinreverse

// Time:  O(n)
// Space: O(sqrt(n))

open class ImmutableListNode(val value: Int, private val next: ImmutableListNode? = null) {
    open fun printValue() {
    }

    fun getNext(): ImmutableListNode? = next
}

class Solution {
    fun printLinkedListInReverse(head: ImmutableListNode?) {
        var count = 0
        var curr = head
        while (curr != null) {
            curr = curr.getNext()
            ++count
        }
        val bucketCount = Math.ceil(Math.sqrt(count.toDouble())).toInt()

        val buckets = ArrayList<ImmutableListNode>()
        count = 0
        curr = head
        while (curr != null) {
            if (count % bucketCount == 0) {
                buckets.add(curr)
            }
            curr = curr.getNext()
            ++count
        }

        for (i in buckets.indices.reversed()) {
            printNodes(buckets[i], bucketCount)
        }
    }

    private fun printNodes(head0: ImmutableListNode?, count: Int) {
        var head = head0
        val nodes = ArrayList<ImmutableListNode>()
        while (head != null && nodes.size != count) {
            nodes.add(head)
            head = head.getNext()
        }
        for (i in nodes.indices.reversed()) {
            nodes[i].printValue()
        }
    }
}
