package it.uiip.digitalgarage.ebuonweekend.utils.wkhtmltopdf;

/**
 * Created by 1996384 on 22/11/2016.
 */

import it.uiip.digitalgarage.ebuonweekend.utils.wkhtmltopdf.page.PageType;
import it.uiip.digitalgarage.ebuonweekend.utils.wkhtmltopdf.params.Param;

import java.io.IOException;

public interface PdfService {
    void addPage(String var1, PageType var2);

    void addToc();

    void addParam(Param var1);

    void addParam(Param... var1);

    void saveAs(String var1) throws IOException, InterruptedException;

    byte[] getPDF() throws IOException, InterruptedException;
}
