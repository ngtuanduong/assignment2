package a2_2201040036;

import a2_2201040036.utils.NotPossibleException;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

/**
 * A program that captures data about PC objects and displays
 * a report about them on the console.
 */
public class PCProg {
    private static final Object YES = "Y";
    private Set<PC> objs;

    /**
     * Initialise this to have an empty set of PCs
     */
    public PCProg() {
        objs = new Set<>();
    }

    /**
     * If <tt>objs</tt> is not empty, displays a text-based tabular
     * report on <tt>objs</tt> to the standard console.
     * Displays nothing if <tt>objs</tt> is empty.
     *
     * @return this report if <tt>objs</tt> is not empty or <tt>null</tt> otherwise.
     */
    public String displayReport() {
        if (!objs.isEmpty()) {
            Vector<PC> pcs = objs.getElements();
            PCReport reportObj = new PCReport();
            return reportObj.displayReport(pcs.toArray(new PC[0]));
        } else {
            return null;
        }
    }

    /**
     * Saves report to a file <tt>pcs.txt</tt> in the program's working directory.
     */
    public void saveReport(String report) {
        String fileName = "pcs.txt";
        try (PrintWriter pw = new PrintWriter(fileName)) {
            pw.println(report);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Initializes an instance of <tt>PCProg</tt>.
     * Create objects from data entered by the user.
     * Display a report on the objects.
     * Prompt user to save report to file. If user answers "Y", save report.
     * Otherwise, end program.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PCProg prog = new PCProg();
        try {
            // create objects
            prog.createObjects();
            // display report
            String report = prog.displayReport();
            System.out.println(report);
            if (report != null) {
                // prompt user to save report
                System.out.println("Save report to file? [Y/N]");
                String toSave = sc.nextLine();
                if (toSave.equals("Y")) {
                    prog.saveReport(report);
                    System.out.println("report saved");
                }
            }
        } catch (NotPossibleException e) {
            System.err.printf("%s: %s%n", e, e.getMessage());
        }
        System.out.println("~END~");
    }
    private void createObjects() {
        PCFactory pf = PCFactory.getFactory();
        Scanner sc = new Scanner(System.in);
        /**
         * if cont = true => create a new PC object
         * else => end method
         */
        boolean cont = true;
        while(cont){
            //let user enter product model
            System.out.print("Please enter product model: ");
            String model = sc.nextLine();
            //move to next line
            System.out.println();

            //let user enter year of manufacture
            System.out.print("Please enter year of manufacture: ");
            Integer year = sc.nextInt();

            sc.nextLine();//"delete" newline character creating by hitting "enter" because the nextInt method does not read it
            //move to next line
            System.out.println();

            //let user enter manufacturer
            System.out.print("Please enter manufacturer: ");
            String manufacturer = sc.nextLine();

            //let user enter components
            String s = new String("tmp");
            Set<String> comps = new Set<>();
            System.out.println("Adding component process!");
            while(!s.equals("")){
                System.out.print("Add component(Type nothing to finish adding component): ");
                s = sc.nextLine();
                if(!s.equals("")) comps.insert(s);

            }
            objs.insert(pf.createPC(model,year,manufacturer,comps));
            boolean wrongResponse = true;
            while(wrongResponse){
                System.out.println("Do you want to add another pc?(Y,N)");
                String tem = sc.nextLine();
                if(tem.equals("Y")){
                    cont = true;
                    wrongResponse = false;
                }else if(tem.equals("N")){
                    cont = false;
                    wrongResponse = false;
                }else{
                    System.out.println("Please enter Y or N to continue");
                    wrongResponse = true;
                }
            }


        }


    }

}
