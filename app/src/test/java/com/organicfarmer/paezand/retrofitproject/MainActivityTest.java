package com.organicfarmer.paezand.retrofitproject;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

@RunWith(JUnit4.class)
public class MainActivityTest {

    private MockWebServer mockWebServer;

    @Before
    public void setUp() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
    }

    @After
    public void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    public void testRetrofitReturnListOfImages() throws InterruptedException {
        //Schedule some responses
        mockWebServer.enqueue(new MockResponse()
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .addHeader("Cache-Control", "no-cache")
                .setBody("hello world"));

        RecordedRequest request = mockWebServer.takeRequest();
        Assert.assertEquals("POST /v1/chat/send HTTP/1.1", request.getRequestLine());
//        Assert.assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"));
//        Assert.assertEquals("{Hello world}", request.getBody().readUtf8());
    }
}
