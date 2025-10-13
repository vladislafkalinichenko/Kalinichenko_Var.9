package com.example.kalinichenko_var9
import kotlin.random.Random

object ZeroFinder {
    fun generateArray(size: Int, min: Int = -3, max: Int = 3, rng: Random = Random): IntArray {
        require(size >= 0) { "size must be non-negative" }
        return IntArray(size) { rng.nextInt(min, max + 1) }
    }
    fun findZeroIndices(arr: IntArray): IntArray {
        return arr.indices.filter { i -> arr[i] == 0 }.toIntArray()
    }
    fun formatArray(arr: IntArray): String = arr.joinToString(prefix = "[", postfix = "]")
}

