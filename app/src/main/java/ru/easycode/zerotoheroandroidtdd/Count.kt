package ru.easycode.zerotoheroandroidtdd

interface Count {

    fun increment(number: String): UiState

    class Base(private val step: Int, private val max: Int) : Count {

        init {
            if (step <= 0) throw IllegalStateException("step should be positive, but was $step")
            if (max <= 0) throw IllegalStateException("max should be positive, but was $max")
            if (max < step) throw IllegalStateException("max should be more than step")
        }

        override fun increment(number: String): UiState {
            val intNumber = number.toInt()
            val sum = intNumber + step

            return when {
                sum + step <= max -> UiState.Base(sum.toString())
                else -> UiState.Max(sum.toString())
            }
        }
    }
}
