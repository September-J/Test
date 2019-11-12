import java.util.Arrays;
public class Test0920{
    public static void main(String [] args){
        int []arr = {1,2,3,4,5};
        transform(arr);
        System.out.println(Array.toString(arr));

    }
    public static void reverse(){
        int left = 0;
        int right = arr.length-1;
        int tmp = 0;
        while(left < right){
            tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp; 
            left++;
            right--;
        }
        
        public static void transform(int[] arr){
            int left = 0;
            int right = arr.length - 1;
            while(left < right){
                while(left < right && arr[left] % 2 == 0){
                    //从左往右找第一个奇数
                    //循环结束时，left对应的元素就是奇数了
                   left++;
                }
                //从右往左找第一个偶数
                while(left < right && arr[right] % 2 == 0){
                    right--;
                }
                //交换两个位置的元素
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
        
    }
}