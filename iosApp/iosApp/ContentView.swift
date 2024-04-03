import SwiftUI
import Foundation
import Shared

struct ContentView: View {
    var body: some View {
        VStack(spacing: 16) {
            Text("Device ID: \(Platform_iosKt.getDeviceId())")
        }
        .transition(.move(edge: .top).combined(with: .opacity))
        .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .top)
        .padding()
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
