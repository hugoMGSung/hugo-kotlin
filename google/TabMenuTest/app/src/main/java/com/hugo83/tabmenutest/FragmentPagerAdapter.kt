package com.hugo83.tabmenutest

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    // Fragment의 개수 설정
    override fun getItemCount(): Int = 4

    // 각 포지션에 해당하는 Fragment를 반환
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FragmentOne()
            1 -> FragmentTwo()
            2 -> FragmentThree()
            3 -> FragmentFour()
            else -> FragmentOne()
        }
    }
}