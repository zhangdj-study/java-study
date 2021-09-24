package java.lang;

/**
 * @author zhangdj
 * @date 2021/02/01
 * 尝试替换java自带的核心类
 * 由于双亲委派机制：加载类先由上层类加载器尝试加载类，启动类加载器已经将java自己的String类加载完毕，所以该类并不会被加载到内存
 */
public class String {
    public static void main(String[] args) {
        System.out.println("123");
    }
}
