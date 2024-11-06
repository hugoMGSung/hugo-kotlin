package com.hugo83.recyclerviewtest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val itemList: List<ItemData>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    // 뷰 홀더 정의
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemNumber: TextView = itemView.findViewById(R.id.itemNumber)
        val itemTitle: TextView = itemView.findViewById(R.id.itemTitle)
        val itemDate: TextView = itemView.findViewById(R.id.itemDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.itemNumber.text = "No. ${item.number}"
        holder.itemTitle.text = item.title
        holder.itemDate.text = item.date

        // 아이템 클릭 이벤트 설정
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Selected Item: ${item.title}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}