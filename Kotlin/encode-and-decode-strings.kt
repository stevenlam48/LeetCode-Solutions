package encodeanddecodestrings
// Time:  O(n)
// Space: O(1)

class Codec {
    fun encode(strs: List<String>): String {
        val encoded = StringBuilder()
        for (str in strs) {
            val length = str.length.toLong()
            for (shift in 56 downTo 0 step 8) {
                encoded.append(((length ushr shift) and 0xffL).toInt().toChar())
            }
            encoded.append(str)
        }
        return encoded.toString()
    }

    fun decode(s: String): List<String> {
        val strs = mutableListOf<String>()
        var pos = 0
        while (pos + SIZE_T_BYTES <= s.length) {
            var length = 0L
            repeat(SIZE_T_BYTES) {
                length = (length shl 8) + s[pos++].code
            }
            strs.add(s.substring(pos, pos + length.toInt()))
            pos += length.toInt()
        }
        return strs
    }

    private companion object {
        const val SIZE_T_BYTES = 8
    }
}
