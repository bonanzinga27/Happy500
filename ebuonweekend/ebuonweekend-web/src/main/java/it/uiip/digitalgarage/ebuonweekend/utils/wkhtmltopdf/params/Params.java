package it.uiip.digitalgarage.ebuonweekend.utils.wkhtmltopdf.params;

/**
 * Created by 1996384 on 22/11/2016.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Params {
    private List<Param> params = new ArrayList();

    public Params() {
    }

    public void add(Param param) {
        this.params.add(param);
    }

    public void add(Param... params) {
        Param[] var2 = params;
        int var3 = params.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Param param = var2[var4];
            this.add(param);
        }

    }

    public List<String> getParamsAsStringList() {
        ArrayList commandLine = new ArrayList();
        Iterator var2 = this.params.iterator();

        while(var2.hasNext()) {
            Param p = (Param)var2.next();
            commandLine.add(p.getKey());
            String value = p.getValue();
            if(value != null) {
                commandLine.add(p.getValue());
            }
        }

        return commandLine;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator var2 = this.params.iterator();

        while(var2.hasNext()) {
            Param param = (Param)var2.next();
            sb.append(param);
        }

        return sb.toString();
    }
}
