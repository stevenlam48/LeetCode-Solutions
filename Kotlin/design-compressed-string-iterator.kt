package designcompressedstringiterator

// Time:  O(1)
// Space: O(1)
class StringIterator(compressedString: String) {
    private val result = compressedString
    private var index = 0
    private var num = 0
    private var ch = ' '

    fun next(): Char {
        if (!hasNext()) {
            return ' '
        }
        if (num == 0) {
            ch = result[index++]
            while (index < result.length && result[index].isDigit()) {
                num = num * 10 + (result[index++] - '0')
            }
        }
        --num
        return ch
    }

    fun hasNext(): Boolean = index < result.length || num != 0
}
