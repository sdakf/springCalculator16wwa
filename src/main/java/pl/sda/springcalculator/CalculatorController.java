package pl.sda.springcalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired //wstrzyknięcie referencji do serwisu
            CalculatorService calculatorService;

    @Autowired
    CalculatorDAO calculatorDAO;

    @RequestMapping("/calculate") //tutaj beda mapowane requesty na danego urla
    public String calculate(@RequestParam(required = false) String inputText, Model model) { //String oznacza nazwe templejtu html
        double result = calculatorService.calculate(inputText == null ? "" : inputText);
        model.addAttribute("resultValue", result);
        if (inputText != null) { //todo fixme -> single responsibility
            calculatorDAO.addToHistory(inputText + " = " + result);
        }
        model.addAttribute("history", calculatorDAO.getHistorySet());

        return "calculatorForm"; //tak sie nazywa html na ktory zostaniemy przeniesieni
    }
}
