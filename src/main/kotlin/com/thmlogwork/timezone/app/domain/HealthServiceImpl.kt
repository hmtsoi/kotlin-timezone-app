package com.thmlogwork.timezone.app.domain

import org.springframework.stereotype.Service

@Service
class HealthServiceImpl : HealthService {

    override fun getHealth() = Health()
}