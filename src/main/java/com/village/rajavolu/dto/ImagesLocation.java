package com.village.rajavolu.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * User: user
 * Date: 3/21/16
 * Time: 8:07 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
@Table(name = "IMAGES_LOCATION")
public class ImagesLocation extends BaseDto {

    private String imagesPath;
    private String eventName;

    @Column(name = "IMAGES_PATH")
    public String getImagesPath() {
        return imagesPath;
    }

    public void setImagesPath(String imagesPath) {
        this.imagesPath = imagesPath;
    }

    @Column(name = "EVENT_NAME")
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }





}
