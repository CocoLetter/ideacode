package upload;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/user")
public class fileupload {


    @RequestMapping("/upload3")
    public String upload3(MultipartFile upload) throws IOException {
        //一定要注意：这里的upload要与jsp中表单名称对应上
        System.out.println("运行了");

        String path="http://localhost:9090/upload/";

        String originalFilename = upload.getOriginalFilename();
        String extendName = originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());
        String preName = UUID.randomUUID().toString().toUpperCase();
        String filename=preName+extendName;
        System.out.println(filename);

        // 创建客户端对象
        Client client = Client.create();
        // 连接图片服务器
        WebResource webResource = client.resource(path+filename);
        // 上传文件
        webResource.put(upload.getBytes());
        return "success";
    }



    @RequestMapping("/upload2")
    public String upload2(HttpServletRequest request, MultipartFile upload) throws IOException {
        //一定要注意：这里的upload要与jsp中表单名称对应上
        System.out.println("运行了");
        System.out.println(upload.getSize());
        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(realPath);
        if(!file.exists()){
            file.mkdirs();
        }
        System.out.println(upload.getSize());

        String originalFilename = upload.getOriginalFilename();
        String extendName = originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());
        String preName = UUID.randomUUID().toString().toUpperCase();
        String filename=preName+extendName;
        System.out.println(filename);
        upload.transferTo(new File(realPath,filename));
        return "success";
    }

    @RequestMapping("/upload1")
    public String upload1(HttpServletRequest request) throws Exception {
        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(realPath);
        if(!file.exists()){
            file.mkdirs();
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload=new ServletFileUpload(factory);

        List<FileItem> fileItems = upload.parseRequest(request);

        for(FileItem item:fileItems){
            if(item.isFormField()){

            }else{
                String name = item.getName();
                String extendName=name.substring(name.lastIndexOf(".")+1,name.length());
                String uuid = UUID.randomUUID().toString().toUpperCase();

                String filename=uuid+"_"+extendName;

                item.write(new File(realPath,filename));
                item.delete();

            }
        }
        return "success";
    }
}
