package ru.zettatech.grv.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.zettatech.grv.R
import ru.zettatech.grv.constant.Constant
import ru.zettatech.grv.item.Item

class ItemAdapter(private val itemList: List<Item>, private val onClickListener: OnClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface OnClickListener {
        fun onClick(item: Item, position: Int)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView
        val title: TextView

        init {
            image = view.findViewById(R.id.imageView)
            title = view.findViewById(R.id.nameView)
        }
    }

    class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView

        init {
            title = view.findViewById(R.id.nameView)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            Constant.TYPE_HEADER -> {
                val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_header, viewGroup, false)
                HeaderViewHolder(view)
            }
            Constant.TYPE_CONTENT -> {
                val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_content, viewGroup, false)
                ItemViewHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val item: Item = itemList.get(position)

        when (viewHolder.itemViewType) {
            Constant.TYPE_HEADER -> {
                val headerViewHolder = viewHolder as HeaderViewHolder
                headerViewHolder.title.text = item.getName()
            }

            Constant.TYPE_CONTENT -> {
                val itemViewHolder = viewHolder as ItemViewHolder
                itemViewHolder.title.text = item.getName()
                viewHolder.image.setImageResource(item.getResourceId())

                itemViewHolder.itemView.setOnClickListener {
                    onClickListener.onClick(item, position)
                }
            }
        }
    }

    // Увеличение на один для размещения заголовка
    override fun getItemCount() = itemList.size

    // Определение типа View для каждого элемента
    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            Constant.TYPE_HEADER
        } else {
            Constant.TYPE_CONTENT
        }
    }
}