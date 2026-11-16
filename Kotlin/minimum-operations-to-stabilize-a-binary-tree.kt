package minimumoperationstostabilizeabinarytree

// Time:  O(nlogn)
// Space: O(n)

import common.TreeNode
import kotlin.random.Random

private class Treap {
    private data class Node(
        var key: Int,
        var lazy: Int,
        var sum: Long,
        var l: Int,
        var r: Int,
        var size: Int,
        var pri: UInt
    )

    private val t = mutableListOf(Node(0, 0, 0L, 0, 0, 0, 0u))
    private val rng = Random(0x9E3779B9.toInt())

    fun make(v: Int): Int {
        t.add(Node(v, 0, v.toLong(), 0, 0, 1, rng.nextInt().toUInt()))
        return t.size - 1
    }

    fun sizeOf(x: Int): Int = t[x].size

    fun sumOf(x: Int): Long = t[x].sum

    fun apply(x: Int, d: Int) {
        if (x != 0) {
            t[x].key += d
            t[x].sum += d.toLong() * t[x].size
            t[x].lazy += d
        }
    }

    fun splitKey(x: Int, key: Int, id: Int): Pair<Int, Int> {
        if (x == 0) {
            return 0 to 0
        }
        push(x)
        if (t[x].key < key || (t[x].key == key && x < id)) {
            val (a, b) = splitKey(t[x].r, key, id)
            t[x].r = a
            pull(x)
            return x to b
        }
        val (a, b) = splitKey(t[x].l, key, id)
        t[x].l = b
        pull(x)
        return a to x
    }

    fun splitSize(x: Int, k: Int): Pair<Int, Int> {
        if (x == 0) {
            return 0 to 0
        }
        push(x)
        val ls = t[t[x].l].size
        if (k <= ls) {
            val (a, b) = splitSize(t[x].l, k)
            t[x].l = b
            pull(x)
            return a to x
        }
        val (a, b) = splitSize(t[x].r, k - ls - 1)
        t[x].r = a
        pull(x)
        return x to b
    }

    fun join(a: Int, b: Int): Int {
        if (a == 0 || b == 0) {
            return if (a != 0) a else b
        }
        if (t[a].pri > t[b].pri) {
            push(a)
            t[a].r = join(t[a].r, b)
            pull(a)
            return a
        }
        push(b)
        t[b].l = join(a, t[b].l)
        pull(b)
        return b
    }

    fun unite(a: Int, b: Int): Int {
        if (a == 0 || b == 0) {
            return if (a != 0) a else b
        }
        var first = a
        var second = b
        if (t[first].pri < t[second].pri) {
            first = second.also { second = first }
        }
        push(first)
        val (bl, br) = splitKey(second, t[first].key, first)
        t[first].l = unite(t[first].l, bl)
        t[first].r = unite(t[first].r, br)
        pull(first)
        return first
    }

    private fun push(x: Int) {
        if (t[x].lazy != 0) {
            apply(t[x].l, t[x].lazy)
            apply(t[x].r, t[x].lazy)
            t[x].lazy = 0
        }
    }

    private fun pull(x: Int) {
        t[x].size = 1 + t[t[x].l].size + t[t[x].r].size
        t[x].sum = t[x].key + t[t[x].l].sum + t[t[x].r].sum
    }
}

class Solution {
    fun stabilizeBinaryTree(root: TreeNode?): Long {
        data class State(var treap: Int = 0, var cost: Long = 0L)

        val tr = Treap()

        fun widen(state: State) {
            val k = tr.sizeOf(state.treap) / 2
            val (left, right) = tr.splitSize(state.treap, k)
            tr.apply(left, -1)
            tr.apply(right, 1)
            state.treap = tr.join(left, right)
            state.cost -= k
        }

        fun merge(u: State, v: State): State {
            u.treap = tr.unite(u.treap, v.treap)
            u.cost += v.cost
            return u
        }

        fun minValue(state: State): Long {
            val (left, right) = tr.splitSize(state.treap, tr.sizeOf(state.treap) / 2)
            return state.cost + (tr.sumOf(right) - tr.sumOf(left)) / 2
        }

        val stk = ArrayDeque<Pair<TreeNode, Boolean>>()
        stk.addLast(root!! to false)
        val dp = ArrayDeque<State>()
        while (stk.isNotEmpty()) {
            val (node, visited) = stk.removeLast()
            val children = listOfNotNull(node.left, node.right)
            if (!visited) {
                stk.addLast(node to true)
                for (x in children.asReversed()) {
                    stk.addLast(x to false)
                }
                continue
            }
            var state = State(tr.join(tr.make(node.`val`), tr.make(node.`val`)), 0L)
            for (ignored in children.asReversed()) {
                val child = dp.removeLast()
                widen(child)
                state = merge(state, child)
            }
            dp.addLast(state)
        }
        return minValue(dp.last())
    }
}
