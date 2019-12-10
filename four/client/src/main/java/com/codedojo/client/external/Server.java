package com.codedojo.client.external;

import com.codedojo.client.model.dto.CreateDeerDto;
import com.codedojo.client.model.dto.MovedDeerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

@FeignClient(name = "Server", url = "http://XXX.XXX.XXX.XXX:8080/")
public interface Server {

    @RequestMapping(method = RequestMethod.POST, value = "/createBlindeer/{color}")
    CreateDeerDto createBlindeer(@PathVariable(value = "color") String color);

    @RequestMapping(method = RequestMethod.POST, value = "/{id}/move/{move}")
    MovedDeerDto moveRaindeer(@PathVariable(value = "id") UUID id, @PathVariable(value = "move") String move);
}
