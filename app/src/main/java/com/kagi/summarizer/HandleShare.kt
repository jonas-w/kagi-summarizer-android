package com.kagi.summarizer

import android.content.Intent
import android.net.Uri
import android.preference.PreferenceManager
import android.util.Patterns
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.browser.customtabs.CustomTabsIntent

class HandleShare {
    companion object {
        fun openKagi(activity: ComponentActivity, kagiSumType: KagiSumType) {
            val sharedText = activity.intent.getStringExtra(Intent.EXTRA_TEXT)
            val urlMatcher = Patterns.WEB_URL.matcher(sharedText.toString())

            val preferences =
                PreferenceManager.getDefaultSharedPreferences(activity.applicationContext)
            var summary_language =
                preferences.getString("kagi_language", "Default") ?: "Default"

            if (summary_language != "Default") {
                summary_language =
                    "&target_language=" + SUMMARY_LANGUAGES.getOrDefault(summary_language, "")
            } else {
                summary_language = ""
            }
            var kagiUrl = when (kagiSumType) {
                KagiSumType.SUMMARY -> "https://kagi.com/summarizer?summary=summary$summary_language"
                KagiSumType.DISCUSS -> "https://kagi.com/discussdoc"
                KagiSumType.TAKEAWAY -> "https://kagi.com/summarizer?summary=takeaway$summary_language"
            }

            if (urlMatcher.matches()) {
                kagiUrl += (if(kagiSumType == KagiSumType.DISCUSS) "?" else "&")+ "url=" + Uri.encode(urlMatcher.group().toString())


            } else {
                if (activity is DiscussActivity) {
                    Toast.makeText(
                        activity,
                        "Discuss is not supported for text, only URLs can be discussed currently.",
                        Toast.LENGTH_SHORT
                    ).show()
                    activity.finish()
                    return
                }
                kagiUrl += "#" + Uri.encode(sharedText.toString())
            }
            val intentUrl = Uri.parse(kagiUrl)
            if (preferences.getBoolean("custom_tab", false)) {
                val intent: CustomTabsIntent = CustomTabsIntent.Builder().build()
                intent.launchUrl(activity, intentUrl)
            } else {
                activity.startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        intentUrl,
                    )
                )
            }
            activity.finish()
        }
    }
}