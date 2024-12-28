package org.acad.domain.usecase.auth

import org.acad.domain.repo.AuthRepo

/**
 * Created by Acad Bek on 12/28/2024
 */
class SendEmailCodeUseCase constructor(
    private val authRepo: AuthRepo
) {
    operator fun invoke(email: String) { authRepo.sendEmailCode(email) }
}