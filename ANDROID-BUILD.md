# Android project

Prepared for local installation, 2026-09-17.

- Capacitor 8.5.2; Android Gradle Plugin 8.13.0; Gradle 8.14.3.
- Requires Node.js >= 22, JDK 21 and Android SDK 36.
- compileSdk 36, targetSdk 36, minSdk 24 (Capacitor 8 default).
- App version: 1.0.1; Android versionCode: 2.
- Variants: debug and release. Release signing uses KEYSTORE/club.riverline.sports-upload-keystore.jks, alias upload.
- App ID preserved from the supplied package.
- Native launcher and splash icons generated from the supplied branding.

## Build

```sh
npm ci
npm run android:debug
```

Set JAVA_HOME to JDK 21 and configure android/local.properties with your SDK path.
APK: android/app/build/outputs/apk/debug/app-debug.apk
Open the android directory in Android Studio to edit the native project.

Riverside includes a Vite build to bundle React locally. Riverline uses www directly.
Google Fonts can be fetched online; system fonts are available offline.

Signed release APK and AAB are in UPLOAD/. Release builds use the project key and credentials in KEYSTORE/. No Play submission was performed.

Before every future release, check SDK/signing and test the application on a separate temporary emulator according to the user's release requirements; stop if a crash occurs. Then run `npm run android:release`. Gradle writes APK to `android/app/build/outputs/apk/release/app-release.apk` and AAB to `android/app/build/outputs/bundle/release/app-release.aab`. Verify their signatures before copying to UPLOAD/.

The project ZIP includes KEYSTORE and UPLOAD (signing key, credentials, signed release APK/AAB). Build directories are removed. node_modules, Gradle caches and machine-specific local.properties are excluded from the ZIP. Run npm ci before rebuilding.
