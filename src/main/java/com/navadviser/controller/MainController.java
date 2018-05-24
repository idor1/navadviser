package com.navadviser.controller;

import com.navadviser.entity.PoI;
import com.navadviser.entity.PoiType;
import com.navadviser.service.PoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
    private PoiService poiService;

    @Autowired
    public MainController(PoiService poiService) {
        this.poiService = poiService;
    }

    @GetMapping("/poi")
    public List<PoI> getNearestPoi(
            @RequestParam(required = false, defaultValue = "0") Double latitude,
            @RequestParam(required = false, defaultValue = "0") Double longitude,
            @RequestParam(required = false, defaultValue = "0") Integer distance,
            @RequestParam(required = false, defaultValue = "") PoiType poiType) throws Exception {
        return poiService.getNearestPoi(latitude, longitude, distance, poiType);
    }
}
