package com.febryan.datacovid_19.model

import com.google.gson.annotations.SerializedName

data class Attributes(

	@SerializedName("FID")
	val fID: Int,

	@SerializedName("Kode_Provi")
	val kodeProvi: Int,

	@SerializedName("Kasus_Meni")
	val kasusMeni: Int,

	@SerializedName("Kasus_Posi")
	val kasusPosi: Int,

	@SerializedName("Provinsi")
	val provinsi: String,

	@SerializedName("Kasus_Semb")
	val kasusSemb: Int

)