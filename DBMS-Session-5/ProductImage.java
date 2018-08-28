package storeFrontApplication;

/**
 * This class represents Images for a product. 
 *
 */
public class ProductImage {
    private int productId;
    private int imageId;
    private String imageUrl;
    private String imageTag;
    
    public ProductImage(int productId,int imageId,String imageUrl,String imageTag)
    {
        this.productId=productId;
        this.imageId=imageId;
        this.imageUrl=imageUrl;
        this.imageTag=imageTag;
    }
    
    public int getProductId() {
        return productId;
    }
    
    public void setProductId(int productId) {
        this.productId = productId;
    }
    
    public int getImageId() {
        return imageId;
    }
    
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    
    public String getImageUrl() {
        return imageUrl;
    }
    
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public String getImageTag() {
        return imageTag;
    }
    
    public void setImageTag(String imageTag) {
        this.imageTag = imageTag;
    }

}