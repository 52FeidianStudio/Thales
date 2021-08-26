package cn.thales.example;

import java.util.HashMap;
import java.util.Map;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/7/20 22:07
 * @Description: null
 */
public class Test {
    public static void main(String[] args) {
//       String building = "1栏/南江彭甫刚栋;1栏/1栋;2栏/1栋;";
//        String[] split = building.split("栋;");
//        ArrayList<String> build = new ArrayList<>();
//        ArrayList<String> col = new ArrayList<>();
//        System.out.println(Arrays.toString(split));
//        for (String element: split){
//            String[] split1 = element.split("栏/");
//            if(split1.length == 2) {
//                build.add(split1[1]);
//                col.add(split1[0]);
//            }else {
//                build.add(split1[0]);
//            }
//            new HashMap().containsKey(1);
//        }
//        System.out.println(build);
//        System.out.println(col);

        System.out.println(circularArrayLoop2(new int[]{3,1,2}));
    }
    public static boolean circularArrayLoop(int[] nums) {
        Map<Integer,Integer> map = new HashMap();
        int len = nums.length;
        int index = 0;
        int count1 = 1;
        int count2 =1;
        int previous = nums[0];
        map.put(index,count1);
        while(true){
            index = (index+nums[index])%len;
            if(index<0){
                index+=len;
            }
            if(!map.containsKey(index)){
                count1++;
                if(previous * nums[index]<0){
                    count2++;
                }
                if(count2>1){
                    return false;
                }
                map.put(index,count1);

            }else if(map.containsKey(index)&&count1- map.get(index)>=2){
                break;
            }else if(map.containsKey(index)&&count1- map.get(index)<2){
                return false;
            }
            previous = nums[index];

        }
        return true;

    }
    public static boolean circularArrayLoop2(int[] nums) {
       int slow = 0;
       int quick = 0;
       int length = nums.length;
       int previous = nums[quick];
       int count = 1;
       boolean flag = false;
       while (true){
           quick = getNextIndex(quick,nums[quick],length);
           if(previous*nums[quick]<0){
               return false;
           }
           previous = nums[quick];
           quick = getNextIndex(quick,nums[quick],length);
           if(previous*nums[quick]<0){
               return false;
           }
           previous = nums[quick];
           slow = getNextIndex(slow,nums[slow],length);
           if(flag){
               count++;
           }
           if(quick==slow){
              flag = true;
           }
           if(quick==slow&&flag&&count>1){
               return true;
           }
           if(quick==slow&&flag&&count==1){
               return false;
           }

       }

    }
    public static int getNextIndex(int index,int distance,int length){
        index = (index+distance)%length;
        if (index<0) {
            index = index+length;
        }
        return index;
    }
}
