package com.codedojo.three.three.api;

import com.codedojo.three.three.service.RangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Range {

    @Autowired
    private RangeService rangeService;

    @RequestMapping(method = RequestMethod.GET, value = "/range/{range}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getRange(@PathVariable(value = "range") String range) {
        rangeService.findRange(Integer.valueOf(range));
        return ResponseEntity.of(null);
    }


}
