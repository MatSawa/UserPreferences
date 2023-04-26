import Foundation
import SwiftUI

struct FormView: View {
    @ObservedObject var viewModel: FormViewModel

    var body: some View {
        VStack {
            TextField("Enter text here", text: $viewModel.text)
            Button(action: viewModel.save) {
                Text("Save")
            }.disabled(!viewModel.isSaveEnabled)
        }
    }
}
