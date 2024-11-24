package leetcode.editor.cn;



import java.util.*;

public class Leetcode6126 {
    public static void main(String[] args) {
        FoodRatings foodRatings = new FoodRatings(new String[]{"vhbibydfop","ggtdlawxup","lslcltacc","bqgkfcy","xxowyabq","ezswv","ewgvsuyvpo","zgochpey","epiaxxiv","idpdiqlcp","wqgrbvme","wqxbxeovwe","iduzk","ahemklz","ah","rvuqnlydxu","dldqmpheob","lzeqwfb","ykwjc","dtrgnrcqr","cwcgevzzz","zejbynj","ivhdsnjpho","gsyewq","ekqhtiijrj","cthwbt","gnbhjyhcil","kkthw","ktiqokzl","zzroi","cjwapjnzql","hfum","jrwby","amhfyno","bj","fszije","nbkpptir","dgzmoxhhoe","bnisfskgxi","uepypxnsy","afdz","tdctkeg","lfsohpzmk","ewwqult","iynyddno","yyroyjzdg","mcpea","lzafjh","jdvcxidtm","qvkyqmupz","kjop","girgfkaib","qecvnaxpsm","itx","xhjmq","lwwbdxkz","chthxuhex","tghokrfica","vrmjibxv","oipnttbz","yyfvlwvj","erbtnw","yezfiom","ismarfqbuv","vmfxlqbxwa","pcwparohxf","bpdrndbv","owgjjitjfd","fdwmxhli","kffetdxvfx","ruahmg","aphbsbkimb","nbkdfkgl","rxehcqcrwu","kxwlfxbe","qukxd","tewgnjuxnm","jxfqwqe","mdgwiok","tbkmnx","klzznopcn","vjbcvddw","yzhawtmpwp","fhjichpi","tapig","glfbwolsoa","xklqlzm"},new String[]{"kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh","kggxajkarh"},new int[]{146,562,428,619,731,483,598,619,950,446,630,556,894,911,537,359,863,995,417,702,689,667,502,691,896,582,111,319,182,953,131,372,563,963,300,42,829,187,676,509,259,688,897,614,392,170,392,1,134,79,995,371,886,430,72,830,871,758,247,333,128,987,659,933,640,198,638,585,825,904,729,214,974,935,581,985,85,987,51,174,301,635,148,492,200,275,101});
        System.out.println(foodRatings);
        System.out.println(foodRatings.highestRated("kggxajkarh"));
    }
    static class FoodRatings {
         Map<String, Integer> ratingMap ;
         Map<String, PriorityQueue<String>> cuisineMap;

         Map<String, String> foodMap;
        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            ratingMap = new HashMap<>();
            cuisineMap = new HashMap<>();
            foodMap = new HashMap<>();
            int n = foods.length;
            for (int i = 0; i < n; i++) {
                ratingMap.put(foods[i], ratings[i]);
                foodMap.put(foods[i], cuisines[i]);
                PriorityQueue<String> current = cuisineMap.getOrDefault(cuisines[i], new PriorityQueue<>( (a, b) -> {
                    if (!ratingMap.get(a).equals(ratingMap.get(b))) {
                        return ratingMap.get(b) - ratingMap.get(a);
                    } else {
                        return a.compareTo(b);
                    }
                }));
                current.add(foods[i]);
                cuisineMap.put(cuisines[i], current);
            }
        }

        public void changeRating(String food, int newRating) {
            PriorityQueue<String> current = cuisineMap.get(foodMap.get(food));
            current.remove(food);
            ratingMap.put(food, newRating);
            current.add(food);
            cuisineMap.put(foodMap.get(food), current);
        }

        public String highestRated(String cuisine) {
            PriorityQueue<String> foods = cuisineMap.getOrDefault(cuisine, new PriorityQueue<>());
            return foods.peek();
        }
    }
}
