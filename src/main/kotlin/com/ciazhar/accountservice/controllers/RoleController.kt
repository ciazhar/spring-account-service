package com.ciazhar.accountservice.controllers

import com.ciazhar.accountservice.model.dto.response.DefaultResponse
import com.ciazhar.accountservice.model.dto.response.ResponseData
import com.ciazhar.accountservice.model.jpa.Role
import com.ciazhar.accountservice.repository.RoleRepository
import com.ciazhar.accountservice.service.RoleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*
import java.util.*

import javax.validation.Valid

/**
 * Created by ciazhar on 6/23/17.
 */

/**
 * Service yang menyediakan API role
 */
@RestController
@RequestMapping("api/role", "mobile/role")
class RoleController @Autowired constructor(private val service : RoleService){

    @PreAuthorize("hasAuthority('SUPER_USER')")
    @PostMapping("/save")
    fun save(@Valid @RequestBody role: Role): ResponseData<*> {
        return service.save(role)
    }

    @PreAuthorize("hasAuthority('SUPER_USER')")
    @GetMapping("/one")
    fun findOne(@RequestParam id: String): ResponseData<*> {
        return service.findOne(id)
    }

    @PreAuthorize("hasAuthority('SUPER_USER')")
    @GetMapping("/all")
    fun findAll(): ResponseData<*> {
        return service.findAll()
    }

    @PreAuthorize("hasAuthority('SUPER_USER')")
    @PostMapping("/delete")
    fun deleteRole(@RequestParam id: String): ResponseData<*> {
        return service.delete(id)
    }

}
