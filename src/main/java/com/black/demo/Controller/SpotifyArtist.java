package com.black.demo.Controller;

import com.black.demo.Service.TokenGen;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;
//import com.black.demo.Service.TokenGen.tokenGenFunc;

@RestController
public class SpotifyArtist {
    private static final String BASE_URL = "https://api.spotify.com/v1/artists/";

    @GetMapping("/api/artist")
    public ResponseEntity<String> getArtistInfo(
            @RequestParam("name") String artistName
    ) {
        String token = "BQC7K-AVF9F3bo-8QFA01u1Gmi6gBzoL9z2ZWzsF7R5fql8lwqAgocXQNxszBSJHUF3Z5HH97qS9AY9mVvM5dMqFozfRDkcJ9IMC7O1I4t-ehpuA3Dk";

//        String spotifyApiUrl = BASE_URL + getArtistId(artistName);
        String spotifyApiUrl = BASE_URL + "5EEuae5uigQnwgYCl0s8EF?si=O959qTMbQiO53-HgLcsIcA"; //Teminite

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        RequestEntity<?> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, UriComponentsBuilder.fromHttpUrl(spotifyApiUrl).build().toUri());
        ResponseEntity<String> responseEntity = new RestTemplate().exchange(requestEntity, String.class);

        return ResponseEntity.status(responseEntity.getStatusCode()).body(responseEntity.getBody());
    }

    @GetMapping("/api/token")
    public ResponseEntity<String> getTokenInfo() throws JsonProcessingException {
        TokenGen tokenGen = new TokenGen();
        return ResponseEntity.status(200).body(tokenGen.tokenGenFunc());
    }
}

