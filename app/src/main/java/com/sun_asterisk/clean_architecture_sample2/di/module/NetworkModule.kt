package com.sun_asterisk.clean_architecture_sample2.di.module

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.sun_asterisk.clean_architecture_sample2.BuildConfig.API_KEY
import com.sun_asterisk.clean_architecture_sample2.data.remote.MovieService
import com.sun_asterisk.clean_architecture_sample2.data.repository.MoviesRepositoryImpl
import com.sun_asterisk.clean_architecture_sample2.domain.repository.MoviesRepository
import com.sun_asterisk.clean_architecture_sample2.domain.usecase.GetMoviesUseCase
import com.sun_asterisk.clean_architecture_sample2.utils.Constant
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val NetworkModule = module {

    single {
        createRetrofit(
            get(),
            CoroutineCallAdapterFactory(),
            Constant.BASE_URL,
            MovieService::class.java
        )
    }

    single { createOkHttpClient() }

    single { createGsonConverterFactory() }

}

fun createOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient.Builder()
        .connectTimeout(Constant.BASE_TIME_OUT, TimeUnit.MILLISECONDS)
        .readTimeout(Constant.BASE_TIME_OUT, TimeUnit.MILLISECONDS)
        .retryOnConnectionFailure(true)
        .addInterceptor(Interceptor { chain ->
            chain.proceed(buildRequest(chain))
        })
        .addInterceptor(httpLoggingInterceptor).build()
}

private fun buildRequest(chain: Interceptor.Chain) = chain.request()
    .newBuilder()
    .url(addApiKey(chain))
    .build()

private fun addApiKey(chain: Interceptor.Chain) = chain.request().url
    .newBuilder()
    .addQueryParameter("api_key", API_KEY)
    .build()

fun <T> createRetrofit(
    okHttpClient: OkHttpClient,
    callAdapterFactory: CoroutineCallAdapterFactory,
    url: String,
    restApi: Class<T>
): T {
    return Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addCallAdapterFactory(callAdapterFactory)
        .addConverterFactory(GsonConverterFactory.create()).build().create(restApi)
}

fun createGsonConverterFactory(): GsonConverterFactory {
    return GsonConverterFactory.create()
}

fun createMovieRepository(apiService: MovieService): MoviesRepository {
    return MoviesRepositoryImpl(apiService)
}

fun createGetMoviesUseCase(
    postsRepository: MoviesRepository
): GetMoviesUseCase {
    return GetMoviesUseCase(postsRepository)
}
