# Question 3: Client Communication Checklist - "Your Ad is Not Working!"

When a publisher says "Your ad is not working!", here's what I ask to get to the root cause quickly:

## First Response - Get the Essentials

**Basic info I need:**
- Publisher account ID / app name
- SDK version they're using
- App Token and Zone ID
- When did it start happening?
- What exactly isn't working? (no ads loading, ads loading but not showing, ads showing but broken)

**Quick checks:**
- Screenshots or screen recordings (super helpful!)
- Error messages from logs
- Platform/OS version
- Is it happening everywhere or just specific places?

## Digging Deeper - Technical Details

**SDK & Integration:**
- Which SDK version? (and when was it last updated?)
- How did they integrate it? (CocoaPods, Gradle, manual)
- Any recent code changes?

**Configuration:**
- Are they using test or production credentials?
- Any custom targeting parameters?
- Recent config changes?

**Environment:**
- What devices/OS versions are affected?
- Real devices or emulators?
- Network conditions (WiFi, cellular, VPN)?

## Understanding the Problem

**If ads aren't loading:**
- Are requests even being made? (check network logs)
- What HTTP status codes? (200 = good, 400/500 = problem)
- Any error messages in console?
- Timeout issues?

**If ads load but don't show:**
- Is the ad container properly sized?
- Layout/CSS conflicts?
- Z-index or overlay issues?
- Container visible when ad is requested?

**If ads show but don't work:**
- Clicks not registering?
- Impression pixels not firing?
- Tracking URLs blocked?

## Logs I Need

**Application logs:**
- SDK-specific logs (filter for our API calls)
- Error stack traces
- Debug/verbose logs if possible

**Network logs:**
- Request/response details for ad calls
- Network timing
- Any timeouts or errors

**SDK callbacks:**
- Which callbacks are firing? (onAdLoaded, onAdFailed, etc.)
- Error codes from failure callbacks
- Event sequence

## Context Matters

**App flow:**
- Where in the app are ads requested?
- User journey when ads should appear
- Other SDKs that might conflict?

**Recent changes:**
- App updates?
- SDK updates?
- Config changes?
- Network security changes?

**Testing:**
- Can they reproduce it consistently?
- Steps to reproduce?
- Test vs production behavior?

## My Typical Email Response

```
Hi [Publisher],

Thanks for reporting this. To help diagnose quickly, could you share:

1. Basic info:
   - App name/account ID
   - SDK version
   - App Token & Zone ID
   - When did it start?

2. What's happening:
   - [ ] Ads not loading
   - [ ] Ads loading but not showing
   - [ ] Ads showing but broken
   - Error messages?

3. Please attach:
   - Screenshots/screen recordings
   - Logs (filter for our SDK)
   - Network logs if possible

I'll investigate on our end and get back to you within [X] hours.

Thanks!
```

## Priority Information

**Must have:**
- Account/app identifier
- SDK version
- App Token & Zone ID
- Error messages/logs
- Screenshots
- Steps to reproduce

**Nice to have:**
- Full application logs
- Network capture files
- Code snippets
- Recent changes

## Common Issues I See

**"No ads loading"** → Usually:
- Wrong App Token/Zone ID
- Network issues
- SDK not initialized properly
- Ad blockers

**"Ads load but don't show"** → Usually:
- Container sizing issues
- Layout conflicts
- View hierarchy problems
- Viewability not met

**"Ads show but tracking fails"** → Usually:
- Tracking URLs blocked
- Privacy/consent issues
- Network restrictions
- Callback not implemented

## Bottom Line

The faster I get good logs and screenshots, the faster I can solve it. Most issues are either configuration problems or SDK integration issues that are easy to fix once we see what's actually happening.
