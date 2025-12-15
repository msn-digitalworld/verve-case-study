# Question 2: Impression Discrepancy Troubleshooting

When you see impression discrepancies between your system and a DSP integrated via Open RTB, here's how I'd approach troubleshooting:

## Start with the Basics

**1. Match requests to responses**
- Correlate bid requests with bid responses using request IDs and timestamps
- Check if responses are missing or delayed
- Calculate your match rate - if it's below 95%, something's wrong upstream

**2. Track win notifications**
- Every winning bid should trigger a win notification from the DSP
- Match win notifications back to the original bid request
- Missing win notifications = missing impressions

**3. Verify impression pixels**
- Win notifications should lead to impression pixels firing
- Check if pixels are being blocked (ad blockers, network issues)
- Match pixel fires to win notifications - this is where most discrepancies happen

## Common Issues to Check

**Timing problems**
- Requests/responses outside normal windows (bid response should come within 200ms)
- Delayed impressions (should fire within 5 seconds of win notification)
- Clock skew between systems - normalize everything to UTC

**ID mismatches**
- Request IDs not propagating through the flow
- Duplicate IDs causing double-counting
- Missing IDs in responses

**Network/infrastructure**
- HTTP errors (4xx = bad requests, 5xx = server issues)
- Timeouts causing retries
- Network latency spikes

**Client-side issues**
- Impression events not firing (SDK callback issues)
- Ad blockers preventing pixels
- App backgrounded before impression fires
- Viewability thresholds not met

## Quick Diagnostic Steps

1. **Pull logs** for a specific time period (start with 1 hour)
2. **Create a timeline**: Request → Response → Win → Impression
3. **Calculate rates**: 
   - Request-to-response rate
   - Win notification rate
   - Win-to-impression rate
4. **Find the gap** - where does the chain break?

## Most Common Root Causes

In my experience, discrepancies usually come from:
- **Missing impression pixels** (ad blockers, SDK issues, timing out)
- **Win notifications not received** (DSP-side issue)
- **Timing windows exceeded** (requests counted but impressions invalid)
- **ID deduplication problems** (same impression counted twice)

## Quick Fixes

- **Missing pixels**: Check ad blockers, verify SDK callbacks, review network logs
- **No win notifications**: Escalate to DSP - they should be sending these
- **Timing issues**: Review timeout settings, check for clock sync problems
- **Double counting**: Implement proper deduplication logic using impression IDs

The key is to trace the full flow from request to impression and find where it breaks. Most issues are visible in logs if you know what to look for.
