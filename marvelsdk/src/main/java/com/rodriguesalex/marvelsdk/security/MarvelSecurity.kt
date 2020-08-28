package com.rodriguesalex.marvelsdk.security

import com.rodriguesalex.commoms.extensions.md5
import java.util.Date

class MarvelSecurity {

    companion object {

        const val PUBLIC_KEY = "24ee0aeded0cc8ba4b26f8617278fa39"
        private const val PRIVATE_KEY = "5f34e81bc5e61b93adbdf0b83d882a20341bd8b9"

        val timestamp = Date().time.toString()

        fun hash() =
            (timestamp + PRIVATE_KEY + PUBLIC_KEY).md5()
    }
}
