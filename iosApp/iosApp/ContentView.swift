import SwiftUI
import shared

struct ContentView: View {
    var body: some View {
        ComposeView().ignoresSafeArea(.keyboard)
    }
}

struct ComposeView: UIViewControllerRepresentable {
    
    func makeUIViewController(context: Context) -> some UIViewController {
        MainiOSKt.MainViewController()
    }
    
    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) {
        
    }
}

/*struct ContentView: View {
    
    @State var selection = 0
    
    var body: some View {
        let articleScreen = ArticlesScreen(viewModel: .init())
        let everythingScreen = EverythingScreen(viewModel: .init())
        NavigationStack {
            AppBar()
            Picker(selection: $selection, label: Text("test")) {
                Text("Top Headlines").tag(0)
                Text("Everything").tag(1)
            }.pickerStyle(.segmented)
                .padding(8)
            
            switch selection {
            case 0:
                articleScreen
            case 1:
                everythingScreen
            default:
                articleScreen
            }
        }
    }
}

struct AppBar: View {
    @State private var shouldOpenAbout = false
    
    var body: some View {
        Text("Articles")
            .font(.largeTitle)
            .fontWeight(.bold)
            .toolbar{
                ToolbarItem {
                    Button {
                        shouldOpenAbout = true
                    } label: {
                        Label("About", image: "info").labelStyle(.titleAndIcon)
                    }
                    .popover(isPresented: $shouldOpenAbout) {
                        AboutScreen()
                    }
                }
            }
    }
}*/
