package ru.easycode.zerotoheroandroidtdd

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.databinding.ElementTextViewBinding

class MyRecyclerViewAdapter :
    RecyclerView.Adapter<MyRecyclerViewAdapter.UserViewHolder>() {

    var adapterList = ArrayList<CharSequence>()

    fun update(newList: List<CharSequence>){
        val diffUtil = DiffUtilCallback(newList = newList, oldList = adapterList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        adapterList.clear()
        adapterList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun getItemCount(): Int = adapterList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ElementTextViewBinding.inflate(inflater, parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val text = adapterList[position]
        holder.bind(text)
    }

    class UserViewHolder(private val binding: ElementTextViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(text: CharSequence) {
            binding.root.text = text
        }
    }

    class DiffUtilCallback(
        private val oldList : List<CharSequence>,
        private val newList : List<CharSequence>,
    ) : DiffUtil.Callback(){
        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }
}
