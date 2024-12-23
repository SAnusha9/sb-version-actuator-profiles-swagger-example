package com.example.versioning.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.versioning.model.PersonV1;
import com.example.versioning.model.PersonV2;

@RestController
public class VersionedController {
@Value("${message}")
private String msg;
	// Versioning using URL Path
    @GetMapping("/v1/person")
    public PersonV1 getPersonV1ByUrl() {
        return new PersonV1("John Doe");
    }

    @GetMapping("/v2/person")
    public PersonV2 getPersonV2ByUrl() {
        return new PersonV2("John", "Doe");
    }

 // Versioning using Request Parameter
    @GetMapping(value = "/person", params = "version=1")
    public PersonV1 getPersonV1ByRequestParam() {
        return new PersonV1("John Doe");
    }

    @GetMapping(value = "/person", params = "version=2")
    public PersonV2 getPersonV2ByRequestParam() {
        return new PersonV2("John", "Doe");
    }

 // Versioning using Custom Header
    @GetMapping(value = "/person", headers = "X-API-VERSION=1")
    public PersonV1 getPersonV1ByHeader() {
        return new PersonV1("John Doe");
    }

    @GetMapping(value = "/person", headers = "X-API-VERSION=2")
    public PersonV2 getPersonV2ByHeader() {
        return new PersonV2("John", "Doe");
    }

 // Versioning using Accept Header
    @GetMapping(value = "/person", produces = "application/vnd.example.v1+json")
    public PersonV1 getPersonV1ByAcceptHeader() {
        return new PersonV1("John Doe");
    }

    @GetMapping(value = "/person", produces = "application/vnd.example.v2+json")
    public PersonV2 getPersonV2ByAcceptHeader() {
        return new PersonV2("John", "Doe");
    }
}
