package com.example.upnews.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.webkit.WebViewClient
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.upnews.R
import com.example.upnews.databinding.FragmentArticleBinding
import com.example.upnews.ui.NewsActivity
import com.example.upnews.ui.NewsViewModel
import com.google.android.material.snackbar.Snackbar

class ArticleFragment : Fragment(R.layout.fragment_article) {
    private lateinit var newsViewModel: NewsViewModel
    private val args: ArticleFragmentArgs by navArgs()
    private lateinit var binding: FragmentArticleBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentArticleBinding.bind(view)

        // Initialize the ViewModel
        newsViewModel = (activity as NewsActivity).newsViewModel
        val article = args.article

        // Load the article URL in the WebView
        binding.webView.apply {
            webViewClient = WebViewClient()
            article.url?.let {
                loadUrl(it)
            }
        }

        // Add to Favourites functionality
        binding.fab.setOnClickListener {
            newsViewModel.addToFavourites(article)
            Snackbar.make(view, "Added to favourites", Snackbar.LENGTH_SHORT).show()
        }

        // Navigate back to HeadlinesFragment
        binding.headlinesButton.setOnClickListener {
            findNavController().navigate(R.id.action_articleFragment_to_headlinesFragment)
        }
    }
}
