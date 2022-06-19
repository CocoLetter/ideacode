package cn.filter;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class StaticResponse extends HttpServletResponseWrapper {
    private PrintWriter pw;

    public StaticResponse(HttpServletResponse response, String filepath)
            throws FileNotFoundException, UnsupportedEncodingException {
        super(response);
        pw = new PrintWriter(filepath, "UTF-8");
    }

    public PrintWriter getWriter () throws IOException {
        return pw;
    }

    public void close() throws IOException {
        pw.close();
    }
}