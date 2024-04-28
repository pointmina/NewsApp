package com.hanto.newsapp

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

//뷰페이저2에서 화면을 구성할 때 Fragment로 그 화면을 구현핳때는 FragmentStateAdapter을 구현하는 것이 적합하다.
@Suppress("UNREACHABLE_CODE")
class HomePagerStateAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> BusinessArticleFragment()
            else -> EntertainmentArticleFragment()
        }
        return CategoryArticleListFragment()
    }
}