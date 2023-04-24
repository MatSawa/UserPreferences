//
//  FormView.swift
//  iosApp
//
//  Created by Mateusz Sawa on 4/22/23.
//  Copyright © 2023 orgName. All rights reserved.
//

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
