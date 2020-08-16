import javax.swing.JOptionPane;

/**
 * Write a description of class main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class main
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class main
     */
    public main()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void main(String[] args)
    {
        JOptionPane.showMessageDialog(null, "What time do you start?");
        String input = JOptionPane.showInputDialog("Enter the hour(ex: 12)");
        int h = Integer.parseInt(input);
        input = JOptionPane.showInputDialog("Enter the minute(ex: 02)");
        int m = Integer.parseInt(input);
        input = JOptionPane.showInputDialog("How many subjects do you have?");
        int subjects = Integer.parseInt(input);
        input = JOptionPane.showInputDialog("How many breaks do you want?");
        int breaks = Integer.parseInt(input);
        String[] plan = new String[subjects+breaks];
        int[] timeH = new int[subjects+breaks];
        int[] timeM = new int[subjects+breaks];
        for (int i = 0; i < (subjects+breaks); i++){
            if(m >= 60){
                int c = m/60;
                h += c;
                m = m%60;
            }
            timeH[i] = h;
            timeM[i] = m;
            plan[i] = JOptionPane.showInputDialog("Enter a subject(or break): ");
            if(plan[i].toLowerCase().equals("break")){
                Object[] possibleValues = { "5", "10", "15", "20" };
                Object selectedValue = JOptionPane.showInputDialog(null,
                        "Choose one", "Input",
                        JOptionPane.INFORMATION_MESSAGE, null,
                        possibleValues, possibleValues[0]);
                if (selectedValue.equals("5")){
                    input = "5";
                }else if(selectedValue.equals("10")){
                    input = "10";
                }else if(selectedValue.equals("15")){
                    input = "15";
                }else{
                    input = "20";
                }
            }else{
                input = JOptionPane.showInputDialog("How long is it(in minutes)?");
            }
            m += Integer.parseInt(input);
        }
        Object[] message = {};
        for (int i = 0; i < (subjects+breaks); i++){
            if(timeM[i]< 10){
                JOptionPane.showMessageDialog(null, plan[i]+" starts at "+timeH[i]+":0"+timeM[i]);
            }else{
                JOptionPane.showMessageDialog(null, plan[i]+" starts at "+timeH[i]+":"+timeM[i]);
            }
            // put your code here
        }
    }
}

