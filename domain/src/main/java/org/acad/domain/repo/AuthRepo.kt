package org.acad.domain.repo

/**
 * Created by Acad Bek on 12/11/2024
 */
interface AuthRepo {
    fun sendEmailCode(email: String)
}