package com.example.squaredirectorycode.ui.adapter

import android.text.method.TextKeyListener.clear
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.squaredirectorycode.R
import com.example.squaredirectorycode.data.model.EmployeeX
import com.example.squaredirectorycode.databinding.EmployeeItemBinding
import java.util.Collections.addAll

class EmployeeAdapter (private val employee: ArrayList<EmployeeX>): RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>(
) {

//    var employee = ArrayList<EmployeeX>()
//
//    fun setDataList(data: ArrayList<EmployeeX>) {
//        this.employee = data
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val binding =
            EmployeeItemBinding.inflate(LayoutInflater.from(parent.context))
        return EmployeeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
//        val currentItem = getItem(position)
//        if (currentItem != null) {
//            holder.bind(currentItem)
//        }
        holder.bind(employee[position])
    }

    class EmployeeViewHolder(private val binding: EmployeeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(employee: EmployeeX) {
            binding.user = employee
            binding.executePendingBindings()
        }
    }

//    class EmployeeComparator : DiffUtil.ItemCallback<EmployeeX>() {
//        override fun areItemsTheSame(oldItem: EmployeeX, newItem: EmployeeX) =
//            oldItem.name == newItem.name
//
//        override fun areContentsTheSame(oldItem: EmployeeX, newItem: EmployeeX) =
//            oldItem == newItem
//    }

    companion object {
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(image: ImageView, employee: String) {
            Glide.with(image)
                .load(employee)
                .circleCrop()
                .placeholder(R.drawable.ic_launcher_foreground)//check without internet
                .error(R.drawable.ic_launcher_foreground)
                .fallback(R.drawable.ic_launcher_foreground)
                .into(image)
        }
    }

    override fun getItemCount(): Int = employee.size

    fun addUsers(users: List<EmployeeX>) {
        this.employee.apply {
            clear()
            addAll(users)
        }
    }
}