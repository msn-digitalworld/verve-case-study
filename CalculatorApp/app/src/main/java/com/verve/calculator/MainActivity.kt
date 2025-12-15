package com.verve.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var tvDisplay: TextView
    private lateinit var calculator: Calculator
    private lateinit var adManager: AdManager
    private lateinit var bannerAdContainer: FrameLayout

    // Number buttons
    private lateinit var btn0: Button
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button

    // Operation buttons
    private lateinit var btnAdd: Button
    private lateinit var btnSubtract: Button
    private lateinit var btnMultiply: Button
    private lateinit var btnDivide: Button
    private lateinit var btnEquals: Button
    private lateinit var btnClear: Button
    private lateinit var btnDelete: Button
    private lateinit var btnDecimal: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeViews()
        initializeCalculator()
        initializeAds()
        setupClickListeners()
    }

    private fun initializeViews() {
        tvDisplay = findViewById(R.id.tvDisplay)
        bannerAdContainer = findViewById(R.id.bannerAdContainer)

        // Number buttons
        btn0 = findViewById(R.id.btn0)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)

        // Operation buttons
        btnAdd = findViewById(R.id.btnAdd)
        btnSubtract = findViewById(R.id.btnSubtract)
        btnMultiply = findViewById(R.id.btnMultiply)
        btnDivide = findViewById(R.id.btnDivide)
        btnEquals = findViewById(R.id.btnEquals)
        btnClear = findViewById(R.id.btnClear)
        btnDelete = findViewById(R.id.btnDelete)
        btnDecimal = findViewById(R.id.btnDecimal)
    }

    private fun initializeCalculator() {
        calculator = Calculator()
    }

    private fun initializeAds() {
        adManager = AdManager(this)
        adManager.loadBannerAd(bannerAdContainer)
        adManager.loadInterstitialAd()
    }

    private fun setupClickListeners() {
        // Number buttons
        btn0.setOnClickListener { updateDisplay(calculator.inputNumber(0.0)) }
        btn1.setOnClickListener { updateDisplay(calculator.inputNumber(1.0)) }
        btn2.setOnClickListener { updateDisplay(calculator.inputNumber(2.0)) }
        btn3.setOnClickListener { updateDisplay(calculator.inputNumber(3.0)) }
        btn4.setOnClickListener { updateDisplay(calculator.inputNumber(4.0)) }
        btn5.setOnClickListener { updateDisplay(calculator.inputNumber(5.0)) }
        btn6.setOnClickListener { updateDisplay(calculator.inputNumber(6.0)) }
        btn7.setOnClickListener { updateDisplay(calculator.inputNumber(7.0)) }
        btn8.setOnClickListener { updateDisplay(calculator.inputNumber(8.0)) }
        btn9.setOnClickListener { updateDisplay(calculator.inputNumber(9.0)) }

        // Operation buttons
        btnAdd.setOnClickListener { updateDisplay(calculator.setOperation("+")) }
        btnSubtract.setOnClickListener { updateDisplay(calculator.setOperation("-")) }
        btnMultiply.setOnClickListener { updateDisplay(calculator.setOperation("×")) }
        btnDivide.setOnClickListener { updateDisplay(calculator.setOperation("÷")) }

        // Special buttons
        btnEquals.setOnClickListener {
            val result = calculator.calculate()
            updateDisplay(result)
            // Show interstitial ad after calculation completes
            if (calculator.hasCompletedCalculation()) {
                adManager.showInterstitialAd()
            }
        }

        btnClear.setOnClickListener { updateDisplay(calculator.clear()) }
        btnDelete.setOnClickListener { updateDisplay(calculator.delete()) }
        btnDecimal.setOnClickListener { updateDisplay(calculator.inputDecimal()) }
    }

    private fun updateDisplay(value: String) {
        tvDisplay.text = value
    }

    override fun onDestroy() {
        super.onDestroy()
        adManager.destroy()
    }
}

