package com.geppetto.jated.controller;

import com.geppetto.jated.config.NewConstant;
import com.geppetto.jated.apiAdapter.ApiAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.lang.Exception;
import java.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.jsonwebtoken.*;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/")
public class NameModelController {

    @Autowired
    private ApiAdapter apiAdapter;



@PutMapping("/test/get/update")
public ResponseEntity<Object> GpSearchForUpdate(@RequestBody Object object,HttpServletRequest request, HttpServletResponse response) throws IOException{
        log.info("Enter into NameModelController : GpSearchForUpdate");
        try{
            String servletPath = request.getContextPath();
                    switch (servletPath) {
                        case "/mobile":
                        case "/web":
          Object result= apiAdapter.put(NewConstant.TESTURL + "/test/get/update",object,request);
          return ResponseEntity.ok(result);
          default:
                    String errorMessage = "Invalid servlet path: " + servletPath;
                     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
                    }
        }
        catch(Exception e){
        log.info("Exit into NameModelController : GpSearchForUpdate");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }
    }

@GetMapping("/test")
public ResponseEntity<Object> GpGetAllValues(HttpServletRequest request, HttpServletResponse response) throws IOException{
        log.info("Enter into NameModelController : GpGetAllValues");
        try{
            String servletPath = request.getContextPath();
                    switch (servletPath) {
                        case "/mobile":
                        case "/web":
          Object result= apiAdapter.get(NewConstant.TESTURL + "/test",request);
          return ResponseEntity.ok(result);
          default:
                    String errorMessage = "Invalid servlet path: " + servletPath;
                     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
                    }
        }
        catch(Exception e){
        log.info("Exit into NameModelController : GpGetAllValues");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }
    }

@DeleteMapping("/test/{id}")
public ResponseEntity<Object> GpDelete( @PathVariable String id,HttpServletRequest request, HttpServletResponse response) throws IOException{
        log.info("Enter into NameModelController : GpDelete");
        try{
            String servletPath = request.getContextPath();
                    switch (servletPath) {
                        case "/mobile":
                        case "/web":
          Object result= apiAdapter.delete(NewConstant.TESTURL + "/test/"+id,request);
          return ResponseEntity.ok(result);
          default:
                    String errorMessage = "Invalid servlet path: " + servletPath;
                     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
                    }
        }
        catch(Exception e){
        log.info("Exit into NameModelController : GpDelete");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }
    }

@GetMapping("/test/get/search")
public ResponseEntity<Object> GpSearch(HttpServletRequest request, HttpServletResponse response) throws IOException{
        log.info("Enter into NameModelController : GpSearch");
        try{
            String servletPath = request.getContextPath();
                    switch (servletPath) {
                        case "/mobile":
                        case "/web":
          Object result= apiAdapter.get(NewConstant.TESTURL + "/test/get/search",request);
          return ResponseEntity.ok(result);
          default:
                    String errorMessage = "Invalid servlet path: " + servletPath;
                     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
                    }
        }
        catch(Exception e){
        log.info("Exit into NameModelController : GpSearch");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }
    }

@PostMapping("/test")
public ResponseEntity<Object> GpCreate(@RequestBody Object object,HttpServletRequest request, HttpServletResponse response) throws IOException{
        log.info("Enter into NameModelController : GpCreate");
        try{
            String servletPath = request.getContextPath();
                    switch (servletPath) {
                        case "/mobile":
                        case "/web":
          Object result= apiAdapter.post(NewConstant.TESTURL + "/test",object,request);
          return ResponseEntity.ok(result);
          default:
                    String errorMessage = "Invalid servlet path: " + servletPath;
                     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
                    }
        }
        catch(Exception e){
        log.info("Exit into NameModelController : GpCreate");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }
    }

@GetMapping("/test/{id}")
public ResponseEntity<Object> GpGetEntityById( @PathVariable String id,HttpServletRequest request, HttpServletResponse response) throws IOException{
        log.info("Enter into NameModelController : GpGetEntityById");
        try{
            String servletPath = request.getContextPath();
                    switch (servletPath) {
                        case "/mobile":
                        case "/web":
          Object result= apiAdapter.get(NewConstant.TESTURL + "/test/"+id,request);
          return ResponseEntity.ok(result);
          default:
                    String errorMessage = "Invalid servlet path: " + servletPath;
                     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
                    }
        }
        catch(Exception e){
        log.info("Exit into NameModelController : GpGetEntityById");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }
    }

@GetMapping("/test/{id}")
public ResponseEntity<Object> GpGetEntityById( @PathVariable String id,HttpServletRequest request, HttpServletResponse response) throws IOException{
        log.info("Enter into NameModelController : GpGetEntityById");
        try{
            String servletPath = request.getContextPath();
                    switch (servletPath) {
                        case "/mobile":
                        case "/web":
          Object result= apiAdapter.get(NewConstant.TESTURL + "/test/"+id,request);
          return ResponseEntity.ok(result);
          default:
                    String errorMessage = "Invalid servlet path: " + servletPath;
                     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
                    }
        }
        catch(Exception e){
        log.info("Exit into NameModelController : GpGetEntityById");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }
    }

@GetMapping("/test/userid/created_by")
public ResponseEntity<Object> GpGetNounCreatedBy(HttpServletRequest request, HttpServletResponse response) throws IOException{
        log.info("Enter into NameModelController : GpGetNounCreatedBy");
        try{
            String servletPath = request.getContextPath();
                    switch (servletPath) {
                        case "/mobile":
                        case "/web":
          Object result= apiAdapter.get(NewConstant.TESTURL + "/test/userid/created_by",request);
          return ResponseEntity.ok(result);
          default:
                    String errorMessage = "Invalid servlet path: " + servletPath;
                     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
                    }
        }
        catch(Exception e){
        log.info("Exit into NameModelController : GpGetNounCreatedBy");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }
    }







    }

