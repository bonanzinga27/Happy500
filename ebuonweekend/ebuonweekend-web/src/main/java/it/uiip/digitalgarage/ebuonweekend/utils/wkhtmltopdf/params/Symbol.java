package it.uiip.digitalgarage.ebuonweekend.utils.wkhtmltopdf.params;

/**
 * Created by 1996384 on 22/11/2016.
 */
public enum Symbol {
    separator(" "),
    param("");

    private String symbol;

    private Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String toString() {
        return this.symbol;
    }
}
