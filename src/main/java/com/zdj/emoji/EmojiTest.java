package com.zdj.emoji;

import com.vdurmont.emoji.Emoji;
import com.vdurmont.emoji.EmojiManager;
import org.junit.Test;

import java.util.Collection;

/**
 * @author zhangdj
 * @date 2021/06/01
 */
public class EmojiTest {

    @Test
    public void t1() {
//        String str = "An :grinning:awesome :smiley:string &#128516;with a few :wink:emojis!";
//        String s = EmojiParser.parseToUnicode(str);
        Collection<Emoji> all = EmojiManager.getAll();
        for (Emoji emoji : all) {
            String unicode = emoji.getUnicode();
            if (unicode.equals("\uD83D\uDC49")) {
                System.out.println(unicode);
            }
        }
    }

    @Test
    public void t2() {
        System.out.println("\uD83D\uDC49");
        Integer a = 2;
        a = null;
        System.out.println(2 != a);
    }


    public static String encode(String str) {
        String prefix = "\\u";
        StringBuffer sb = new StringBuffer();
        char[] chars = str.toCharArray();
        if (chars == null || chars.length == 0) {
            return null;
        }
        for (char c : chars) {
            sb.append(prefix);
            sb.append(Integer.toHexString(c));
        }
        return sb.toString();
    }
}
