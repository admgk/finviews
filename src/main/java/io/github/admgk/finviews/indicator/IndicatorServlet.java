package io.github.admgk.finviews.indicator;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.micrometer.core.ipc.http.HttpSender.Response;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
class IndicatorServlet {
    private static final String IND_PARAM = "ind";

    private IndicatorService service;

    IndicatorServlet(IndicatorService service) {
        this.service = service;
     }

    @GetMapping("/indicator")
    ResponseEntity<IndicatorDTO> findIndicatorById (HttpServletRequest req) {
        var indicator = req.getParameter(IND_PARAM);

        return ResponseEntity.ok(service.findAll());
    }
}
