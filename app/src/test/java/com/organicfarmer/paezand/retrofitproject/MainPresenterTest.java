package com.organicfarmer.paezand.retrofitproject;

import com.organicfarmer.paezand.retrofitproject.data.api.RetrofitClient;
import com.organicfarmer.paezand.retrofitproject.data.model.Pixabay;
import com.organicfarmer.paezand.retrofitproject.ui.main.MainActivity;
import okhttp3.OkHttpClient;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

@RunWith(JUnit4.class)
public class MainPresenterTest {

    public static final String  ASSET_BASE_PATH = "../app/";

    @Rule
    public MockWebServer mockWebServer;

    private RetrofitClient client;

    @Mock
    MainActivity iMainView;

    @Before
    public void init() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();

        client = new Retrofit.Builder()
                .client(new OkHttpClient.Builder().build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(mockWebServer.url("/"))
                .build()
                .create(RetrofitClient.class);

        iMainView = new MainActivity();
    }

    @Test
    public void everythingOk() {
        Assert.assertNotNull(client);
    }

    @Test
    public void findPictures() throws IOException, InterruptedException {
        mockWebServer.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(readJsonFile("Pixabay.json")));
        final Response<Pixabay> response = client.getForecast("key", "query", "imageType").execute();
        final Pixabay pixabay = response.body();
        final RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assert.assertEquals(recordedRequest.getMethod(), "GET");
        Assert.assertEquals(recordedRequest.getPath(), "/api?key=key&q=query&image_type=imageType");
        Assert.assertTrue(!pixabay.isValid());
    }

    @After
    public void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    public String readJsonFile (String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(ASSET_BASE_PATH + fileName)));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            sb.append(line);
            line = br.readLine();
        }
        return sb.toString();
    }
}
