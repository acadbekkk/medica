package org.acad.data.local.settings

import io.realm.kotlin.types.ObjectId
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

/**
 * Created by Acad Bek on 12/30/2024
 */
@Suppress("DEPRECATION")
class SettingsRealm() : RealmObject {
    @PrimaryKey
    var id: ObjectId = ObjectId.create()
    var onboarded: Boolean = false
}