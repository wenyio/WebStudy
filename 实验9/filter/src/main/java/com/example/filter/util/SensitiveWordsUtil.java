package com.example.filter.util;

/**
 * xx
 * <p>
 * Description:
 * </p>
 *
 * @author: https://github.com/wenyio
 * @date: 2021/5/24
 * @see: com.example.filter.util
 * @version: v1.0.0
 */
public class SensitiveWordsUtil {

    //大部分敏感词汇在10个以内，直接返回缓存的字符串
    public static String[] starArr={"*","**","***","****","*****","******","*******","********","*********","**********"};

    private static String[] sensitiveWords = {"你是猪", "你是笨蛋", "你是蛋白质"};

    /**
     * 批量过滤
     * @param content
     * @return
     */
    public static String filterSensitiveWords(String content) {
        for (String sensitiveWord : sensitiveWords) {
            content = filterSensitiveWord(content, sensitiveWord);
        }
        return content;
    }

    /**
     * 过滤字符串中的敏感词汇
     * @param content   文本
     * @param sensitiveWord   敏感词汇
     * @return
     */
    public static String filterSensitiveWord(String content, String sensitiveWord) {

        if (content == null || sensitiveWord == null) {
            return content;
        }

        //获取和敏感词汇相同数量的星号
        String starChar = getStarChar(sensitiveWord.length());

        //替换敏感词汇
        return content.replace(sensitiveWord, starChar);
    }

    /**
     * 生成n个星号的字符串
     * @param length
     * @return
     */
    private static String getStarChar(int length) {
        if (length <= 0) {
            return "";
        }
        //大部分敏感词汇在10个以内，直接返回缓存的字符串
        if (length <= 10) {
            return starArr[length - 1];
        }

        //生成n个星号的字符串
        char[] arr = new char[length];
        for (int i = 0; i < length; i++) {
            arr[i] = '*';
        }
        return new String(arr);
    }
}
