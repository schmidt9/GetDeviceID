# GetDeviceID
Kotlin Compose Multiplatform project to check possibilities for unique device id generation on different platforms. 
Following approaches were used:

* Android

  `Secure.ANDROID_ID`, result seems to be reliable, but not recommended by Google
* iOS

  `FCUUID` library (https://github.com/fabiocaccamo/FCUUID), result seems to be reliable with some minor restrictions like system reset (see https://github.com/fabiocaccamo/FCUUID?tab=readme-ov-file#persistence)
* JVM
  
  `OSHI` library (https://github.com/oshi/oshi), generation based on hardware info, code taken from https://stackoverflow.com/a/37705082/3004003. The method seems to be less reliable compared to Android and iOS (just subjectively, based on opinions https://stackoverflow.com/questions/1986732/how-to-get-a-unique-computer-identifier-in-java-like-disk-id-or-motherboard-id) 
* WASM
  
  random UUID generation using JavaScript `window.crypto.randomUUID()` method. Result is stored using `localStorage` and reused. The most unreliable method among all platforms, but it seems to be no reliable way to get something better due to browser restrictions.
