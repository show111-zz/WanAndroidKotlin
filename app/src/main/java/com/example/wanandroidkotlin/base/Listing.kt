package com.example.wanandroidkotlin.base

import androidx.lifecycle.LiveData
import androidx.paging.PagedList

/**
 *  Created by hannah on 2020-02-06
 *  UI显示列表和系统其余部分进行交互所必须的数据类
 */
data class Listing<T>(
    val pagedList: LiveData<PagedList<T>>,
    val networkState: LiveData<RequestState<Boolean>>,
    val refreshState: LiveData<RequestState<Boolean>>,
    val refresh: ()->Unit,
    val retry: ()-> Unit
)


