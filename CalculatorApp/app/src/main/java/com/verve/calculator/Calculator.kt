package com.verve.calculator

class Calculator {
    private var currentValue: Double = 0.0
    private var previousValue: Double = 0.0
    private var operation: String? = null
    private var shouldResetDisplay: Boolean = false
    private var isDecimalMode: Boolean = false
    private var decimalPlaces: Int = 0

    fun inputNumber(number: Double): String {
        if (shouldResetDisplay) {
            currentValue = number
            shouldResetDisplay = false
            isDecimalMode = false
            decimalPlaces = 0
        } else {
            if (isDecimalMode) {
                decimalPlaces++
                currentValue = currentValue + number / Math.pow(10.0, decimalPlaces.toDouble())
            } else {
                currentValue = currentValue * 10 + number
            }
        }
        return formatDisplay(currentValue)
    }

    fun inputDecimal(): String {
        if (shouldResetDisplay) {
            currentValue = 0.0
            shouldResetDisplay = false
        }
        if (!isDecimalMode) {
            isDecimalMode = true
            decimalPlaces = 0
        }
        return formatDisplay(currentValue)
    }

    fun setOperation(op: String): String {
        if (operation != null && !shouldResetDisplay) {
            calculate()
        }
        previousValue = currentValue
        operation = op
        shouldResetDisplay = true
        isDecimalMode = false
        decimalPlaces = 0
        return formatDisplay(currentValue)
    }

    fun calculate(): String {
        if (operation == null) return formatDisplay(currentValue)

        when (operation) {
            "+" -> currentValue = previousValue + currentValue
            "-" -> currentValue = previousValue - currentValue
            "×" -> currentValue = previousValue * currentValue
            "÷" -> {
                if (currentValue != 0.0) {
                    currentValue = previousValue / currentValue
                } else {
                    // Division by zero - return error
                    clear()
                    return "Error"
                }
            }
        }

        operation = null
        shouldResetDisplay = true
        return formatDisplay(currentValue)
    }

    fun clear(): String {
        currentValue = 0.0
        previousValue = 0.0
        operation = null
        shouldResetDisplay = false
        isDecimalMode = false
        decimalPlaces = 0
        return "0"
    }

    fun delete(): String {
        currentValue = (currentValue / 10).toInt().toDouble()
        return formatDisplay(currentValue)
    }

    fun hasCompletedCalculation(): Boolean {
        return shouldResetDisplay && operation == null && currentValue != 0.0
    }

    private fun formatDisplay(value: Double): String {
        return if (value % 1.0 == 0.0) {
            value.toInt().toString()
        } else {
            String.format("%.10f", value).trimEnd('0').trimEnd('.')
        }
    }
}

