package com.fastcampus.userservice.controller

import com.fastcampus.userservice.model.*
import com.fastcampus.userservice.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/users")
class UserController(
    private val userService: UserService,
){
    @PostMapping("/signup")
    suspend fun signUp(@RequestBody request: SignUpRequest){
        userService.signUp(request)
    }

    @PostMapping("/signin")
    suspend fun signIn(@RequestBody signInRequest: SignInRequest): SignInResponse {
        return userService.signIn(signInRequest)
    }

    @DeleteMapping("/logout")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    suspend fun logout(@AuthToken token: String){
        //어노테이션이 있으면, DTO에 자동매핑
        userService.logout(token)
    }

    @GetMapping("/me")
    suspend fun get(
        @AuthToken token: String
    ): MeResponse {
        return MeResponse(userService.getByToken(token))
    }
}