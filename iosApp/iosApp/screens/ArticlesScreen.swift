//
//  ArticlesScreen.swift
//  iosApp
//
//  Created by IRV on 2024-07-15.
//  Copyright © 2024 orgName. All rights reserved.
//

/*import SwiftUI
import shared

extension ArticlesScreen {
    
    @MainActor
    class ArticlesViewModelWrapper: ObservableObject {
        let articlesViewModel: ArticlesViewModel
        
        
        init() {
            articlesViewModel = ArticlesInjector().articlesViewModel
            articlesState = articlesViewModel.articlesState.value
        }
        
        @Published var articlesState: ArticlesState
        
        func startObserving() {
            Task {
                for await articlesS in articlesViewModel.articlesState {
                    self.articlesState = articlesS
                }
            }
        }
    }
}

struct ArticlesScreen: View {
    
    @ObservedObject private(set) var viewModel: ArticlesViewModelWrapper
    
    var body: some View {
        VStack {
            if viewModel.articlesState.loading {
                Loader()
            }
            
            if let error = viewModel.articlesState.error {
                ErrorMessage(message: error)
            }
            
            if(!viewModel.articlesState.articles.isEmpty) {
                ScrollView {
                    LazyVStack(spacing: 10) {
                        ForEach(viewModel.articlesState.articles, id: \.self) { article in
                            ArticleItemView(article: article)
                        }
                    }
                }
            }
            
        }.onAppear{
            self.viewModel.startObserving()
        }.refreshable {
            self.viewModel.articlesViewModel.getArticles(forceFetch: true)
        }
    }
}
*/
