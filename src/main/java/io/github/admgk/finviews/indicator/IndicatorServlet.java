package io.github.admgk.finviews.indicator;

import jakarta.servlet.http.HttpServletRequest;

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
        return ResponseEntity.ok(service.invokeRepositoryOf(indicator));
    }
}
