package Flink.utilities;

import Flink.pages.MoisturizersPage;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    // If you have list of webelements this method provides texts of elements as String[]
    public static String[] getTextElements(List<WebElement> element){
        String[] text = new String[element.size()];
        for (int i=0;i<element.size();i++){
            text[i]=element.get(i).getText();
        }

        return text;
    }
    // to find smallest number
    public static int getSmallest(int[] a, int total){
        int temp;
        for (int i = 0; i < total; i++) {
            for (int j = i + 1; j < total; j++) {
                if (a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a[0];
    }
    // when provide string array it returns all prices as int[]
    public static int[] getPrices(String[] str){
        String numberOnly ;
        int[] prices = new int[str.length];
        for (int i = 0 ; i<str.length;i++){
            numberOnly = str[i].replaceAll("[^0-9]", "");
            prices[i]= Integer.parseInt(numberOnly);
        }
        return prices;
    }
}
