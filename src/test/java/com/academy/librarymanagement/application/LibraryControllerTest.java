package com.academy.librarymanagement.application;

import com.academy.librarymanagement.domain.BookDto;
import com.academy.librarymanagement.infra.crosscutting.LibraryActions;
import com.academy.librarymanagement.mock.BookMock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;

import java.util.Map;
import java.util.UUID;

import static com.academy.librarymanagement.config.HttpAndRestTemplateConfig.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@DisplayName("Library Controller")
class LibraryControllerTest {

    private static final String ENDPOINT = "/library-management/v1/books";

    private static final String URI = getUri(ENDPOINT);

    @MockBean
    private LibraryActions libraryActions;

    @Autowired
    private LibraryController libraryController;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldCreateBook() throws JSONException {
        var id = UUID.randomUUID().toString();
        var title = "Harry Potter";
        var image = "https://i.imgur.com/UH3IPXw.jpg";
        var publisher = "Rocco";
        var writers = new JSONArray()
                .put("JK Rowling");

        var dto = new JSONObject()
                .put("title", title)
                .put("image", image)
                .put("publisher", publisher)
                .put("writers", writers).toString();

        doReturn(id).when(libraryActions).createOneBook(any());

        var response = restTemplate.exchange(
                URI, POST, getHttpEntity(dto), BookDto.class);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(CREATED);
        assertThat(response.getBody()).isNull();
        assertThat(response.getHeaders()).isNotNull();

        verify(libraryActions, times(1)).createOneBook(any());
    }

    @Test
    void shouldWhenTitleIsNotPresent() throws JSONException {
        var id = UUID.randomUUID().toString();
        var image = "https://i.imgur.com/UH3IPXw.jpg";
        var publisher = "Rocco";
        var writers = new JSONArray()
                .put("JK Rowling");

        var dto = new JSONObject()
                .put("image", image)
                .put("publisher", publisher)
                .put("writers", writers).toString();

        doReturn(id).when(libraryActions).createOneBook(any());

        var response = restTemplate.exchange(
                URI, POST, getHttpEntity(dto), BookDto.class);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(BAD_REQUEST);
        assertThat(response.getBody()).isNotNull();

        verify(libraryActions, never()).createOneBook(any());
    }

    @Test
    void shouldWhenImageIsNotPresent() throws JSONException {
        var id = UUID.randomUUID().toString();
        var title = "Harry Potter";
        var publisher = "Rocco";
        var writers = new JSONArray()
                .put("JK Rowling");

        var dto = new JSONObject()
                .put("title", title)
                .put("publisher", publisher)
                .put("writers", writers).toString();

        doReturn(id).when(libraryActions).createOneBook(any());

        var response = restTemplate.exchange(
                URI, POST, getHttpEntity(dto), BookDto.class);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(BAD_REQUEST);
        assertThat(response.getBody()).isNotNull();

        verify(libraryActions, never()).createOneBook(any());
    }

    @Test
    void shouldWhenPublisherIsNotPresent() throws JSONException {
        var id = UUID.randomUUID().toString();
        var title = "Harry Potter";
        var image = "https://i.imgur.com/UH3IPXw.jpg";
        var writers = new JSONArray()
                .put("JK Rowling");

        var dto = new JSONObject()
                .put("title", title)
                .put("image", image)
                .put("writers", writers).toString();

        doReturn(id).when(libraryActions).createOneBook(any());

        var response = restTemplate.exchange(
                URI, POST, getHttpEntity(dto), BookDto.class);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(BAD_REQUEST);
        assertThat(response.getBody()).isNotNull();

        verify(libraryActions, never()).createOneBook(any());
    }

    @Test
    void shouldWhenWritersIsNotPresent() throws JSONException {
        var id = UUID.randomUUID().toString();
        var title = "Harry Potter";
        var publisher = "Rocco";
        var image = "https://i.imgur.com/UH3IPXw.jpg";

        var dto = new JSONObject()
                .put("title", title)
                .put("image", image)
                .put("publisher", publisher).toString();

        doReturn(id).when(libraryActions).createOneBook(any());

        var response = restTemplate.exchange(
                URI, POST, getHttpEntity(dto), BookDto.class);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(BAD_REQUEST);
        assertThat(response.getBody()).isNotNull();

        verify(libraryActions, never()).createOneBook(any());
    }
}
