package com.village.rajavolu.service;

import com.village.rajavolu.form.ImagesLocationForm;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 3/21/16
 * Time: 8:13 AM
 * To change this template use File | Settings | File Templates.
 */
public interface ImagesLocationService {

     public void saveImageLocation(ImagesLocationForm imagesLocationForm);

    public List<ImagesLocationForm> loadAllImageLocations();
}
