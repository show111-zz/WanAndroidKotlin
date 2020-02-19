package com.example.wanandroidkotlin.homes.view

import androidx.fragment.app.Fragment
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.base.BaseActivity
import com.example.wanandroidkotlin.homes.view.home.HomeFragment
import com.example.wanandroidkotlin.homes.view.knowledge.KnowledgeFragment
import com.example.wanandroidkotlin.homes.view.project.ProjectFragment
import com.example.wanandroidkotlin.homes.view.wechat.WechatFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.LabelVisibilityMode.LABEL_VISIBILITY_LABELED
import kotlinx.android.synthetic.main.activity_detail.*

/**
 *  Created by hannah on 2020-01-27
 */
class HomeActivity : BaseActivity() {

    private var index: Int = 0

    private var fragmentTag: String = ""

    private var currentFragment: Fragment? = null

    private val fragmentName = arrayOf(
        HomeFragment::class.java.name,
        ProjectFragment::class.java.name,
        KnowledgeFragment::class.java.name,
        WechatFragment::class.java.name
    )

    override var layoutId = R.layout.activity_detail

    override fun initData() {
        initNavBottom()
        bottomNav()
    }

    private fun initNavBottom() {
        val onNavigationItemSelectedListener =
            BottomNavigationView.OnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.home -> index = 0
                    R.id.project -> index = 1
                    R.id.knowledge -> index = 2
                    R.id.wechat -> index = 3
                }
                bottomNav()
                true
            }
        navigation_bottom.run {
            labelVisibilityMode = LABEL_VISIBILITY_LABELED
            setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        }
    }

    private fun bottomNav() {
        fragmentTag = fragmentName[index]
        val fragment = getFragmentByTag(fragmentTag)
        showFragment(currentFragment, fragment, fragmentTag)
    }

    private fun getFragmentByTag(name: String): Fragment {
        var fragment = supportFragmentManager.findFragmentByTag(name)
        if (fragment != null) {
            return fragment
        } else {
            try {
                fragment = Class.forName(name).newInstance() as Fragment
            } catch (e: Exception) {
                fragment = ProjectFragment()
            }
        }
        return fragment!!
    }

    private fun showFragment(fromCurrent: Fragment?, to: Fragment, fragmentTag: String) {
        val fragmentManager = supportFragmentManager.beginTransaction()
        if (fromCurrent == null) {
            if(to.isAdded){
                fragmentManager.show(to)
            }else{
                fragmentManager.add(R.id.fragment_container, to, fragmentTag)
            }
        } else {
            if(to.isAdded){
                fragmentManager.hide(fromCurrent).show(to)
            }else{
                fragmentManager.hide(fromCurrent).add(R.id.fragment_container, to, fragmentTag)
            }
        }
        fragmentManager.commit()
        currentFragment = to
    }


}
