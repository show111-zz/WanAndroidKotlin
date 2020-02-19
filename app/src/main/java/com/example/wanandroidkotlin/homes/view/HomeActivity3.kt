package com.example.wanandroidkotlin.homes.view

import android.content.Intent
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.base.BaseActivity
import com.example.wanandroidkotlin.detail.view.DetailActivity
import com.example.wanandroidkotlin.homes.paging.HomeDataSourceFactory
import com.example.wanandroidkotlin.homes.paging.HomeRepository
import com.example.wanandroidkotlin.homes.viewmodel.HomeViewModel
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*

/**
 *  Created by hannah on 2020-01-21
 */
class HomeActivity3 : BaseActivity() {

    private lateinit var articleAdapter: HomeAdapter
    lateinit var homeRepository: HomeRepository
    lateinit var homeDataSourceFactory: HomeDataSourceFactory
    private val compositeDisposable = CompositeDisposable()

    private lateinit var viewModel: HomeViewModel

    override var layoutId = R.layout.activity_main


    override fun initData() {

        homeDataSourceFactory = HomeDataSourceFactory(compositeDisposable)
        homeRepository = HomeRepository()
        viewModel = getViewModel()

        articleAdapter = HomeAdapter()
        articleRecyclerView.layoutManager = LinearLayoutManager(this)
        articleRecyclerView.addItemDecoration(
            DividerItemDecoration(
                this@HomeActivity3,
                LinearLayout.VERTICAL
            )
        )
        articleRecyclerView.setHasFixedSize(true)
        articleRecyclerView.adapter = articleAdapter

        articleAdapter.onItemClick = {
            startActivity(Intent(this, DetailActivity::class.java))
        }


        viewModel.articleList.observe(
            this,
            Observer {
                articleAdapter.submitList(it)
            })
    }

    private fun getViewModel(): HomeViewModel {
        return ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return HomeViewModel(homeRepository) as T
            }
        })[HomeViewModel::class.java]
    }

}
