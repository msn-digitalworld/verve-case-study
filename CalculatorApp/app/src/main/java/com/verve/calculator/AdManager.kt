package com.verve.calculator

import android.app.AlertDialog
import android.content.Context
import android.util.Log
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AdManager(private val context: Context) {
    private val APP_TOKEN = "dde3c298b47648459f8ada4a982fa92d"
    private val ZONE_ID = "1"
    private val TAG = "AdManager"

    private var sdkInitialized = false
    private var interstitialDialog: AlertDialog? = null

    init {
        // Don't initialize SDK - OMID dependency missing causes crashes
        // Show placeholders instead
        sdkInitialized = false
        Log.d(TAG, "Using placeholder ads - OMID dependency not available")
    }

    fun loadBannerAd(container: FrameLayout) {
        // Always show placeholder - SDK requires OMID which is not available
        Log.d(TAG, "Showing placeholder banner (SDK requires OMID dependency)")
        showPlaceholderBanner(container)
    }
    
    private fun showPlaceholderBanner(container: FrameLayout) {
        val placeholder = TextView(context).apply {
            text = "Banner Ad Placeholder\n(HyBid SDK Integration)"
            textSize = 14f
            gravity = Gravity.CENTER
            setBackgroundColor(0xFF4CAF50.toInt()) // Green background to make it visible
            setTextColor(0xFFFFFFFF.toInt()) // White text
            setPadding(16, 16, 16, 16)
            layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                height = (60 * context.resources.displayMetrics.density).toInt() // 60dp height
            }
        }
        container.removeAllViews()
        container.addView(placeholder)
        Log.d(TAG, "Placeholder banner displayed")
    }

    fun loadInterstitialAd() {
        // Placeholder - SDK requires OMID dependency
        Log.d(TAG, "Interstitial ad placeholder (SDK requires OMID)")
    }

    fun showInterstitialAd() {
        // Show placeholder interstitial dialog
        if (context is AppCompatActivity) {
            showPlaceholderInterstitial(context)
        } else {
            Log.d(TAG, "Interstitial ad would show here (SDK requires OMID dependency)")
        }
    }

    private fun showPlaceholderInterstitial(activity: AppCompatActivity) {
        try {
            // Create a full-screen view that looks like an interstitial ad
            val dialogView = FrameLayout(context).apply {
                layoutParams = FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT
                )
                setBackgroundColor(0xFF2196F3.toInt()) // Blue background like an ad
                
                // Close button (X) in top-right corner
                val closeButton = TextView(context).apply {
                    text = "✕"
                    textSize = 24f
                    gravity = Gravity.CENTER
                    setPadding(20, 20, 20, 20)
                    setTextColor(0xFFFFFFFF.toInt())
                    setBackgroundColor(0x66000000.toInt()) // Semi-transparent black
                    layoutParams = FrameLayout.LayoutParams(
                        FrameLayout.LayoutParams.WRAP_CONTENT,
                        FrameLayout.LayoutParams.WRAP_CONTENT,
                        Gravity.TOP or Gravity.END
                    ).apply {
                        setMargins(0, 20, 20, 0) // left, top, right, bottom
                    }
                }
                
                // Main ad content
                val adContent = TextView(context).apply {
                    text = "Interstitial Ad Placeholder\n\n" +
                            "HyBid SDK Integration\n\n" +
                            "This would display a full-screen\n" +
                            "interstitial ad after calculation.\n\n" +
                            "Tap ✕ to close"
                    textSize = 20f
                    gravity = Gravity.CENTER
                    setPadding(40, 40, 40, 40)
                    setTextColor(0xFFFFFFFF.toInt())
                    layoutParams = FrameLayout.LayoutParams(
                        FrameLayout.LayoutParams.MATCH_PARENT,
                        FrameLayout.LayoutParams.MATCH_PARENT
                    )
                }
                
                addView(adContent)
                addView(closeButton)
                
                // Close on click
                setOnClickListener {
                    interstitialDialog?.dismiss()
                }
                closeButton.setOnClickListener {
                    interstitialDialog?.dismiss()
                }
            }

            interstitialDialog = AlertDialog.Builder(context)
                .setView(dialogView)
                .setCancelable(true)
                .create().apply {
                    window?.setBackgroundDrawableResource(android.R.color.transparent)
                    window?.setLayout(
                        FrameLayout.LayoutParams.MATCH_PARENT,
                        FrameLayout.LayoutParams.MATCH_PARENT
                    )
                    show()
                }

            Log.d(TAG, "Placeholder interstitial ad displayed")
        } catch (e: Exception) {
            Log.e(TAG, "Error showing placeholder interstitial", e)
        }
    }

    fun destroy() {
        // Dismiss dialog if showing
        interstitialDialog?.dismiss()
        interstitialDialog = null
    }
}

