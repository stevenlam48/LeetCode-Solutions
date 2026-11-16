package readncharactersgivenread4
// Time:  O(n)
// Space: O(1)
class Solution(private val read4: (CharArray) -> Int) {
    fun read(buf: CharArray, n: Int): Int {
        var readBytes = 0
        val buffer = CharArray(4)
        for (i in 0 until (n + 3) / 4) {
            val size = minOf(read4(buffer), n - readBytes)
            for (j in 0 until size) {
                buf[readBytes++] = buffer[j]
            }
        }
        return readBytes
    }
}
