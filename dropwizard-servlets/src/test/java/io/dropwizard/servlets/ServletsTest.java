package io.dropwizard.servlets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServletsTest {
    private final HttpServletRequest request = mock(HttpServletRequest.class);
    private final HttpServletRequest fullRequest = mock(HttpServletRequest.class);

    @BeforeEach
    public void setUp() throws Exception {
        when(request.getRequestURI()).thenReturn("/one/two");
        when(fullRequest.getRequestURI()).thenReturn("/one/two");
        when(fullRequest.getQueryString()).thenReturn("one=two&three=four");
    }

    @Test
    public void formatsBasicURIs() throws Exception {
        assertThat(Servlets.getFullUrl(request))
                .isEqualTo("/one/two");
    }

    @Test
    public void formatsFullURIs() throws Exception {
        assertThat(Servlets.getFullUrl(fullRequest))
                .isEqualTo("/one/two?one=two&three=four");
    }
}
