package com.company;

import java.util.regex.Pattern;

public class Main {

    private static boolean isMsisdnValid(String msisdn) {
        if (msisdn == null) return false;
        return Pattern.compile("(70|77|55|99)[0-9]{7}").matcher(msisdn).matches();
    }

    // 702769481,505741029,502312289
    private static Pattern createRegexPattern(String listString) {
        //        String regexString = "702769481|505741029|502312289";
        String regexString = listString.replace(",", "|");
        return Pattern.compile(regexString);
    }

    public static void main(String[] args) {
        Pattern blacklistPattern = createRegexPattern("702769481,502312289");

        String [] msisdns = {"505741029", "502312280", "702769481", "708986056", "502312289"};

        String whitelist = null;

        Pattern whitelistPattern = createRegexPattern(whitelist);


        // Совместить два цикла таким образом, что номера сверяются и по черному, и по белому спискам
        // Если есть в черном списке или же нет в белом списке, нельзя продавать.
        // Если нет в черном и есть в белом, можно продавать.
        // Есть белый список пустой, то любой номер, что не в черном можно продавать

        boolean isWhitelistEmpty = whitelist.isEmpty() || whitelist == null;

        for (int i = 0; i < msisdns.length; i++) {
            if (!blacklistPattern.matcher(msisdns[i]).lookingAt() &&
                    (isWhitelistEmpty || whitelistPattern.matcher(msisdns[i]).lookingAt())) {
                System.out.println(msisdns[i] + " можно продавать");
            } else {
                System.out.println(msisdns[i] + " нельзя продавать");
            }
        }

    }
}
