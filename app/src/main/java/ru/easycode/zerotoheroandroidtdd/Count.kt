package ru.easycode.zerotoheroandroidtdd

interface Count {

    fun initial(number: String): UiState

    fun increment(number: String): UiState

    fun decrement(number: String): UiState

    class Base(val step: Int, val max: Int, val min: Int) : Count {

        init {
            if (step <= 0) throw IllegalStateException("step should be positive, but was $step")
            if (max < 0) throw IllegalStateException("max should be positive, but was $max")
            if (max <= step) throw IllegalStateException("max should be more than step")
            if (max <= min) throw IllegalStateException("max should be more than min")

        }

        override fun initial(number: String): UiState {
            return when {
                number.toInt() == min -> UiState.Min(number)
                number.toInt() == max -> UiState.Max(number)
                else -> UiState.Base(number)
            }
        }

        override fun increment(number: String): UiState {
            val intNumber = number.toInt()
            val sum = intNumber + step

            return if (sum + step > max)
                UiState.Max(sum.toString())
            else
                UiState.Base(sum.toString())
        }

        override fun decrement(number: String): UiState {
            val intNumber = number.toInt()
            val dif = intNumber - step

            return if (dif - step < min)
                UiState.Min(dif.toString())
            else
                UiState.Base(dif.toString())
        }

    }
}