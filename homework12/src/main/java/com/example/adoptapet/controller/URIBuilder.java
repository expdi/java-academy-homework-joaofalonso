package com.example.adoptapet.controller;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
@Component
public class URIBuilder {
        public URI getURI(long id){

            URI newResource = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(id)
                    .toUri();

            return newResource;

        }

}
