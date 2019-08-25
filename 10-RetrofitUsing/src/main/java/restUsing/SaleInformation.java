
package restUsing;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SaleInformation {

    @SerializedName("saleTypeId")
    @Expose
    private String saleTypeId;
    @SerializedName("saleType")
    @Expose
    private String saleType;

    public String getSaleTypeId() {
        return saleTypeId;
    }

    public void setSaleTypeId(String saleTypeId) {
        this.saleTypeId = saleTypeId;
    }

    public String getSaleType() {
        return saleType;
    }

    public void setSaleType(String saleType) {
        this.saleType = saleType;
    }

}
