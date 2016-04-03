package com.village.rajavolu.service.impl;

import com.village.rajavolu.dao.ImagesLocationDao;
import com.village.rajavolu.dto.ImagesLocation;
import com.village.rajavolu.form.ImagesLocationForm;
import com.village.rajavolu.service.ImagesLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.*;

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

    @Transactional(value = "rajavoluTransactionManager", propagation = Propagation.REQUIRED)
    public void saveImageLocation(ImagesLocationForm imagesLocationForm) {
        ImagesLocation imagesLocation = new ImagesLocation();
        imagesLocation.setImagesPath(imagesLocationForm.getImagesLocation());
        imagesLocation.setEventName(imagesLocationForm.getEventName());
        imagesLocation.setLastUpdatedBy(imagesLocationForm.getUploadedUser());
        imagesLocation.setLastUpdated(Calendar.getInstance().getTime());
        imagesLocationDao.create(imagesLocation);
    }


    public List<ImagesLocationForm> loadAllImageLocations(){
        List<ImagesLocation> imagesLocationList = imagesLocationDao.loadAll();
        List<ImagesLocationForm> imagesLocationFormList = new ArrayList<ImagesLocationForm>();
        for(ImagesLocation imagesLocation : imagesLocationList) {
            ImagesLocationForm imagesLocationForm = new ImagesLocationForm();
            imagesLocationForm.setImagesLocation(imagesLocation.getImagesPath());
            imagesLocationForm.setEventName(imagesLocation.getEventName());
            imagesLocationFormList.add(imagesLocationForm);
        }
        return imagesLocationFormList;
    }
}
