package designlinkedlist

// Time:  O(n)
// Space: O(n)
private class Node(val value: Int) {
    lateinit var next: Node
    lateinit var prev: Node
}

class MyLinkedList {
    private val head = Node(-1)
    private val tail = head
    private var size = 0

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(index: Int): Int {
        if (index >= 0 && index <= size / 2) {
            return forward(0, index, head.next).value
        } else if (index > size / 2 && index < size) {
            return backward(size, index, tail).value
        }
        return -1
    }

    fun addAtHead(value: Int) {
        add(head, value)
    }

    fun addAtTail(value: Int) {
        add(tail.prev, value)
    }

    fun addAtIndex(index: Int, value: Int) {
        if (index >= 0 && index <= size / 2) {
            add(forward(0, index, head.next).prev, value)
        } else if (index > size / 2 && index <= size) {
            add(backward(size, index, tail).prev, value)
        }
    }

    fun deleteAtIndex(index: Int) {
        if (index >= 0 && index <= size / 2) {
            remove(forward(0, index, head.next))
        } else if (index > size / 2 && index < size) {
            remove(backward(size, index, tail))
        }
    }

    private fun add(preNode: Node, value: Int) {
        val node = Node(value)
        node.prev = preNode
        node.next = preNode.next
        node.prev.next = node
        node.next.prev = node
        ++size
    }

    private fun remove(node: Node) {
        node.prev.next = node.next
        node.next.prev = node.prev
        --size
    }

    private fun forward(start: Int, end: Int, current: Node): Node {
        var i = start
        var result = current
        while (i != end) {
            ++i
            result = result.next
        }
        return result
    }

    private fun backward(start: Int, end: Int, current: Node): Node {
        var i = start
        var result = current
        while (i != end) {
            --i
            result = result.prev
        }
        return result
    }
}
