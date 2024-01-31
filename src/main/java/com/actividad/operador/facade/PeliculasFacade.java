package com.actividad.operador.facade;

import com.actividad.operador.model.Pelicula;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
@Slf4j
public class PeliculasFacade {

    @Value("http://ms-inventory-peliculas/peliculas/%s")
    private String getPeliculaUrl;

    private final RestTemplate restTemplate;

    public Pelicula getPelicula(String id) {

        try {
            String url = String.format(getPeliculaUrl, id);
            log.info("Getting pelicula with ID {}. Request to {}", id, url);
            return restTemplate.getForObject(url, Pelicula.class);
        } catch (HttpClientErrorException e) {
            log.error("Client Error: {}, Pelicula with ID {}", e.getStatusCode(), id);
            return null;
        } catch (HttpServerErrorException e) {
            log.error("Server Error: {}, Pelicula with ID {}", e.getStatusCode(), id);
            return null;
        } catch (Exception e) {
            log.error("Error: {}, Pelicula with ID {}", e.getMessage(), id);
            return null;
        }
    }

}
