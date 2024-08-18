//
//  EverythingScreen.swift
//  iosApp
//
//  Created by IRV on 2024-08-04.
//  Copyright © 2024 orgName. All rights reserved.
//

/*import SwiftUI
import shared

extension EverythingScreen {
    
    @MainActor
    class EverythingViewModelWrapper: ObservableObject {
        let everythingViewModel: EverythingViewModel
        
        
        init() {
            everythingViewModel = ArticlesInjector().everythingViewModel
            everythingState = everythingViewModel.everythingState.value
        }
        
        @Published var everythingState: EverythingState
        
        func startObserving() {
            Task {
                for await articlesS in everythingViewModel.everythingState {
                    self.everythingState = articlesS
                }
            }
        }
    }
}

struct EverythingScreen: View {
    
    @ObservedObject private(set) var viewModel: EverythingViewModelWrapper
    
    var body: some View {
        VStack {
        
            if viewModel.everythingState.loading {
                Loader()
            }
            
            if let error = viewModel.everythingState.error {
                ErrorMessage(message: error)
            }
            
            if(!viewModel.everythingState.articles.isEmpty) {
                ScrollView {
                    LazyVStack(spacing: 10) {
                        ForEach(viewModel.everythingState.articles, id: \.self) { article in
                            ArticleItemView(article: article)
                        }
                    }
                }
            }
            
        }.onAppear{
            self.viewModel.startObserving()
        }.refreshable {
            self.viewModel.everythingViewModel.getEverything()
        }
    }
}*/

