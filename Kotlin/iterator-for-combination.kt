package iteratorforcombination

// Time:  O(k), per operation
// Space: O(k)

class CombinationIterator(characters: String, combinationLength: Int) {
    private val characters_ = characters
    private val combinationLength_ = combinationLength
    private val curr_ = StringBuilder()
    private val last_ = characters.substring(characters.length - combinationLength)
    private val stk_ = ArrayDeque<() -> Boolean>()

    init {
        stk_.addLast { divide(0) }
    }

    fun next(): String {
        iterativeBacktracking()
        return curr_.toString()
    }

    fun hasNext(): Boolean {
        return curr_.toString() != last_
    }

    private fun iterativeBacktracking() {
        while (stk_.isNotEmpty()) {
            val cb = stk_.removeLast()
            if (cb()) {
                return
            }
        }
    }

    private fun conquer(): Boolean {
        return curr_.length == combinationLength_
    }

    private fun prevDivide(c: Char): Boolean {
        curr_.append(c)
        return false
    }

    private fun divide(i: Int): Boolean {
        if (curr_.length != combinationLength_) {
            var j = characters_.length - (combinationLength_ - curr_.length - 1) - 1
            while (j >= i) {
                val jj = j
                stk_.addLast { postDivide() }
                stk_.addLast { divide(jj + 1) }
                stk_.addLast { prevDivide(characters_[jj]) }
                --j
            }
        }
        stk_.addLast { conquer() }
        return false
    }

    private fun postDivide(): Boolean {
        curr_.deleteAt(curr_.length - 1)
        return false
    }
}
