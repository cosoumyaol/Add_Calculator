import java.util.ArrayList;

public class Parsing {
    String[] output;
    String reference = "";
    String operator;
    int j=0;
    ArrayList<Double> error;
    ArrayList<Double> listOfNumbers = new ArrayList<>();
    ArrayList<String> listOfOperators = new ArrayList<>();
    Parsing(String input) {
        output = input.split("");
        if(input.startsWith("/")||
        		input.startsWith("*")||
        		input.startsWith("+")||
        		input.startsWith("-")){
            System.out.println("Invalid input");
        }else {
        try {
            for (int i = 0; i < output.length; i++) {
                if (output[i].equals("+")) {
                    listOfOperators.add(j, "+");
                    listOfNumbers.add(Double.parseDouble(reference));
                    reference = "";
                    j++;
                } else if (output[i].equals("-")) {
                    listOfOperators.add(j, "-");
                    listOfNumbers.add(Double.parseDouble(reference));
                    reference = "";
                    j++;
                } else if (output[i].equals("*")) {
                    listOfOperators.add(j, "*");
                    listOfNumbers.add(Double.parseDouble(reference));
                    reference = "";
                    j++;
                } else if (output[i].equals("/")) {
                    listOfOperators.add(j, "/");
                    listOfNumbers.add(Double.parseDouble(reference));
                    reference = "";
                    j++;
                } else {
                    reference += output[i];
                }
            }
            listOfNumbers.add((double) Double.parseDouble(reference));
        }catch(NumberFormatException e){
            System.out.println("Invalid Input");
        }
    }
    }

    public ArrayList<Double> getArray() {
            return listOfNumbers;
    }

    public ArrayList<String> getOperator(){
        return listOfOperators;
    }
}
