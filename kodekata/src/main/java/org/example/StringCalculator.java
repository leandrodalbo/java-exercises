package org.example;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int add(String s) {
        List<Integer> negatives = new ArrayList<>();
        String[] values = s.split("[^0-9-]+");
        var sum = 0;

        for (int i = 0; i < values.length; i++) {
            if (values[i].isEmpty())
                continue;

            Integer digit = Integer.valueOf(values[i]);

            if (digit < 0) {
                negatives.add(digit);
                continue;
            }

            if (digit > 1000)
                continue;

            sum += digit;

        }

        if (!negatives.isEmpty())
            throw new InvalidParameterException(String.format("Negatives not allowed %s", negatives));

        return sum;
    }

}
