package ru.easycode.zerotoheroandroidtdd

interface Repository {

    suspend fun load(): SimpleResponse

    class Base(val service: SimpleService, val url: String): Repository {

        override suspend fun load(): SimpleResponse {
            return service.fetch(url)
        }
    }
}