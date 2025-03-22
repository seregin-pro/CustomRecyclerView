package ru.zettatech.grv.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.zettatech.grv.R
import ru.zettatech.grv.item.ParentItem

class ParentAdapter(
    private val parentItemList: List<ParentItem>,
    private val onParentItemClickListener: OnParentItemClickListener,
    private val onChildItemClickListener: ChildAdapter.OnChildItemClickListener
) : RecyclerView.Adapter<ParentAdapter.ViewHolder>() {

    interface OnParentItemClickListener {
        fun onParentItemClick(parentItem: ParentItem, position: Int)
        fun onForwardClick(parentItem: ParentItem, position: Int)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val parentId: TextView
        val title: TextView
        val forward: ImageView
        val child: RecyclerView

        init {
            parentId = view.findViewById(R.id.parent_id)
            title = view.findViewById(R.id.nameView)
            forward = view.findViewById(R.id.forward)
            child = view.findViewById(R.id.child)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_grid_parent, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val parentItem: ParentItem = parentItemList.get(position)

        viewHolder.parentId.text = parentItem.getParentId().toString()
        viewHolder.title.text = parentItem.getTitle()

        val childItemAdapter = ChildAdapter(parentItem.getChildItemList(), onChildItemClickListener)
        viewHolder.child.adapter = childItemAdapter

        // Click listener for the parent item
        viewHolder.itemView.setOnClickListener {
            onParentItemClickListener.onParentItemClick(parentItem, position)
        }

        // Click listener for the forward button
        viewHolder.forward.setOnClickListener {
            onParentItemClickListener.onForwardClick(parentItem, position)
        }
    }

    override fun getItemCount() = parentItemList.size
}


