import oshi.SystemInfo

actual fun getDeviceId(context: Any?): String {
    // taken from https://stackoverflow.com/a/37705082/3004003
    val systemInfo = SystemInfo()
    val operatingSystem = systemInfo.operatingSystem
    val hardwareAbstractionLayer = systemInfo.hardware
    val centralProcessor = hardwareAbstractionLayer.processor
    val computerSystem = hardwareAbstractionLayer.computerSystem

    val vendor = operatingSystem.manufacturer
    val processorSerialNumber = computerSystem.serialNumber
    val processorIdentifier = centralProcessor.processorIdentifier
    val processors = centralProcessor.logicalProcessorCount

    val delimiter = "#"

    return vendor +
            delimiter +
            processorSerialNumber +
            delimiter +
            processorIdentifier +
            delimiter +
            processors // TODO: encode to base64 if needed
}