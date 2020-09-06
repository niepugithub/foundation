package com.resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONReader;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 * @date:2020/9/6 19:02
 **/
public class ResourceTest {

    @Test
    public void getJson1() {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("json/user.json");
        JSONReader jsonReader = new JSONReader(new InputStreamReader(resourceAsStream));
        User user = jsonReader.readObject(User.class);
        System.out.println(user);
    }

    @Test
    public void getJson2() throws IOException {
        URL resource = this.getClass().getResource("/json/user.json");
        System.out.println("resource.getPath()" + resource.getPath());
        System.out.println("resource.getFile()" + resource.getFile());
        File file = new File(resource.getFile());
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        System.out.println(sb.toString());
    }

    @Test
    public void getProperties() throws IOException {
        // getClass需要加绝对路径，getClassLoader不需要，类加载路径选择相对路径就好了
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/properties/application.properties");
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        System.out.println(JSON.toJSONString(properties));
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(this.getClass().getClassLoader());
    }

    @Test
    public void getClasses() throws ClassNotFoundException {
        Set<Class<?>> classes = new HashSet<>();
        List<String> classNames = new LinkedList<>();
        doScanner("com", "E:\\advance\\datastructure\\target\\classes\\com", classes, classNames);
        System.out.println(classNames);
        System.out.println(classes);
    }

    public void doScanner(String pkgName, String pkgPath, Set<Class<?>> classes, List<String> classNames) throws ClassNotFoundException {
        File files = new File(pkgPath);//E:/advance/datastructure/target/classes/com
        // 过滤
        File[] dirfiles = files.listFiles(pathname -> pathname.isDirectory() || pathname.getName().endsWith(".class"));

        if (dirfiles == null || dirfiles.length == 0) {
            return;
        }

        String className;
        for (File file : dirfiles) {
            if (file.isDirectory()) {
                doScanner(pkgName + "." + file.getName(), pkgPath + "/" + file.getName(), classes, classNames);
                continue;
            }

            // 获取类名，干掉 ".class" 后缀
            className = file.getName().substring(0, file.getName().length() - 6);
            classNames.add(className);
            classes.add(this.getClass().getClassLoader().loadClass(pkgName + "." + className));
        }
    }


    @Test
    public void getClassesMe() throws ClassNotFoundException {
        Set<Class<?>> classes = new HashSet<>();
        doScanner("com", classes);
        System.out.println(classes);
    }

    private void doScanner(String scanPackage, Set<Class<?>> classes) throws ClassNotFoundException {
        // 类加载器去加载类文件，这样默认就是类加载目录，而不是其他外部目录吧// file:/E:/advance/datastructure/target/classes/com

        /**
         * 注意：
         * （1）包名和路径名的转化
         * （2）this.getClass().getClassLoader().getResource("")得到的是file:/E:/advance/datastructure/target/classes/，带有前缀file
         * （3）new file需要不带前缀的路径this.getClass().getClassLoader().getResource("").getPath()，注意getPath()
         * （4）file.getName得到的就是当前的文件名，如果是目录得到的就是目录名，不是全名，是简名
         */
        String filePath = this.getClass().getClassLoader().getResource("").getPath() + scanPackage.replace(".", "/");
        File files = new File(filePath);
        // 过滤
        File[] dirfiles = files.listFiles(pathname -> pathname.isDirectory() || pathname.getName().endsWith(".class"));

        for (File file : dirfiles) {
            if (file.isDirectory()) {
                doScanner(scanPackage + "." + file.getName(), classes);
                continue;
            }
            String pgkName = scanPackage.replace("/", ".");
            String className = pgkName + "." + file.getName().substring(0, file.getName().length() - 6);
            classes.add(this.getClass().getClassLoader().loadClass(className));
        }
    }


}
