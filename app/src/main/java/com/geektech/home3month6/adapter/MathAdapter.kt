package com.geektech.tasks.ui.onBoarding.adapter


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.geektech.home3month6.math.PointFragment
import com.geektech.home3month6.math.ViewHistoryFragment
import com.geektech.home3month6.math.ViewPointsFragment

class MathAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity){
    val points = 3
    override fun getItemCount(): Int {
        return points
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0-> {PointFragment()}
            1-> {ViewPointsFragment()}
            2-> {ViewHistoryFragment()}
            else -> {PointFragment()}
        }
    }


}
