package cn.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Filter1 implements Filter {
    private ServletContext sc;

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String key = "key_" + request.getParameter("category");

        Map<String,String> map = (Map<String, String>) sc.getAttribute("pages");
        if(map == null) {
            map = new HashMap<String,String>();
            sc.setAttribute("pages", map);
        }

        if(map.containsKey(key)) {
            res.sendRedirect(req.getContextPath() + "/staticPages/" + map.get(key));
            System.out.println("现存jsp页面");
            System.out.println(req.getContextPath());
            return;
        }

        String html = key + ".html";
        String realPath = sc.getRealPath("/staticPages/" + html);
        System.out.println(key);
        System.out.println(realPath);
        StaticResponse sr = new StaticResponse(res, realPath);
        chain.doFilter(request, sr);


        sr.close();

        //第一次运行会出现html页面还未来得及创建就已经开始重定向到html页面导致资源查找失败
        res.sendRedirect(req.getContextPath() + "/staticPages/" + html);
        System.out.println("新建"+req.getContextPath() + "/staticPages/" + html);
        map.put(key, html);
    }

    public void init(FilterConfig fConfig) throws ServletException {
        this.sc = fConfig.getServletContext();
    }
}
