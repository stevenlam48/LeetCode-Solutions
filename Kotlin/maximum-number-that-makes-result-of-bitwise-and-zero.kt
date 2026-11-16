package maximumnumberthatmakesresultofbitwiseandzero

// Time:  O(1)
// Space: O(1)

class Solution {
    fun maxNumber(n: Long): Long {
        val bitLength = 64 - java.lang.Long.numberOfLeadingZeros(n)
        return (1L shl (bitLength - 1)) - 1
    }
}
