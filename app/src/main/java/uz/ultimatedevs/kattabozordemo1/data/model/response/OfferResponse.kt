package uz.ultimatedevs.kattabozordemo1.data.model.response

import com.google.gson.annotations.SerializedName


data class OfferResponse(
    @field:SerializedName("offers") val offers: List<OfferData>
)

data class OfferData(
    @field:SerializedName("id") val id: Long,
    @field:SerializedName("name") val name: String,
    @field:SerializedName("brand") val brand: String,
    @field:SerializedName("category") val category: String,
    @field:SerializedName("merchant") val merchant: String,
    @field:SerializedName("attributes") val attributes: List<OfferAttribute>,
    @field:SerializedName("image") val image: OfferImage
)

data class OfferAttribute(
    @field:SerializedName("name") val name: String, @field:SerializedName("value") val value: String


) {
    override fun toString(): String {
        return "$name: $value"
    }
}

data class OfferImage(
    @field:SerializedName("width") val width: Long,
    @field:SerializedName("height") val height: Long,
    @field:SerializedName("url") val url: String
)
