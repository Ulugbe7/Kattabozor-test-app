package uz.ultimatedevs.kattabozordemo1.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.ultimatedevs.kattabozordemo1.data.model.response.OfferData
import uz.ultimatedevs.kattabozordemo1.databinding.ItemOfferBinding

class OffersAdapter : ListAdapter<OfferData, OffersAdapter.ViewHolder>(OffersDifUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemOfferBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind()

    inner class ViewHolder(private val binding: ItemOfferBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            with(binding) {
                val d = getItem(absoluteAdapterPosition)
                txtName.text = d.name
                txtBrand.text = d.brand
                txtCategory.text = d.category
                txtDescription.text = d.attributes.joinToString(separator = ", ")
                Glide.with(itemView.context).load(d.image.url)
                    .override(d.image.width.toInt(), d.image.height.toInt()).into(image)
            }
        }
    }

    private object OffersDifUtil : DiffUtil.ItemCallback<OfferData>() {
        override fun areItemsTheSame(oldItem: OfferData, newItem: OfferData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: OfferData, newItem: OfferData): Boolean {
            return oldItem.name == newItem.name && oldItem.category == newItem.category && oldItem.brand == newItem.brand
        }

    }
}