package com.hanto.newsapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.hanto.newsapp.data.Category
import com.hanto.newsapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    //fragment이기 때문에 binding class 타입의 변수를 두개 관리해야한다.
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    //fragment이기때문에 binding class 초기화
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    //view를 초기화할때 onViewCreated
    //여기에서 뷰 페이저와 탭 레이아웃 코드가 화면 전환을 할 수 있도록 코드 작성
    //탭 레이아웃과 뷰페이저2를 함께 사용할 대는 탭의 변경과 처리를 할때 탭레이아웃 미디에이터 활용
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setLayout()
    }


    //바인딩 변수 null로 초기화
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setLayout() {
        //뷰페이저의 구현이서 뷰페이저 내부의 화면을 전환할 때 필요한 구현을 리사이클러 어댑터를 구현해서 초기화해야한다.
        //fragment에서 ui를 나타내기 위해서 데이터를 전달 받는데 관련 코드를 뷰 어댑터에 할당을 하고
        //어댑터를 통해서 화면에서 관리할 데이터를 전달 할 수 있게 된다.
        val homeCategory = Category.values().filter {
            it != Category.Default
        }
        val adapter = HomePagerStateAdapter(this, homeCategory)
        binding.viewpagerHome.adapter = adapter
        TabLayoutMediator(binding.tabHome, binding.viewpagerHome) { tab, position ->
            //인자로 전달 되는 탭과 포지션 값을 받아서 탭의 텍스트 혹은 아이콘을 변경하고 싶으면
            //람다 내에서 우리가 코드를 실행시켜야 한다.
            val categoryLabel = homeCategory[position].label
            tab.text = categoryLabel
        }.attach()
    }
}


