package com.kagi.summarizer

import android.content.Intent
import android.net.Uri
import android.util.Patterns
import android.widget.Toast
import androidx.activity.ComponentActivity

class HandleShare {
    companion object {
        fun openKagi(activity: ComponentActivity, kagiSumType: KagiSumType) {
            val sharedText = activity.intent.getStringExtra(Intent.EXTRA_TEXT)
            val urlMatcher = Patterns.WEB_URL.matcher(sharedText.toString())
            if (urlMatcher.find()) {
                val url = Uri.encode(urlMatcher.group().toString())
                val kagiUrl = when (kagiSumType) {
                    KagiSumType.SUMMARY -> "https://kagi.com/summarizer?summary=summary&url="
                    KagiSumType.DISCUSS -> "https://kagi.com/discussdoc?url="
                    KagiSumType.TAKEAWAY -> "https://kagi.com/summarizer?summary=takeaway&url="
                }
                activity.startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("$kagiUrl$url")
                    )
                )
            } else {
                Toast.makeText(
                    activity, "Not a valid URL and could not find a URL in the shared text.",
                    Toast.LENGTH_SHORT
                ).show()
            }
            activity.finish()
        }
    }
}