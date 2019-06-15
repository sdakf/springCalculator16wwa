package pl.sda.springcalculator;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service //singleton
public class CalculatorService {

    public double calculate(String sentValue){ //todo use cache -> own implementation
        Thread.sleep(3000);
        Pattern pattern = Pattern.compile("(\\d+)(\\D+)(\\d+)");
        Matcher matcher = pattern.matcher(sentValue);
        if (matcher.matches()) {
            String firstValue = matcher.group(1);
            String sign = matcher.group(2).trim();
            String secondValue = matcher.group(3);
            Integer first = Integer.valueOf(firstValue);
            Integer second = Integer.valueOf(secondValue);
            if (sign.equals("+")){
                return first + second;
            }
        }
        return 0;
    }
}
