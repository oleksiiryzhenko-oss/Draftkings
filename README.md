# Riverline Sports Club — App Package

Everything needed to brand, package, and submit this app: the web app itself, an icon set, a PWA manifest, and the config needed to wrap it as a native iOS/Android app. See `APP-INFO.md` for identifiers, brand colors, and store listing copy.

## Option A — Use it as a website / installable web app (fastest)

Upload the contents of `www/` to any web host. That's it — `manifest.json` and the icons already make it installable via "Add to Home Screen" on iOS and Android.

## Option B — Wrap it as a native iOS/Android app with Capacitor

This turns the web app into a real `.ipa` (iOS) / `.aab` (Android) you can submit to the App Store or Google Play.

1. Install Node.js, then in an empty project folder:
   ```
   npm init -y
   npm install @capacitor/core @capacitor/cli @capacitor/ios @capacitor/android
   ```
2. Copy this package's `www/` folder and `capacitor.config.json` into that project.
3. **Before continuing**, open `capacitor.config.json` and `APP-INFO.md` and replace the placeholder `appId` (`club.riverline.sports`) with an identifier based on a domain or developer account you actually own — see the "Bundle / App identifiers" section in `APP-INFO.md`.
4. Add the native platforms and open them in their native IDEs:
   ```
   npx cap add ios
   npx cap add android
   npx cap open ios       # opens Xcode
   npx cap open android   # opens Android Studio
   ```
5. In Xcode / Android Studio, set the app icon from `app-store-assets/icon-1024.png` (both IDEs can auto-generate the full icon set from this single 1024×1024 file), confirm the bundle identifier matches what you set in step 3, then build and archive for submission.

You'll need an Apple Developer account ($99/year) to submit to the App Store, and a Google Play Developer account ($25 one-time) for Google Play.

## Regenerating icons

`app-store-assets/logo-master.svg` is the editable source. If you change it, regenerate the PNGs at these sizes: 1024 (store listing), 512, 192 (PWA/Android), 180 (iOS touch icon), 152, 120, 32, 16 (favicons).
