package com.shubin.dz24.task1;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimezoneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String city = req.getPathInfo().split("/")[1];
        String timezone;
        switch (city) {
            case "washington":
                timezone = "America/New_York";
                break;
            case "beijing":
                timezone = "Asia/Hong_Kong";
                break;
            default:
                timezone = "Europe/Minsk";
                break;
        }

        ZoneId zone = ZoneId.of(timezone);
        ZonedDateTime zdt = ZonedDateTime.now(zone);

        resp.setStatus(200);
        resp.getOutputStream().print(zdt.toString());
    }
}
