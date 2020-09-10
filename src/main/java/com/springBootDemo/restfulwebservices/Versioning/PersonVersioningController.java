package com.springBootDemo.restfulwebservices.Versioning;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    @GetMapping("v1/person")
    public PersonV1 personV1() {
        return new PersonV1("Jae Lee");
    }

    @GetMapping("v2/person")
    public PersonV2 personV2() {
        return new PersonV2(new Name("Jae", "Lee"));
    }

    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
    public PersonV1 producesV1() {
        return new PersonV1("Jae Lee");
    }

    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
    public PersonV2 producesV2() {
        return new PersonV2(new Name("Jae", "Lee"));
    }
}