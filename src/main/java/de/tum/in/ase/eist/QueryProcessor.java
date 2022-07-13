package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return "Giulie";
        } else if (query.contains("what is your name")) {
            return "Giulie";
        } else if (query.contains("plus")) {
            String string1 = query.substring(query.indexOf("what is ") + 1);
            string1 = string1.substring(0, string1.indexOf("plus") - 1);
            String string2 = query.substring(query.indexOf("plus ") + 1);

            int value1 = Integer.parseInt(string1);
            int value2 = Integer.parseInt(string2);
            int result = value1 + value2;
            return String.valueOf(result);
        } else if (query.contains("largest")) {
            String string = query.substring(query.indexOf(": ") + 1);
            String[] valueStringArray = string.split(", ");
            int[] valueArray = new int[valueStringArray.length];
            for (int i = 0; i < valueStringArray.length; i++) {
                valueArray[i] = Integer.parseInt(valueStringArray[i]);
            }
            int max = valueArray[0];
            for (int j : valueArray) {
                if (j > max) {
                    max = j;
                }
            }
            return String.valueOf(max);
        }
        else { // TODO extend the programm here
            return "";
        }
    }
}
