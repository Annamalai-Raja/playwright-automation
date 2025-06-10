package apis;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static apis.Constants.BASE_URI;
import static apis.Constants.CREATE_SESSION;

public class Requests {

        static Playwright playwright = Playwright.create();
        static APIRequestContext request = playwright.request().newContext();



    public static void createSession(String cookie , String nodeId) {
        Map<String, Object> body = new HashMap<>();
        body.put("binCodes", List.of("B01A-001A"));
        body.put("numberOfWorkersToAssign", 1);

        RequestOptions options = RequestOptions.create()
                .setHeader("cookie", cookie)
                .setHeader("Content-Type", "application/json")
                .setQueryParam("whId", nodeId)
                .setQueryParam("dontIncludeNonVisibleInventory", true)
                .setData(body);

        APIResponse response = request.post(BASE_URI + CREATE_SESSION, options);

        if (response.ok()) {
            System.out.println("Session created: " + response.text());
        } else {
            System.err.println("Failed to create session. Status: " + response.status());
            System.err.println("Error: " + response.text());
        }

    }

}
