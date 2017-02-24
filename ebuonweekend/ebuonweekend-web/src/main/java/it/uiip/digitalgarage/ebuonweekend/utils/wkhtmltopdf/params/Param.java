package it.uiip.digitalgarage.ebuonweekend.utils.wkhtmltopdf.params;

/**
 * Created by 1996384 on 22/11/2016.
 */

public class Param {
    private String key;
    private String value;

    public Param(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public Param(String key) {
        this(key, (String)null);
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String toString() {
        StringBuilder sb = (new StringBuilder()).append(Symbol.separator).append(Symbol.param).append(this.key);
        if(this.value != null) {
            sb.append(Symbol.separator).append(this.value);
        }

        return sb.toString();
    }
}
