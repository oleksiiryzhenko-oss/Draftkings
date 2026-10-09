# Riverline Sports Club — App Package

This document collects the identifiers and brand details used across this package. A few values (marked below) are **placeholders you should change** before submitting to an app store — they aren't registered to any real account.

## Identity

| Field | Value |
|---|---|
| App name | Riverline Sports Club |
| Short name (home screen label) | Riverline |
| Version | 1.0.1 |
| Build number | 2 |
| Category | Sports / Health & Fitness |
| Platforms | Web (PWA), iOS, Android (via Capacitor — see below) |

## Bundle / App identifiers — ⚠️ placeholders, change these

App stores require a reverse-domain identifier tied to a domain or developer account you actually control. The values below are placeholders using an invented domain (`riverline.club`) and **will not work as-is** — swap in an identifier based on a domain or developer account you own.

| Platform | Field | Placeholder value |
|---|---|---|
| iOS | Bundle Identifier | `club.riverline.sports` |
| Android | Application ID / Package Name | `club.riverline.sports` |
| Capacitor | `appId` (in `capacitor.config.json`) | `club.riverline.sports` |

To pick your own: reverse your domain (e.g. `mysportsclub.com` → `com.mysportsclub.app`), or use `com.<yourname-or-company>.<appname>` if you don't have a domain yet. Once you register an app with this ID in App Store Connect or Google Play Console, that ID is locked to your account permanently.

## Brand

| Token | Value |
|---|---|
| Primary (navy) | `#132038` |
| Tennis accent (green) | `#3f8f5f` |
| Basketball accent (orange) | `#e07a3f` |
| Background (light) | `#f4f5f3` |
| Background (dark) | `#0f1522` |
| Display typeface | Barlow Condensed (headings) |
| Body typeface | Inter |
| Favicon / app icon emoji fallback | 🎾 |

Logo: `app-store-assets/logo-master.svg` — two overlapping balls (tennis + basketball) on a rounded navy square. Edit the SVG directly if you want to adjust colors or proportions; every PNG in this package was rasterized from it.

## Store listing copy (draft)

**Subtitle / tagline:** Tennis & basketball, no account needed
**Short description:** Browse real, in-person tennis and basketball sessions near you and register in under a minute — no sign-up, no password, no profile.
**Keywords:** tennis, basketball, local sports club, drop-in sports, pickup games, court booking

## What's in this package

```
riverline-sports-club-app/
├── APP-INFO.md              this file
├── README.md                setup + submission notes
├── capacitor.config.json    config for wrapping the web app natively
├── app-store-assets/
│   ├── icon-1024.png         master app icon (App Store / Play Store listing size)
│   └── logo-master.svg       editable source logo
└── www/                      the actual app (this is your web root / Capacitor webDir)
    ├── index.html
    ├── manifest.json          PWA manifest (installable "Add to Home Screen")
    └── icons/
        ├── icon-192.png
        ├── icon-512.png
        ├── icon-152.png       iOS/iPad
        ├── icon-120.png       iOS iPhone
        ├── apple-touch-icon.png (180×180)
        ├── favicon-32.png
        └── favicon-16.png
```

## Notes

- All registration data is stored in the browser's local storage on each device — there's no backend, database, or account system, by design.
- No copyrighted names, logos, or trademarks are used anywhere in this package; the club name, logo, and sample activities are original placeholders you're free to keep or rebrand.
