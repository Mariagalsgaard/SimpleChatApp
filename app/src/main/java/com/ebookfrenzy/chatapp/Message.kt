package com.ebookfrenzy.chatapp

import android.os.Parcelable

import kotlinx.android.parcel.Parcelize


@Parcelize
data class Message(var text: String="") : Parcelable