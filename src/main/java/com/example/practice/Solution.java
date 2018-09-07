package com.example.practice;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import java.util.*;

import static org.apache.http.Consts.UTF_8;

public class Solution {

    private Map<String, Integer> table = new LinkedHashMap<>();

    public static void main(String[] args) {
        List<String> inputString = new ArrayList<String>();
        inputString.add("API: amount=2000&merchant=10101010");
        //inputString.add("API: amount=800&merchant=123456789&destination[account]=112211&destination[amount]=622");
        inputString.add("BAL: merchant=10101010");
        //inputString.add("BAL: merchant=112211");
        new Solution().platformBalance(inputString);

    }

    private void printBal(String line) {
        String key = URLEncodedUtils.parse(line, UTF_8).get(0).getValue();
        if (table.containsKey(key)) {
            System.out.println(table.get(key));
        }
    }

    private void platformBalance(List<String> lines) {
        for (String line : lines) {
            String tag = line.split(":")[0].trim();
            switch (tag) {
                case "API":
                    parseUrl(line);
                    break;
                case "BAL":
                    printBal(line);
                    break;
            }
        }
    }

    private int calculate(String amount) {
        Integer value = Integer.parseInt(amount);

        return Integer.parseInt(amount) - (int) (value * 2.9 / 100 + 30);
    }

    private void parseUrl(String inputUrl) {
        inputUrl = inputUrl.split(":")[1].trim();
        List<NameValuePair> nameValuePairs = URLEncodedUtils.parse(inputUrl, UTF_8);

        int transactionAmount = 0;
        String merchantId = null;
        String driverId = null;

        for (NameValuePair nameValuePair : nameValuePairs) {
            switch (nameValuePair.getName()) {
                case "amount":
                    transactionAmount = calculate(nameValuePair.getValue());
                    break;
                case "merchant" :
                    merchantId = nameValuePair.getValue();
                    if (!table.containsKey(merchantId))
                        table.put(merchantId, 0);
                    break;
                case "destination[account]":
                    driverId = nameValuePair.getValue();
                    if (!table.containsKey(driverId))
                        table.put(driverId, 0);
                    break;
                case "destination[amount]":
                    table.put(driverId, Integer.valueOf(nameValuePair.getValue()) + table.get(driverId));
                    int value = transactionAmount - Integer.parseInt(nameValuePair.getValue());
                    table.put(merchantId, table.get(merchantId) + value);
            }

        }
        if (nameValuePairs.size() == 2)
            table.put(merchantId,table.get(merchantId) + transactionAmount);
    }
}
