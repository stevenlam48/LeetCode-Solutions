package complexnumbermultiplication
// Time:  O(1)
// Space: O(1)

class Solution {
    fun complexNumberMultiply(a: String, b: String): String {
        fun parse(s: String): Pair<Int, Int> {
            val plus = s.lastIndexOf('+')
            return s.substring(0, plus).toInt() to s.substring(plus + 1, s.length - 1).toInt()
        }

        val (ra, ia) = parse(a)
        val (rb, ib) = parse(b)
        return "${ra * rb - ia * ib}+${ra * ib + rb * ia}i"
    }
}
