/**
 * 创建人：     @author hanshenglin
 * 创建时间: 2018年3月3日/下午1:30:50
 * 项目名称：  dfas-common-util
 * 文件名称: PinyinUtil.java
 * 文件描述: @Description: 拼音转换工具
 *
 * All rights Reserved, Designed By 深圳市赢和信息技术有限公司
 * @Copyright:2016-2018
 *
 */
package com.win.dfas.common.util;

import cn.hutool.core.util.StrUtil;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 包名称： com.yhfin.fcbp.basicparameter
 * 类名称：PinyinUtil
 * 类描述：拼音转换工具
 * 创建人：@author hanshenglin
 * 创建时间：2018年3月3日/下午1:30:50
 *
 */
public class PinyinUtil {

	private PinyinUtil() {
	}
    private static final Logger logger = LoggerFactory.getLogger(PinyinUtil.class);
    /**
     * 需要过滤调掉的特殊字符
     */
    public static final String FILTER_REGEX = "[`~!@#$%^&*()+-=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
    /**
     * ASCII表中可见字符从!开始，偏移位值为33(Decimal)  // 半角!
     */
    public static final char DBC_CHAR_START = 33;

    /**
     * ASCII表中可见字符到~结束，偏移位值为126(Decimal)  // 半角~
     */
    public static final char DBC_CHAR_END = 126;

    /**
     * 全角对应于ASCII表的可见字符从！开始，偏移值为65281  // 全角！
     */
    public static final char SBC_CHAR_START = 65281;

    /**
     * 全角对应于ASCII表的可见字符到～结束，偏移值为65374  // 全角～
     */
    public static final char SBC_CHAR_END = 65374;

    /**
     * ASCII表中除空格外的可见字符与对应的全角字符的相对偏移  // 全角半角转换间隔
     */
    public static final int CONVERT_STEP = 65248;

    /**
     * 全角空格的值，它没有遵从与ASCII的相对偏移，必须单独处理  // 全角空格 12288
     */
    public static final char SBC_SPACE = 12288;

    /**
     * 半角空格的值，在ASCII中为32(Decimal)   // 半角空格
     */
    public static final char DBC_SPACE = ' ';

    public static Map<String,String> dictionary = new HashMap<String,String>();

    /*加载多音字词典*/
    static{
        BufferedReader br = null;
        try( InputStream resourceAsStream = PinyinUtil.class.getClassLoader().getResourceAsStream("duoyin/duoyinzi_pinyin.txt")) {
            br = new BufferedReader(new InputStreamReader(resourceAsStream,"UTF-8"));
            String line = null;
            while((line=br.readLine())!=null){
                String[] arr = line.split("#");
                if(StrUtil.isNotEmpty(arr[1])){
                    String[] sems = arr[1].split(" ");
                    for (String sem : sems) {
                        if(StrUtil.isNotEmpty(sem)){
                            dictionary.put(sem , arr[0]);
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error("加载文件失败！，errMsg={}", e.getMessage(), e);
        }finally{
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    logger.error("关闭拼音缓冲流失败！，errMsg={}", e.getMessage(), e);
                }
            }
        }

    }

    public static String[] chineseToPinYin(char chineseCharacter) throws BadHanyuPinyinOutputFormatCombination{
        HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();
        outputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        outputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        outputFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
       /* ASCII >=33 ASCII<=125的直接返回 ,ASCII码表：http://www.asciitable.com */
      if(chineseCharacter>=32 && chineseCharacter<=125){
            return new String[]{String.valueOf(chineseCharacter)};
        }
        return PinyinHelper.toHanyuPinyinStringArray(chineseCharacter, outputFormat);
    }

    /**
     * 获取汉字拼音的全拼
     * @param chineseCharacter
     * @return
     * @throws BadHanyuPinyinOutputFormatCombination
     */
    public static String chineseToPinYinFull(String chineseCharacter) throws BadHanyuPinyinOutputFormatCombination{
        if(StringUtils.isEmpty(chineseCharacter)){
            return null;
        }
        char[] chs = chineseCharacter.toCharArray();
        StringBuilder result = new StringBuilder();
        for(int i=0;i<chs.length;i++){
            String[] arr = chineseToPinYin(chs[i]);
            if(arr==null){
                result.append("");
            }else if(arr.length==1){
                result.append(arr[0]);
            }else if(arr[0].equals(arr[1])){
                result.append(arr[0]);
            }else{
                String prim = chineseCharacter.substring(i, i+1);
                String lst = null,rst = null;
                if(i<=chineseCharacter.length()-2){
                    rst = chineseCharacter.substring(i,i+2);
                }
                if(i>=1 && i+1<=chineseCharacter.length()){
                    lst = chineseCharacter.substring(i-1,i+1);
                }
                String answer = null;
                for (String py : arr) {
                    if(StringUtils.isEmpty(py)){
                        continue;
                    }
                    if((lst!=null && py.equals(dictionary.get(lst))) ||
                            (rst!=null && py.equals(dictionary.get(rst)))){
                        answer = py;
                        break;
                    }
                    if(py.equals(dictionary.get(prim))){
                        answer = py;
                    }
                }
                if(answer!=null){
                    result.append(answer);
                }
            }
        }
        return result.toString().toLowerCase();
    }

    /**
     * 获取拼音简拼
     * @Title: chineseToPinYinSimple
     * @Description:  获取拼音简拼
     * @param chineseCharacter
     * @return
     * @throws BadHanyuPinyinOutputFormatCombination
     * @return: String
     * @throws
     * @author: hanshenglin
     * @Date:  2018年3月9日/下午1:50:48
     */
    public static String chineseToPinYinSimple(String chineseCharacter) throws BadHanyuPinyinOutputFormatCombination{
        if(StringUtils.isEmpty(chineseCharacter)){
            return null;
        }

        char[] chs = chineseCharacter.toCharArray();

        StringBuilder result = new StringBuilder();

        for(int i=0;i<chs.length;i++){
            String[] arr = chineseToPinYin(chs[i]);
            if(arr==null){
                result.append("");
            }else if(arr.length==1){
                result.append(arr[0].charAt(0));
            }else if(arr[0].equals(arr[1])){
                result.append(arr[0].charAt(0));
            }else{
                String prim = chineseCharacter.substring(i, i+1);
                String lst = null,rst = null;
                if(i<=chineseCharacter.length()-2){
                    rst = chineseCharacter.substring(i,i+2);
                }
                if(i>=1 && i+1<=chineseCharacter.length()){
                    lst = chineseCharacter.substring(i-1,i+1);
                }
                String answer = null;
                for (String py : arr) {
                    if(StringUtils.isEmpty(py)){
                        continue;
                    }
                    if((lst!=null && py.equals(dictionary.get(lst))) ||
                            (rst!=null && py.equals(dictionary.get(rst)))){
                        answer = py;
                        break;
                    }
                    if(py.equals(dictionary.get(prim))){
                        answer = py;
                    }
                }
                if(answer!=null){
                    result.append(answer.charAt(0));
                }
            }
        }
        return result.toString().toLowerCase();
    }


    /**
     * 全角字符->半角字符转换
     * @Title: fullShaped2Half
     * @Description: 只处理全角的空格，全角！到全角～之间的字符，忽略其他
     * @param src
     * @return
     * @return: String
     * @throws
     * @author: hanshenglin
     * @Date:  2018年3月3日/下午1:36:03
     */
    public static String fullShaped2Half(String src) {
        if (src == null) {
            return src;
        }
        StringBuilder buf = new StringBuilder(src.length());
        char[] ca = src.toCharArray();
        for (int i = 0; i < src.length(); i++) {
            /* 如果位于全角！到全角～区间内 */
            if (ca[i] >= SBC_CHAR_START && ca[i] <= SBC_CHAR_END) {
                buf.append((char) (ca[i] - CONVERT_STEP));
                /* 如果是全角空格 */
            } else if (ca[i] == SBC_SPACE) {
                buf.append(DBC_SPACE);
                /* 不处理全角空格，全角！到全角～区间外的字符 */
            } else {
                buf.append(ca[i]);
            }
        }
        return buf.toString();
    }

    /**
     * 需要过滤调掉的特殊字符
     * @Title: filterSpecialCharacter
     * @Description: 需要过滤调掉的特殊字符
     * @param str
     * @return
     * @return: String
     * @throws
     * @author: hanshenglin
     * @Date:  2018年3月3日/下午1:43:20
     */
    public static String filterSpecialCharacter(String str) {
        Pattern pattern = Pattern.compile(FILTER_REGEX);
        Matcher matcher = pattern.matcher(str);
        //TODO
        return matcher.replaceAll("").trim();
    }

    /**
     *
     * @Title: pasreFirstSpell
     * @Description: 获取汉语拼音字符串，英文字符不变
     * @param: @param chinese 汉字串
     * @param: @return
     * @return: String 汉语拼音首字母
     * @throws
     */
    public static String pasreFirstSpell(String chinese) {
        try {
            /*替换特殊字符*/
            chinese = filterSpecialCharacter(chinese);
            /*全角转半角*/
            chinese =  fullShaped2Half(chinese);
            /* 转换为简拼*/
           return chineseToPinYinSimple(chinese);
        } catch (Exception e) {
            /*转换异常就返回原字符串*/
            return chinese;
        }
    }

    /**
     * 获取汉语拼音字符串，英文字符不变
     * @Title: pasreFirstSpell
     * @Description: 获取汉语拼音字符串，英文字符不变
     * @param: @param chinese 汉字串
     * @param: @return
     * @return: String 汉语拼音首字母
     * @throws
     */
    public static String pasreFullSpell(String chinese) {
        try {
            /*替换特殊字符*/
            chinese = filterSpecialCharacter(chinese);
            /*全角转半角*/
            chinese = fullShaped2Half(chinese);
            /* 转换为简拼*/
           return chineseToPinYinFull(chinese);
        } catch (Exception e) {
            /*转换异常就返回原字符串*/
            return chinese;
        }
    }

}
