package com.geektech.tasks.ui.onBoarding.adapter

import android.service.autofill.FillEventHistory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.geektech.home3month6.databinding.VpMathItemBinding
import com.geektech.home3month6.models.MathModel
import com.geektech.home3month6.viewmodel.MathViewModel


class MathAdapter(private val point: Int,private val history: String,private val onPLusClick: () -> Unit,private val onMinusClick: () -> Unit) :
    Adapter<MathAdapter.MathViewHolger>() {
    val data = arrayListOf<MathModel>(
        MathModel("", isPlusVisible = true, isMinusVisible = true),
        MathModel(point.toString(), isPlusVisible = false, isMinusVisible = false),
        MathModel(history, isPlusVisible = false, isMinusVisible = false)
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MathViewHolger {
        return MathViewHolger(
            VpMathItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MathViewHolger, position: Int) {
        holder.bind(data[position])

    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class MathViewHolger(private val binding: VpMathItemBinding) :
        ViewHolder(binding.root) {
        fun bind(math: MathModel) {
            binding.minusBtn.setOnClickListener{
                onMinusClick
            }
            binding.plusBtn.setOnClickListener {
                onPLusClick
            }
            binding.mathTv.text = math.text.toString()
            if (math.isMinusVisible) {
                binding.minusBtn.visibility = View.VISIBLE
            } else {
                binding.minusBtn.visibility = View.GONE
            }
            if (math.isPlusVisible) {
                binding.plusBtn.visibility = View.VISIBLE
            } else {
                binding.plusBtn.visibility = View.GONE
            }
        }
    }

}
