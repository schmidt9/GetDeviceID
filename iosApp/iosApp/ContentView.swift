import SwiftUI
import Foundation
import Shared

struct ContentView: View {
    var body: some View {
        VStack(spacing: 16) {
            Image(systemName: "swift")
                .font(.system(size: 200))
                .foregroundColor(.accentColor)
            Text("Device ID: \(Platform_nativeKt.getDeviceId())")
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
