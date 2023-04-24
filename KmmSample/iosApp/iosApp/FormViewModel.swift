//
//  FormViewModel.swift
//  iosApp
//
//  Created by Mateusz Sawa on 4/22/23.
//  Copyright © 2023 SawApps. All rights reserved.
//

import shared

class FormViewModel: ObservableObject {
    private let userRepository: UserRepository
    @Published var text: String = ""
    var isSaveEnabled: Bool {
        return !text.isEmpty
    }
    
    init(userRepository: UserRepository) {
        self.userRepository = userRepository
        self.text = userRepository.userName
    }

    func save() {
        userRepository.userName = text
        text = ""
    }
}
