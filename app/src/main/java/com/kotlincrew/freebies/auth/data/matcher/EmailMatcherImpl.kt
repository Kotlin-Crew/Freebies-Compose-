package com.kotlincrew.freebies.auth.data.matcher

import android.util.Patterns
import com.kotlincrew.freebies.auth.domain.matcher.EmailMatcher

class EmailMatcherImpl : EmailMatcher {
    override fun isValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

}