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
