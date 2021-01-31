package br.com.rodriguesalex.components.sectionlistview.sectionview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.rodriguesalex.components.R
import br.com.rodriguesalex.components.sectionlistview.sectionview.vo.SectionItemViewVo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.view_component_section_item.view.*

class SectionViewAdapter(
    private val vos: List<SectionItemViewVo>
): RecyclerView.Adapter<SectionViewAdapter.SectionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder =
        SectionViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_component_section_item, parent, false)
        )

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        holder.bind(vos[position])
    }

    override fun getItemCount(): Int = vos.size

    inner class SectionViewHolder(itemView: View):  RecyclerView.ViewHolder(itemView) {

        fun bind(vo: SectionItemViewVo) {
            Picasso.get().load(vo.imageUrl).into(itemView.ivItemImage)
            itemView.tvItemTitle.text = vo.title
        }
    }
}