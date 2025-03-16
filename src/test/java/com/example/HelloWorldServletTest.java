package com.example;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class HelloWorldServletTest {

    @Test
    public void testDoGet() throws Exception {
        // Create mock HttpServletRequest and HttpServletResponse
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        
        // Create the servlet
        HelloWorldServlet servlet = new HelloWorldServlet();
        
        // Call doGet
        servlet.doGet(request, response);

        // Verify if the content is correctly written to the response
        verify(response).getWriter();
    }
}

