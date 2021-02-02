import java.io.File;
import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {

		//获取当前项目的根路径 
		 File directory = new File("");// 参数为空
         String courseFile = directory.getCanonicalPath();
        System.out.println(courseFile);
        
        String absolute = directory.getAbsolutePath();
        System.out.println(absolute);
        
        
	}

}
