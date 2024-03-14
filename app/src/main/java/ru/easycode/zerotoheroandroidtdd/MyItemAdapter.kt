package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.databinding.ItemLayoutBinding

class MyItemAdapter : RecyclerView.Adapter<MyItemAdapter.ItemViewHolder>() {

    private var items = ArrayList<String>()

    fun addElement(element: String){
        val newList = ArrayList(items)
        newList.add(element)
        items = newList
        notifyItemInserted(items.size - 1)
    }

    fun save(bundle: Bundle){
        bundle.putStringArrayList(KEY, items)
    }

    fun restore(bundle: Bundle){
        bundle.getStringArrayList(KEY)?.let { items = it }
        notifyItemRangeInserted(0, items.size - 1)
    }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLayoutBinding.inflate(inflater, parent, false)
        return  ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.binding.root.text = item
    }

    class ItemViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    companion object{
        const val KEY = "key"
    }
}