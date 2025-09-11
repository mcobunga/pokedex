package com.bonface.pokedex.helpers

import com.bonface.consumerapi.domain.Failure
import com.bonface.pokedex.R

fun Failure.toUiText(): UiText {
    return when(this) {
        is Failure.Network.RequestTimeout -> UiText.StringResource(R.string.the_request_timed_out)
        is Failure.Network.AccessDenied -> UiText.StringResource(R.string.unknown_error)
        is Failure.Network.TooManyRequests -> UiText.StringResource(R.string.youve_hit_your_rate_limit)
        is Failure.Network.NoInternet -> UiText.StringResource(R.string.no_internet)

        is Failure.Network.PayloadTooLarge -> UiText.StringResource(R.string.file_too_large)

        is Failure.Network.ServerError -> {
            if(message != null) {
                UiText.DynamicString(message.toString())
            } else UiText.StringResource(R.string.server_error)
        }
        is Failure.Network.Serialization -> UiText.StringResource(R.string.error_serialization)
        is Failure.Network.Unknown -> UiText.StringResource(R.string.unknown_error)
        is Failure.Local.DiskFull -> UiText.StringResource(R.string.error_disk_full)
    }
}