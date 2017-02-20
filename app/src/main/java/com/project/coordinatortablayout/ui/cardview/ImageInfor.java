package com.project.coordinatortablayout.ui.cardview;

/**
 * Created by meijing on 2017/2/19.
 */

public class ImageInfor {
    private String name;
    private int imageId;

    public ImageInfor(int imageId, String name) {
        this.imageId = imageId;
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
