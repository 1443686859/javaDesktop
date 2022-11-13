package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode6084 {
    public static void main(String[] args) {
        Leetcode6084 leetcode6084 = new Leetcode6084();
             System.out.println(leetcode6084.largestWordCount(new String[]{"b I j","OK N x J jt b iO N Y","Q h y CV UE Q A","Qo Qy w Aw c","oh","OA kC G V GlX","AD Z A YH Tyl","MA","sVD","a BB o g o A hf H","qu","P nAx","d e As Gd oD C RWb","kS tI Lt U eq k M A","cS e R h f gl","AX dn b w nx","nX T P B","F","Gk eGO","l y Ue nC D","o UV W P j p e Ov g","aI Xr Fs NVz","H f l","B AY vs S","rZ Ku S S pQ","f N q cP lX o x","W X X Za t","Vp a xR X J G h A Vo"}, new String[]{"kXMEHbzSid","LxSLj","HvI","rIffGg","rIffGg","RHiE","HvI","QWsD","v","QWsD","VUCp","vsp","ArRIVvhn","VUCp","RHiE","rIffGg","FzxQzXec","FzxQzXec","VUCp","VUCp","vsp","v","rDkxpR","rKsKmX","rKsKmX","HvI","LxSLj","grfeiaY"}));
    }
    public String largestWordCount(String[] messages, String[] senders) {
       Map<String, Integer> resultMap = new HashMap<>();
       for (int i = 0; i < senders.length; i++) {
           int currentResult = resultMap.getOrDefault(senders[i], 0);
           int current = messages[i].split(" ").length;
           resultMap.put(senders[i], currentResult + current);
       }
       String result = "";
       int count = 0;
       for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
           if (entry.getValue() > count) {
               result = entry.getKey();
               count = entry.getValue();
           } else if (entry.getValue() == count) {
               if (result.compareTo(entry.getKey()) < 0) {
                   result = entry.getKey();
               }
           }
       }
       return result;
    }
}
