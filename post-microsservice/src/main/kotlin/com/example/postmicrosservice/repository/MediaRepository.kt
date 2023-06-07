package com.example.postmicrosservice.repository

import com.example.postmicrosservice.model.Media
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MediaRepository: CrudRepository<Media, Long>{
    fun findByMediaId(mediaId: Long): List<Media>

    fun findByPostId(postId: Long): Media?

}

