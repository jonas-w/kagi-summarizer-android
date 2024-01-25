# Kagi Summarizer on Android (not affiliated with Kagi)

> [!NOTE]
> You need to have a Kagi subscription to use this.
> This only acts as a shortcut to the below mentioned URLs and opens them in your browser.

The only thing this app does, is appear in your share menu. I absolutely don't have any Android development experience (contributions/feedback is welcome!), but I wanted to have this feature, so I built it.

If you share a link, the share menu will now contain three entries from this App:

- Discuss -> This will redirect you to https://kagi.com/discussdocs?url= + the url you shared
- Summarize -> This will redirect you to https://kagi.com/summarizer?summary=summary&url= + the url you shared
- Takeway -> This will redirect you to https://kagi.com/summarizer?summary=takeway&url= + the url you shared

If you share a text snippet instead of a URL, all three will still appear, but "Discuss" does currently not work without an URL provided (limitation on Kagi's side) and you'll only get a toast notification that you can only share URLs with "Discuss" and not text.

## Installation

Download the latest app-release.apk from https://github.com/jonas-w/kagi-summarizer-android/releases

Or clone this repository and build it yourself with Android Studio

## Settings

There are currently two settings options:

### Summary Language

Here you can select your default summary language, this does the same as the language selection on https://kagi.com/summarize.
The default value is "Default", this is also the same as on kagi.com, this way it uses the language of the summarized document.


### Custom Tabs

You can select if you want the summary links to open in a custom tab or normally in your browser, both options will use your default browser, as long as your browser supports [custom tabs](https://developer.chrome.com/docs/android/custom-tabs/)
The default is to open links in custom tabs.


# License

```
   Copyright 2024-today @jonas-w

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

```
