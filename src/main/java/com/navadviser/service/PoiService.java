package com.navadviser.service;

import com.navadviser.entity.PoI;
import com.navadviser.entity.PoiType;

import java.util.List;

/**
 * Created by supersergey on 24.05.18.
 */
public interface PoiService {
    List<PoI> getNearestPoi(Double latitude, Double longitude, Integer distance, PoiType poiType);
}
