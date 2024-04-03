import kotlinx.browser.localStorage

actual fun getDeviceId(context: Any?): String {
    // not possible to get a truly unique device id using javascript in browser, see
    // https://stackoverflow.com/questions/49692073/how-can-i-get-a-unique-device-id-in-javascript

    // taken from https://stackoverflow.com/a/73449740/3004003
    val deviceIdKey = "deviceId"
    var deviceId = localStorage.getItem(deviceIdKey)

    if (deviceId == null) {
        // note: device id will be null everytime when launched from IDE,
        // to test storage reload page in browser adding console output if needed
        deviceId = generateUUID()
        localStorage.setItem(deviceIdKey, deviceId)
    }

    return deviceId
}

/**
 * Reference for getting UUID https://github.com/whyoleg/cryptography-kotlin/blob/d524143a0719e6926b0ae190977a7341673fa718/cryptography-random/src/wasmJsMain/kotlin/CryptographyRandom.wasmJs.kt#L41
 */
private fun generateUUID(): String {
    js(
        """
            return window.crypto.randomUUID();
        """
    )
}