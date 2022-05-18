package com.embassylegacy.newsapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticles(article: List<NewsArticle>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBreakingNews(breakingNews: List<BreakingNews>)

    @Query("SELECT * FROM breaking_news INNER JOIN news_articles ON articleUrl=url")
    fun getAllBreakingNewsArticles(): Flow<List<NewsArticle>>

    @Query("DELETE FROM breaking_news")
    suspend fun deleteAllBreakingNews()
}