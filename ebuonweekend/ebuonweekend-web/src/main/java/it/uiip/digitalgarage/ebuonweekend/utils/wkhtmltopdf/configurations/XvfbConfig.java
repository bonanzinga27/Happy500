package it.uiip.digitalgarage.ebuonweekend.utils.wkhtmltopdf.configurations;

/**
 * Created by 1996384 on 22/11/2016.
 */


import it.uiip.digitalgarage.ebuonweekend.utils.wkhtmltopdf.params.Param;
import it.uiip.digitalgarage.ebuonweekend.utils.wkhtmltopdf.params.Params;

import java.util.ArrayList;
import java.util.List;

public class XvfbConfig {
    private String command;
    private Params params;

    public XvfbConfig(String command) {
        this.command = command;
        this.params = new Params();
    }

    public XvfbConfig() {
        this.command = "xvfb-run";
        this.params = new Params();
    }

    public void addParams(Param... params) {
        Param[] var2 = params;
        int var3 = params.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Param param = var2[var4];
            this.params.add(param);
        }

    }

    public String getCommand() {
        return this.command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public List<String> getCommandLine() {
        ArrayList commandLine = new ArrayList();
        commandLine.add(this.getCommand());
        commandLine.addAll(this.params.getParamsAsStringList());
        return commandLine;
    }
}

