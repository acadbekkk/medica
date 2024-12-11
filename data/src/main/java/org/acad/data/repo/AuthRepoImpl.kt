package org.acad.data.repo

import org.acad.data.remote.auth.AuthFirebase
import org.acad.domain.repo.AuthRepo

/**
 * Created by Acad Bek on 12/11/2024
 */
class AuthRepoImpl constructor(
    private val authFirebase: AuthFirebase
) : AuthRepo {
    override fun sendEmailCode(email: String) {
        authFirebase.sendEmailCode(email)
    }
}