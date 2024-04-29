package a2_2201040036;

import java.lang.StringBuffer;
public class PCReport {
    //Method for building a report base on a list of pcs
    public String displayReport(PC[] objs) {
        StringBuffer report = new StringBuffer();

        //Add 99 hyphen above title
        report.append("---------------------------------------------------------------------------------------------------\n");

        //Add title in another line
        report.append("                                           ");
        report.append("PCPROG REPORT");
        report.append("                                           \n");

        //Add hyphens below title
        report.append("---------------------------------------------------------------------------------------------------\n");

        //looping for adding pcs to the report
        for(int i = 0 ; i < objs.length;i++){
            PC pc = objs[i];

            //building components string
            String comps = pc.compsInReportFormat();

            report.append(String.format("%3d %20s %6d %15s %s %n",(i+1), pc.getModel(), pc.getYear(), pc.getManufacturer(), comps) );
        }

        //Add hyphens under pc list
        report.append("---------------------------------------------------------------------------------------------------\n");

        return report.toString();
    }
}


