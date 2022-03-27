package com.academy.librarymanagement.inbound;

import com.academy.librarymanagement.adapters.config.exception.GlobalExceptionHandler;
import com.academy.librarymanagement.adapters.in.LibraryController;
import com.academy.librarymanagement.domain.Book;
import com.academy.librarymanagement.domain.FilteredBook;
import com.academy.librarymanagement.ports.in.LibraryPortInbound;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = LibraryController.class)
@ContextConfiguration(classes = {GlobalExceptionHandler.class, LibraryController.class})
@DisplayName("Library Controller Test")
class LibraryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LibraryPortInbound libraryInbound;

    @Test
    void shouldReturnStatusOk() throws Exception {
        when(libraryInbound.findAll(any())).thenReturn(FilteredBook.builder().withBooks(List.of(Book.builder().build())).withTotal(1).build());

        mockMvc.perform(get(BookConstants.PATH)
                .queryParam("page", "0")
                .queryParam("limit", "1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}