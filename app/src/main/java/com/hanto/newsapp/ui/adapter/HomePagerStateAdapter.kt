package com.hanto.newsapp.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hanto.newsapp.data.Category
import com.hanto.newsapp.ui.CategoryArticleListFragment

//뷰페이저2에서 화면을 구성할 때 Fragment로 그 화면을 구현핳때는 FragmentStateAdapter을 구현하는 것이 적합하다.
@Suppress("UNREACHABLE_CODE")
class HomePagerStateAdapter(
    fragment: Fragment,
    private val categories: List<Category>
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        //관리하는 데이터 값을 반환
        return categories.size
    }

    //탭별 위치에 따라 다른 데이터를 요청 할 수 있는 구형
    //이 위치에서 카테고리 정보를 가져와야함..
    override fun createFragment(position: Int): Fragment {
        return CategoryArticleListFragment.newInstance(categories[position])
    }
}