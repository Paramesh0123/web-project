package com.example;

import org.junit.Test;
import static org.junit.Assert.*;
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

        // Mock the PrintWriter that getWriter() will return
        PrintWriter writer = mock(PrintWriter.class);
        when(response.getWriter()).thenReturn(writer);

        // Create the servlet
        HelloWorldServlet servlet = new HelloWorldServlet();

        // Call doGet method
        servlet.doGet(request, response);

        // Verify that the PrintWriter's write() method was called with the correct content
        verify(writer).write("<h1>Hello World</h1>");
    }
}

