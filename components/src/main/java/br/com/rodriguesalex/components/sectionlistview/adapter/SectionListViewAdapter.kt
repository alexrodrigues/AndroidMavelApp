package br.com.rodriguesalex.components.sectionlistview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.rodriguesalex.components.R
import br.com.rodriguesalex.components.sectionlistview.sectionview.SectionView
import br.com.rodriguesalex.components.sectionlistview.sectionview.vo.SectionViewVo

class SectionListViewAdapter(
    private val vos: List<SectionViewVo>
): RecyclerView.Adapter<SectionListViewAdapter.SectionListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionListViewHolder =
        SectionListViewHolder(
            SectionView(parent.context)
        )

    override fun onBindViewHolder(holder: SectionListViewHolder, position: Int) =
        holder.bind(vos[position])

    override fun getItemCount(): Int = vos.size

    inner class SectionListViewHolder(itemView: SectionView):  RecyclerView.ViewHolder(itemView) {

        fun bind(vo: SectionViewVo) {
            (itemView as SectionView).bind(vo)
        }
    }

}