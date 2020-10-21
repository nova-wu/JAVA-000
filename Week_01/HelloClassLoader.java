import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloClassLoader extends ClassLoader {

    public Class findClass(String name) throws ClassNotFoundException {
        byte[] b = new byte[0];
        try {
            b = loadClassData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(name, b, 0, b.length);
    }

    private byte[] loadClassData() throws IOException {
        // 从 claspath 中读取 Hello.xlass
        InputStream helloXlassInputStream = this.getClass().getResourceAsStream("/Hello.xlass");
        byte[] helloXlassByteArray = new byte[helloXlassInputStream.available()];
        helloXlassInputStream.read(helloXlassByteArray);
        byte[] helloClassByteArray = new byte[helloXlassByteArray.length];
        for(int i=0;i<helloXlassByteArray.length ;i++){
            helloClassByteArray[i] = (byte) (255-helloXlassByteArray[i]);
        }
        return helloClassByteArray;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ClassLoader loader = new HelloClassLoader();
        Object helloClassInstance = loader.loadClass("Hello").newInstance();
        Method helloMethod = helloClassInstance.getClass().getMethod("hello");
        helloMethod.invoke(helloClassInstance);
    }
}
