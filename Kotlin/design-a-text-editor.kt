package designatexteditor

// Time:  ctor:        O(1)
//        addText:     O(l)
//        deleteText:  O(k)
//        cursorLeft:  O(k)
//        cursorRight: O(k)
// Space: O(n)

class TextEditor {
    private val left = StringBuilder()
    private val right = StringBuilder()

    fun addText(text: String) {
        left.append(text)
    }

    fun deleteText(k: Int): Int {
        return move(k, left, null)
    }

    fun cursorLeft(k: Int): String {
        move(k, left, right)
        return lastCharacters()
    }

    fun cursorRight(k: Int): String {
        move(k, right, left)
        return lastCharacters()
    }

    private fun move(k: Int, src: StringBuilder, dst: StringBuilder?): Int {
        val cnt = minOf(k, src.length)
        repeat(cnt) {
            dst?.append(src[src.length - 1])
            src.deleteCharAt(src.length - 1)
        }
        return cnt
    }

    private fun lastCharacters(): String {
        return left.substring(maxOf(left.length - LAST_COUNT, 0), left.length)
    }

    companion object {
        private const val LAST_COUNT = 10
    }
}
