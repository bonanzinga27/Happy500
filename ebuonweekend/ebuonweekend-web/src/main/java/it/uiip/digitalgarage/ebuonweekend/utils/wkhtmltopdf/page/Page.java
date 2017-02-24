package it.uiip.digitalgarage.ebuonweekend.utils.wkhtmltopdf.page;

/**
 * Created by 1996384 on 22/11/2016.
 */

public class Page {
    private String source;
    private PageType type;

    public Page(String source, PageType type) {
        this.source = source;
        this.type = type;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public PageType getType() {
        return this.type;
    }

    public void setType(PageType type) {
        this.type = type;
    }
}
