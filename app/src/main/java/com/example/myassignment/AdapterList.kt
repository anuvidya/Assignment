package com.example.myassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView


class AdapterList(private var itemList: List<Item>) : RecyclerView.Adapter<AdapterList.ViewHolder>(), Filterable  {

    private var filtered: List<Item> = itemList

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val card: CardView = view.findViewById(R.id.card)
        val title: TextView = view.findViewById(R.id.tvTitle)
        val subtitle: TextView = view.findViewById(R.id.tvSubTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return filtered.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        val item = filtered[position]
        holder.card.setBackgroundResource(item.imageId)
        holder.title.text = item.title
        holder.subtitle.text = item.subtitle

    }

    override fun getFilter(): Filter {

        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val queryString = constraint?.toString()?.lowercase()

                val filteredList = if (queryString.isNullOrEmpty()) {
                    itemList
                } else {
                    itemList.filter { item ->
                        item.title.lowercase().contains(queryString)
                    }
                }

                val filterResults = FilterResults()
                filterResults.values = filteredList
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filtered = results?.values as List<Item>
                notifyDataSetChanged()
            }
        }

    }


}