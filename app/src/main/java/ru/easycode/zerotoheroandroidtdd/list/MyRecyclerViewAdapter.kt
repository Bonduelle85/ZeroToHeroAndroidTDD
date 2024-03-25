package ru.easycode.zerotoheroandroidtdd.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.databinding.ElementTextViewBinding

class MyRecyclerViewAdapter :
    ListAdapter<CharSequence, MyRecyclerViewAdapter.MyViewHolder>(DiffUtilCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ElementTextViewBinding.inflate(inflater, parent, false)
        // тут можно назначить обработчики событий
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val  text = getItem(position)
        holder.binding.root.text = text
    }

    class MyViewHolder(val binding: ElementTextViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    object DiffUtilCallback: DiffUtil.ItemCallback<CharSequence>(){
        override fun areItemsTheSame(oldItem: CharSequence, newItem: CharSequence): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CharSequence, newItem: CharSequence): Boolean {
            return oldItem.length == newItem.length // типа сравнили контент :)
        }
    }
}