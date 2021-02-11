package tn.enis.enismap.adapters;

public class PlaceItem {
    private String placeName;
    private int logoImage;

    public PlaceItem(String placeName, int logoImage) {
        this.placeName = placeName;
        this.logoImage = logoImage;
    }

    public String getPlaceName() {
        return placeName;
    }

    public int getLogoImage() {
        return logoImage;
    }
}