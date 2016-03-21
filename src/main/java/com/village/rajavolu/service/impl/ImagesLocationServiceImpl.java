package com.village.rajavolu.service.impl;

import com.village.rajavolu.dao.ImagesLocationDao;
import com.village.rajavolu.dto.ImagesLocation;
import com.village.rajavolu.service.ImagesLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: user
 * Date: 3/21/16
 * Time: 8:14 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ImagesLocationServiceImpl implements ImagesLocationService {

    @Autowired
    private ImagesLocationDao imagesLocationDao;
    private Map<String, String> imageAndEventMap;

    @PostConstruct
    public void loadAllImageLocations(){
        List<ImagesLocation> imagesLocationList = imagesLocationDao.loadAll();
        imageAndEventMap = new HashMap<String, String>();
        for(ImagesLocation imagesLocation : imagesLocationList) {
            imageAndEventMap.put(imagesLocation.getImagesPath(), imagesLocation.getEventName());
        }
    }

}
