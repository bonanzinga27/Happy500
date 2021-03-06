package it.uiip.digitalgarage.ebuonweekend.utils.wkhtmltopdf;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import it.uiip.digitalgarage.ebuonweekend.utils.wkhtmltopdf.configurations.WrapperConfig;
import it.uiip.digitalgarage.ebuonweekend.utils.wkhtmltopdf.page.Page;
import it.uiip.digitalgarage.ebuonweekend.utils.wkhtmltopdf.page.PageType;
import it.uiip.digitalgarage.ebuonweekend.utils.wkhtmltopdf.params.Param;
import it.uiip.digitalgarage.ebuonweekend.utils.wkhtmltopdf.params.Params;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;


import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

public class Pdf implements PdfService {
    private static final String STDINOUT = "-";
    private WrapperConfig wrapperConfig;
    private Params params;
    private List<Page> pages;
    private boolean hasToc;
//StandardCharsets.UTF_8

    public static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public Pdf(WrapperConfig wrapperConfig) {
        this.hasToc = false;
        this.wrapperConfig = wrapperConfig;
        this.params = new Params();
        this.pages = new ArrayList();
    }

    public Pdf() {
        this(new WrapperConfig());
    }

    public void addPage(String source, PageType type) {
        this.pages.add(new Page(source, type));
    }

    public void addToc() {
        this.hasToc = true;
    }

    public void addParam(Param param) {
        this.params.add(param);
    }

    public void addParam(Param... params) {
        Param[] var2 = params;
        int var3 = params.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Param param = var2[var4];
            this.addParam(param);
        }

    }

    public void saveAs(String path) throws IOException, InterruptedException {
        this.saveAs(path, this.getPDF());
    }

    private File saveAs(String path, byte[] document) throws IOException {
        File file = new File(path);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        bufferedOutputStream.write(document);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        return file;
    }

    public byte[] getPDF() throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(this.getCommandAsArray());
        StreamEater outputStreamEater = new StreamEater(process.getInputStream());
        outputStreamEater.start();
        StreamEater errorStreamEater = new StreamEater(process.getErrorStream());
        errorStreamEater.start();
        outputStreamEater.join();
        errorStreamEater.join();
        process.waitFor();
        if(process.exitValue() != 0) {
            throw new RuntimeException("Process (" + this.getCommand() + ") exited with status code " + process.exitValue() + ":\n" + new String(errorStreamEater.getBytes()));
        } else if(outputStreamEater.getError() != null) {
            throw outputStreamEater.getError();
        } else if(errorStreamEater.getError() != null) {
            throw errorStreamEater.getError();
        } else {
            return outputStreamEater.getBytes();
        }
    }

    private String[] getCommandAsArray() throws IOException {
        ArrayList commandLine = new ArrayList();
        if(this.wrapperConfig.isXvfbEnabled()) {
            commandLine.addAll(this.wrapperConfig.getXvfbConfig().getCommandLine());
        }

        commandLine.add(this.wrapperConfig.getWkhtmltopdfCommand());
        commandLine.addAll(this.params.getParamsAsStringList());
        if(this.hasToc) {
            commandLine.add("toc");
        }

        Page page;
        for(Iterator var2 = this.pages.iterator(); var2.hasNext(); commandLine.add(page.getSource())) {
            page = (Page)var2.next();
            if(page.getType().equals(PageType.htmlAsString)) {
                String home = System.getProperty("user.home");

                String globalURL=home+File.separator+"Desktop"+File.separator+"happy500"+File.separator+"pratiche";

                File temp = File.createTempFile("java-wkhtmltopdf-wrapper" + UUID.randomUUID().toString(), ".html",new File(globalURL));
                FileUtils.writeStringToFile(temp, page.getSource(), "UTF-8");
                page.setSource(temp.getAbsolutePath());
            }
        }

        commandLine.add("-");
        return (String[])commandLine.toArray(new String[commandLine.size()]);
    }

    public String getCommand() throws IOException {
        return StringUtils.join(this.getCommandAsArray(), " ");
    }

    private class StreamEater extends Thread {
        private InputStream stream;
        private ByteArrayOutputStream bytes;
        private IOException error;

        public StreamEater(InputStream stream) {
            this.stream = stream;
            this.bytes = new ByteArrayOutputStream();
        }

        public void run() {
            try {
                for(int e = this.stream.read(); e >= 0; e = this.stream.read()) {
                    this.bytes.write(e);
                }

                this.stream.close();
            } catch (IOException var2) {
                var2.printStackTrace();
                this.error = var2;
            }

        }

        public IOException getError() {
            return this.error;
        }

        public byte[] getBytes() {
            return this.bytes.toByteArray();
        }
    }
}
