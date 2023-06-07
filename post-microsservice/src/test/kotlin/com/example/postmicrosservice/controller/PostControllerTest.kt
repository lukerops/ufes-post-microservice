package com.example.postmicrosservice.controller

import org.springframework.boot.test.context.SpringBootTest
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verify
import com.example.postmicrosservice.model.Post
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.mock
import org.mockito.Mock
import com.example.postmicrosservice.model.PostBuilder
import com.example.postmicrosservice.model.MediaBuilder
import com.example.postmicrosservice.model.AuthorBuilder
import com.example.postmicrosservice.service.PostService
import com.example.postmicrosservice.service.MediaService
import com.example.postmicrosservice.service.AuthorService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mockito
import org.springframework.boot.test.mock.mockito.MockBean
import kotlin.random.Random

@SpringBootTest
class PostControllerTest {

    private lateinit var postController: PostController

    @MockBean
    private lateinit var postService: PostService

    @BeforeEach
    fun setup() {
        postController = PostController(postService)
    }

    @Test
    fun `should create a post`(){
        val post = PostBuilder().build()

        Mockito.`when`(postService.createPost(post)).thenReturn(post)

        postController.create(post)

        Mockito.verify(postService, Mockito.times(1)).createPost(post)
    }

    @Test
    fun `should update a post`(){
        val post = PostBuilder().build()

        Mockito.`when`(postService.updatePost(post)).thenReturn(true)

        postController.update(post)

        Mockito.verify(postService, Mockito.times(1)).updatePost(post)
    }

    @Test
    fun `should delete a post`(){
        val post = PostBuilder().build()

        Mockito.`when`(postService.deletePost(post.id)).thenReturn(true)

        postController.delete(post.id)

        Mockito.verify(postService, Mockito.times(1)).deletePost(post.id)
    }

    @Test
    fun `should get a post`(){
        val post = PostBuilder().build()
        
        Mockito.`when`(postService.getPost(post.id)).thenReturn(post)

        postController.get(post.id)

        Mockito.verify(postService, Mockito.times(1)).getPost(post.id)
    }

    @Test
    fun `should get all media by postId`(){
        var id = Random.nextLong()

         val medias = listOf(MediaBuilder().apply {
            postId = id
         }.build())

         Mockito.`when`(mediaService.getPostByMedia(id)).thenReturn(medias)

         postController.getByMedia(id)

         Mockito.verify(mediaService, Mockito.times(1)).getPostByMedia(id)
    }

    @Test
    fun `should get all posts by author`(){
        var id = Random.nextLong()

        val posts = listOf(AuthorBuilder().apply {
            postId = id
        }.build())

        Mockito.`when`(authorService.getPostByAuthor(id)).thenReturn(posts)

        postController.getByAuthor(id)

        Mockito.verify(authorService, Mockito.times(1)).getPostByAuthor(id)
    }
}
