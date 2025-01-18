package org.acad.domain.usecase.settings

import org.acad.domain.repo.SettingsRepo

/**
 * Created by Acad Bek on 12/30/2024
 */
class GetOnboardedUseCase(
    private val settingsRepo: SettingsRepo
) {
    operator fun invoke() = settingsRepo.getBoarded()
}