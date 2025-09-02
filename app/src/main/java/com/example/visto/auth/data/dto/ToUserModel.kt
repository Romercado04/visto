package com.example.visto.auth.data.dto

import com.example.visto.auth.domain.models.UserModel
import com.google.firebase.auth.FirebaseUser


fun FirebaseUser.toUserModel() = UserModel(
    uid = this.uid,
    name = this.displayName,
    email = this.email
)
