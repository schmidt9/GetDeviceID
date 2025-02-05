import cocoapods.FCUUID.FCUUID
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(ExperimentalForeignApi::class)
actual fun getDeviceId(context: Any?): String {
    return FCUUID.uuidForDevice() ?: "Unable to get device ID"
}