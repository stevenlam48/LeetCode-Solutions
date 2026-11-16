package readncharactersgivenread4iicallmultipletimes
// Time:  O(n)
// Space: O(1)
class Solution(private val read4: (CharArray) -> Int) {
    private val buf4 = CharArray(4)
    private var i4 = 0
    private var n4 = 0

    fun read(buf: CharArray, n: Int): Int {
        var i = 0
        while (i < n) {
            if (i4 == n4) {
                i4 = 0
                n4 = read4(buf4)
                if (n4 == 0) {
                    break
                }
            }
            buf[i++] = buf4[i4++]
        }
        return i
    }
}
