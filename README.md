## Overview

TCP Client(broadcast edition) implementation of realtime speech translator messenger using Google Speech Recognition API & Yandex Translation API.

The main task of the client is:

a. Send message to the server with defined language.

b. Get message from the server, translate it to the desired language and pronounce it.

It is possible to choose input and output languages.

Input is the language in which you want to listen to the voice message.

Output is the language in which you want to send the voice message.

Server supports 4 languages: korean, english, russian and french(If you want, you can add new language by slightly modifying code).

You will find the lists of Supported languages in Additional references below.

## How it works
### Server
1. Listens for incoming voice message from any client that is connected to the Server.
2. Broadcast the message to other clients, except for the client who sent the message.
### Client
1. Recieves the text message and determines it's language.
2. Turns text message into a voice message.
3. Pronounces the voice message.

## How to run

Step 1. Import project to Android Studio or any other IDE in your choice. 

Step 2. Add a library http://www.java2s.com/Code/Jar/j/Downloadjsonsimple111jar.htm to your project, you will need it to work with Yandex Translation API

Step 3. Go to https://tech.yandex.com/keys/get/?service=trnsl and get the API key

Step 4. In MainActivity.java, find the function getJsonStringYandex and replace apiKey to your own key that you got from https://tech.yandex.com/keys/get/?service=trnsl

Step 5. After that you are ready to run RealtimeTalkServer.

## API Reference
Yandex Translation API - https://tech.yandex.com/translate/

Android Speech API - https://developer.android.com/reference/android/speech/package-summary.html

Android Text to speech API - https://developer.android.com/reference/android/speech/tts/package-summary.html

Cloud Speech API - https://cloud.google.com/speech/

Cloud Translation API - https://cloud.google.com/translate/

## Additional References

Yandex Translation API supported languages - https://tech.yandex.com/translate/doc/dg/concepts/api-overview-docpage/

Google API supported languages - https://cloud.google.com/speech/docs/languages
