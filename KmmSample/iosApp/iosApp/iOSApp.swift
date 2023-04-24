import SwiftUI
import shared

@main
struct iOSApp: App {
    init() {
        Di.shared.doInitKoin()
    }
    
    var body: some Scene {
        WindowGroup {
            FormView(viewModel: FormViewModel(userRepository: Di.shared.userRepository))
        }
    }
}
