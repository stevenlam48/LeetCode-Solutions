package peekingiterator

// Time:  O(1) per peek(), next(), hasNext()
// Space: O(1)

open class Iterator(private val nums: IntArray) {
    private var index = 0

    open fun next(): Int {
        return nums[index++]
    }

    open fun hasNext(): Boolean {
        return index < nums.size
    }
}

class PeekingIterator(nums: IntArray) : Iterator(nums) {
    private var val_ = 0
    private var hasNextFlag: Boolean
    private var hasPeeked = false

    init {
        hasNextFlag = super.hasNext()
    }

    fun peek(): Int {
        if (!hasPeeked) {
            hasPeeked = true
            val_ = super.next()
        }
        return val_
    }

    override fun next(): Int {
        val_ = peek()
        hasPeeked = false
        hasNextFlag = super.hasNext()
        return val_
    }

    override fun hasNext(): Boolean {
        return hasNextFlag
    }
}
