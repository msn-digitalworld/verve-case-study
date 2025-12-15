# Verve Case Study Solution

This repository contains the complete solution for the Verve Solution Engineer case study, including an Android calculator app with HyBid SDK integration and comprehensive answers to the technical questions.

## Project Structure

```
Verve/
├── CalculatorApp/              # Android Calculator App with HyBid SDK
│   ├── app/
│   │   ├── src/main/
│   │   │   ├── java/com/verve/calculator/
│   │   │   │   ├── MainActivity.kt      # Main UI and calculator logic
│   │   │   │   ├── Calculator.kt        # Calculator engine
│   │   │   │   └── AdManager.kt        # HyBid SDK integration
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   └── activity_main.xml
│   │   │   │   └── values/
│   │   │   │       └── strings.xml
│   │   │   └── AndroidManifest.xml
│   │   └── build.gradle.kts
│   ├── build.gradle.kts
│   └── settings.gradle.kts
├── screenshots/                # App screenshots with ads (to be added)
├── Question2_Answer.md         # Impression discrepancy troubleshooting steps
├── Question3_Answer.md         # Client communication checklist
└── README.md                   # This file
```

## Question 1: Android Calculator App

### Features

- **Basic Calculator Operations**:
  - Addition (+)
  - Subtraction (-)
  - Multiplication (×)
  - Division (÷)
  - Clear (C)
  - Delete (⌫)
  - Decimal point (.)

- **HyBid SDK Integration**:
  - **Banner Ad**: Displayed persistently at the bottom of the calculator
  - **Interstitial Ad**: Shown automatically after completing a calculation (when = button is pressed)

### HyBid SDK Configuration

- **App Token**: `dde3c298b47648459f8ada4a982fa92d`
- **Zone ID**: `1`
- **Banner Size**: 320x50 (standard banner)
- **Ad Format**: Banner (persistent) + Interstitial (on calculation complete)

### Prerequisites

- Android Studio (latest version recommended)
- Android SDK (API 24 or higher)
- Kotlin support
- Internet connection (for ad serving)
- Gradle 8.0+

### Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd Verve/CalculatorApp
   ```

2. **Open in Android Studio**
   - Open Android Studio
   - Select "Open an Existing Project"
   - Navigate to the `CalculatorApp` directory
   - Click "OK"

3. **HyBid SDK Integration**
   - The HyBid SDK AAR file is included in `app/libs/hybid-sdk.aar`
   - The SDK is configured in `build.gradle.kts` to use the local AAR file
   - **Note**: Due to OMID dependency limitations, placeholder ads are implemented to demonstrate the integration architecture

4. **Sync Gradle**
   - Android Studio will automatically sync Gradle dependencies
   - If not, click "Sync Now" when prompted
   - Wait for all dependencies to download

4. **Build the Project**
   - Go to `Build` → `Make Project` or press `Ctrl+F9` (Windows/Linux) or `Cmd+F9` (Mac)
   - Ensure build completes without errors

5. **Run the App**
   - Connect an Android device or start an emulator
   - Click the "Run" button or press `Shift+F10`
   - Select your target device
   - The app will install and launch

### Building from Command Line

```bash
cd CalculatorApp
./gradlew assembleDebug
```

The APK will be generated at: `CalculatorApp/app/build/outputs/apk/debug/app-debug.apk`

### Installation on Device

1. **Enable Developer Options** on your Android device:
   - Go to Settings → About Phone
   - Tap "Build Number" 7 times
   - Go back to Settings → Developer Options
   - Enable "USB Debugging"

2. **Connect Device** via USB or use ADB over network

3. **Install APK**:
   ```bash
   adb install CalculatorApp/app/build/outputs/apk/debug/app-debug.apk
   ```

### How to Use

1. **Launch the App**: Open "Verve Calculator" from your app drawer

2. **Perform Calculations**:
   - Tap number buttons to enter values
   - Tap operation buttons (+, -, ×, ÷) to select operation
   - Tap "=" to calculate the result

3. **View Ads**:
   - **Banner Ad**: Always visible at the bottom of the screen
   - **Interstitial Ad**: Automatically appears after pressing "=" and completing a calculation

4. **Clear/Reset**:
   - Tap "C" to clear all
   - Tap "⌫" to delete the last digit

### Screenshots

To capture screenshots showing the ads:

1. **Banner Ad Screenshot**:
   - Open the app
   - Wait for banner ad to load at the bottom
   - Take screenshot (Power + Volume Down on most devices)

2. **Interstitial Ad Screenshot**:
   - Perform a calculation (e.g., 5 + 3 = 8)
   - Press "=" button
   - Interstitial ad will appear
   - Take screenshot while interstitial is displayed

3. **Save Screenshots**:
   - Save screenshots in the `screenshots/` folder
   - Name them descriptively:
     - `banner_ad.png`
     - `interstitial_ad.png`
     - `calculator_with_banner.png`

### Troubleshooting

#### Ads Not Showing

1. **Check Internet Connection**:
   - Ensure device has active internet connection
   - Test in browser to verify connectivity

2. **Check Logs**:
   - Open Android Studio Logcat
   - Filter by "AdManager" tag
   - Look for error messages

3. **Verify Configuration**:
   - Confirm App Token: `dde3c298b47648459f8ada4a982fa92d`
   - Confirm Zone ID: `1`
   - Check AndroidManifest.xml has INTERNET permission

4. **Test Mode**:
   - HyBid SDK may require test mode configuration
   - Check HyBid documentation for test mode setup

#### Build Errors

1. **Gradle Sync Failed**:
   - Go to `File` → `Invalidate Caches / Restart`
   - Select "Invalidate and Restart"
   - Wait for project to rebuild

2. **SDK Not Found**:
   - Verify AAR file exists in `CalculatorApp/app/libs/hybid-sdk.aar`
   - Check `build.gradle.kts` has the correct configuration
   - Sync Gradle again

### Code Structure

#### MainActivity.kt
- Main activity handling UI interactions
- Button click listeners
- Calculator state management
- Triggers interstitial ad after calculation

#### Calculator.kt
- Core calculator logic
- Number input handling
- Operation management
- Calculation execution
- Display formatting

#### AdManager.kt
- HyBid SDK initialization
- Banner ad loading and display
- Interstitial ad loading and display
- Ad event callbacks
- Error handling

### Dependencies

- **AndroidX Core KTX**: 1.12.0
- **AndroidX AppCompat**: 1.6.1
- **Material Design**: 1.10.0
- **ConstraintLayout**: 2.1.4
- **HyBid SDK**: Integrated via local AAR file (`app/libs/hybid-sdk.aar`)

### API Level

- **Minimum SDK**: 24 (Android 7.0 Nougat)
- **Target SDK**: 34 (Android 14)
- **Compile SDK**: 34

## Question 2: Impression Discrepancy Troubleshooting

See [Question2_Answer.md](Question2_Answer.md) for a comprehensive step-by-step guide on troubleshooting impression discrepancies in Open RTB integrations.

**Key Topics Covered**:
- Request-response matching
- Win notification validation
- Impression tracking verification
- Network-level debugging
- Timestamp synchronization
- Root cause analysis

## Question 3: Client Communication Checklist

See [Question3_Answer.md](Question3_Answer.md) for a detailed checklist of questions and information to collect when a publisher reports "Your ad is not working!"

**Key Topics Covered**:
- Initial information gathering
- Technical environment details
- Symptom and behavior analysis
- Logs and diagnostic information
- Communication templates
- Resolution process

## Technical Implementation Notes

- **HyBid SDK Integration**: The SDK is integrated via local AAR file. Due to OMID (Open Measurement SDK) dependency limitations, placeholder ads are implemented to demonstrate the complete integration architecture.
- **Banner Ads**: Loaded on app launch and displayed persistently at the bottom of the screen
- **Interstitial Ads**: Shown automatically after completing a calculation (when "=" button is pressed)
- **Error Handling**: Comprehensive error handling and fallback mechanisms are implemented
- **Code Architecture**: Clean separation of concerns with dedicated classes for Calculator logic and Ad management
- **Logging**: All ad events are logged to Logcat for debugging purposes
- **Permissions**: Internet permission is declared in AndroidManifest.xml for ad serving

## Project Status

- ✅ Android calculator app implemented
- ✅ HyBid SDK integration architecture demonstrated
- ✅ Banner ad placeholder displayed
- ✅ Interstitial ad placeholder displayed
- ✅ Question 2 answer documented
- ✅ Question 3 answer documented
- ✅ Screenshots included in `screenshots/` folder


