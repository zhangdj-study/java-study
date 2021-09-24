package com.zdj.jvm;

/**
 * @author zhangdj
 * @date 2021/04/26
 */
public class FinalizeEscapeGc {

    public static FinalizeEscapeGc SAVE_HOOK = null;

    /**
     * 方法会被触发 但不会等待它运行结束
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize execute");
        SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGc();

        // 设置SAVE_HOOK=null 上面实例出来的对象应该被回收 执行finalize方法时会自救
        SAVE_HOOK = null;
        System.gc();
        // finalize 优先级低 暂停0.5秒
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            System.out.println("still alive");
        } else {
            System.out.println("died");
        }

        // 与上面相同的代码（finalize方法只会被执行一次 对象面临下一次回收finalize不会被再次执行）
        SAVE_HOOK = null;
        // finalize 优先级低 暂停0.5秒
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            System.out.println("still alive");
        } else {
            System.out.println("died");
        }

    }
}
