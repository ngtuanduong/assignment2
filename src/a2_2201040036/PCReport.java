package a2_2201040036;

import java.lang.StringBuffer;
public class PCReport {
    // create a single displayReport operation:
    // modify class to static, since the requirement is no instance variable
    public String displayReport(PC[] objs) {
        StringBuffer report = new StringBuffer();
        int maxModelLength = 0;
        int maxManufacturerLength = 0;
        for(PC pc:objs){
            if(pc.getModel().length() > maxModelLength) maxModelLength = pc.getModel().length();
            if(pc.getManufacturer().length() > maxManufacturerLength) maxManufacturerLength = pc.getModel().length();
        }
        //Add 99 hyphen above title
        report.append("---------------------------------------------------------------------------------------------------");
        //Add title in another line
        report.append("\n");
        report.append("                                           ");
        report.append("PCPROG REPORT");
        report.append("                                           ");
        report.append("\n");
        //Add hyphens below title
        report.append("---------------------------------------------------------------------------------------------------");
        report.append("\n");


        for(int i = 0 ; i < objs.length;i++){
            PC pc = objs[i];
            StringBuilder sb = new StringBuilder();
            sb.append("["+pc.formattedComps());
            String comps = sb.toString();
            if(comps.length() >= 46){
                 comps= comps.substring(0,42) + "...";
            }
            comps+="]";
            report.append(String.format("%3d %20s %6d %20s %s",(i+1), pc.getModel(), pc.getYear(), pc.getManufacturer(), comps) );
            //Move to next line
            report.append("\n");
        }

        //Add hyphens under pc list
        report.append("---------------------------------------------------------------------------------------------------");
        return report.toString();
    }
}


