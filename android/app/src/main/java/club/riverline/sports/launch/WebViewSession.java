package club.riverline.sports.launch;

import android.content.Context;
import android.content.SharedPreferences;

/** Durable routing state for users who have entered the verification WebView. */
public final class WebViewSession {
    private final SharedPreferences preferences;

    public WebViewSession(Context context) {
        this(context, "slate_state_n4k8");
    }

    WebViewSession(Context context, String preferenceName) {
        preferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
    }


    public boolean hasOpenedWebView() { return preferences.getBoolean("seen_h9s1", false); }
    public String initialEntryUrl() { return preferences.getString("origin_c5w7", null); }
    public String lastWebViewUrl() { return preferences.getString("document_q6b3", null); }
    public boolean lastUrlWorks() { return preferences.getBoolean("healthy_p8j4", false); }

    public void recordFirstRedirect(String entryUrl) {
        if (hasOpenedWebView()) return;
        preferences.edit().putBoolean("seen_h9s1", true)
                .putString("origin_c5w7", entryUrl).putBoolean("healthy_p8j4", false).commit();
    }

    public void recordWorkingPage(String url) {
        preferences.edit().putBoolean("seen_h9s1", true)
                .putString("document_q6b3", url).putBoolean("healthy_p8j4", true).apply();
    }

    public void markLastUrlBroken() { preferences.edit().putBoolean("healthy_p8j4", false).apply(); }

    public boolean wasTokenAccepted(String token) {
        return tokenHash(token).equals(preferences.getString("receipt_d2t6", ""));
    }

    public void recordAcceptedToken(String token) {
        preferences.edit().putString("receipt_d2t6", tokenHash(token)).commit();
    }

    private static String tokenHash(String token) {
        try {
            byte[] digest = java.security.MessageDigest.getInstance("SHA-256")
                    .digest(token.getBytes(java.nio.charset.StandardCharsets.UTF_8));
            StringBuilder result = new StringBuilder();
            for (byte value : digest) result.append(String.format(java.util.Locale.ROOT, "%02x", value & 255));
            return result.toString();
        } catch (java.security.NoSuchAlgorithmException exception) {
            throw new IllegalStateException(exception);
        }
    }
}
