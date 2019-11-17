package com.codedojo.three.three.api;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Range {

    @RequestMapping(method = RequestMethod.GET, value = "/range/{range}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getRange(@PathVariable(value = "range") String range) {
        return ResponseEntity.of(null);
    }


}
