package it.uiip.digitalgarage.ebuonweekend.utils.wkhtmltopdf.configurations;

/**
 * Created by 1996384 on 22/11/2016.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WrapperConfig {
    private XvfbConfig xvfbConfig;
    private String wkhtmltopdfCommand = "wkhtmltopdf";

    public WrapperConfig(String wkhtmltopdfCommand) {
        this.wkhtmltopdfCommand = wkhtmltopdfCommand;
    }

    public WrapperConfig() {
        this.wkhtmltopdfCommand = this.findExecutable();
    }

    public String getWkhtmltopdfCommand() {
        return this.wkhtmltopdfCommand;
    }

    public void setWkhtmltopdfCommand(String wkhtmltopdfCommand) {
        this.wkhtmltopdfCommand = wkhtmltopdfCommand;
    }

    public String findExecutable() {
        try {
            String e = System.getProperty("os.name").toLowerCase();
            String cmd;
            if(e.contains("windows")) {
                cmd = "where wkhtmltopdf";
            } else {
                cmd = "which wkhtmltopdf";
            }

            Process p = Runtime.getRuntime().exec(cmd);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder sb = new StringBuilder();

            String line;
            while((line = reader.readLine()) != null) {
                sb.append(line);
            }

            if(sb.toString().isEmpty()) {
                throw new RuntimeException();
            }

            this.setWkhtmltopdfCommand(sb.toString());
        } catch (InterruptedException var7) {
            var7.printStackTrace();
        } catch (IOException var8) {
            var8.printStackTrace();
        } catch (RuntimeException var9) {
            var9.printStackTrace();
        }

        return this.getWkhtmltopdfCommand();
    }

    public boolean isXvfbEnabled() {
        return this.xvfbConfig != null;
    }

    public XvfbConfig getXvfbConfig() {
        return this.xvfbConfig;
    }

    public void setXvfbConfig(XvfbConfig xvfbConfig) {
        this.xvfbConfig = xvfbConfig;
    }
}
