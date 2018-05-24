package com.navadviser.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.navadviser.entity.PoI;
import com.navadviser.entity.PoiType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@Qualifier("DataAccessServiceStub")
public class PoiServiceImplStub implements PoiService {
    private ObjectMapper objectMapper;
    private List<PoI> poiList;

    @PostConstruct
    public void init() throws Exception {
        final TypeReference<List<PoI>> poiListTypeReference = new TypeReference<List<PoI>>() {};
        objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        poiList = readDataFromJsonFile(poiListTypeReference);
    }

    @Override
    public List<PoI> getNearestPoi(Double latitude, Double longitude, Integer distance, PoiType poiType) {
        return poiList;
    }

    private List<PoI> readDataFromJsonFile(TypeReference<List<PoI>> poiListTypeReference) throws Exception {
        byte[] src = Files.readAllBytes(Paths.get(this.getClass().getClassLoader().getResource("samplePoI.json").getFile()));
        return objectMapper.readValue(src, poiListTypeReference);
    }
}
