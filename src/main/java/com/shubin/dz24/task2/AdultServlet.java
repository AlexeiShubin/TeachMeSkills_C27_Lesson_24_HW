package com.shubin.dz24.task2;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import java.io.IOException;
import java.util.stream.Collectors;

public class AdultServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String requestBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        JSONObject json = new JSONObject(requestBody);
        int age = json.getInt("age");
        if (age >= 18) {
            resp.getOutputStream().print("Adult");
        } else {
            resp.getOutputStream().print("Not adult");
        }
    }

}
