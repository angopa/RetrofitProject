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
        mockWebServer.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody("{}"));

        RecordedRequest request = mockWebServer.takeRequest();
        Assert.assertEquals("POST /v1/chat/send HTTP/1.1", request.getRequestLine());
        Assert.assertEquals("{data{}}", request.getBody().readUtf8());
    }
}
