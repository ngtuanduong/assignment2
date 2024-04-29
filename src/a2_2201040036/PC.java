package a2_2201040036;


import a2_2201040036.utils.NotPossibleException;

public class PC {
    private String model;
    private Integer year;
    private String manufacturer;
    private Set<String> comps;

    public PC(String model,Integer year,String manufacturer,Set<String> comps){
        if(!isValidModel(model.trim())) throw new NotPossibleException("Invalid model");
        if(!isValidYear(year)) throw new NotPossibleException("Invalid year");
        if(!isValidManufacturer(manufacturer.trim())) throw new NotPossibleException("Invalid manufacturer");
        if(!isValidComps(comps)) throw new NotPossibleException("Invalid components");
        this.model = model.trim();
        this.year = year;
        this.manufacturer = manufacturer.trim();
        this.comps = comps;
    }

    public String getModel() {
        return this.model;
    }

    public Integer getYear() {
        return this.year;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public Set<String> getComps() {
        return this.comps;
    }

    public void setModel(String model) {
        if(!isValidModel(model.trim())){
            throw new NotPossibleException("Invalid model!");
        }
        this.model = model.trim();
    }

    public void setYear(Integer year) {
        if(!isValidYear(year)){
            throw new NotPossibleException("Invalid year!");
        }
        this.year = year;
    }

    public void setManufacturer(String manufacturer) {
        if(!isValidManufacturer(manufacturer.trim())){
            throw new NotPossibleException("Invalid manufacturer!");
        }
        this.manufacturer = manufacturer.trim();
    }

    public void setComps(Set<String> comps) {
        if(!isValidComps(comps)){
            throw new NotPossibleException("Invalid components!");
        }
        this.comps = comps;
    }
    public void addComp(String comp){
        this.comps.insert(comp);
    }
    public void removeComp(String comp){
        this.comps.remove(comp);
    }

    public boolean isValidModel(String model) {
        return  model != null &&
                !model.isEmpty() &&
                model.length() <= 20;
    }
    public boolean isValidYear(Integer year){
        return year >= 1984;
    }
    public boolean isValidManufacturer(String manufacturer){
        return  manufacturer != null &&
                !manufacturer.isEmpty() &&
                manufacturer.length() <= 15;
    }
    public boolean isValidComps(Set<String> comps){
        return comps != null;
    }

    //method for
    public String compsInReportFormat(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if(!this.getComps().isEmpty()){
            for(int j = 0; j < this.getComps().size();j++){
                sb.append(this.getComps().getElements().get(j));
                if(j != this.getComps().size() - 1){
                    sb.append(", ");
                }
            }
        }
        String comps = sb.toString();
        if(comps.length() > 49){
            comps = comps.substring(0,47) + "...";
        }
        return comps+"]";
    }
    @Override
    public String toString() {
        return String.format("PC<%s, %d, %s, %s>",this.model,this.year,this.manufacturer,this.comps);
    }
    @Override
    public boolean equals(Object pc){
        if (this == pc) return true;
        if(pc == null  || this.getClass() != pc.getClass()) return false;
        PC p = (PC) pc;
        if( this.getComps() != p.getComps()) return false;
        return  this.getModel().equals(p.getModel()) &&
                this.getYear().equals(p.getYear()) &&
                this.getManufacturer().equals(p.getManufacturer()) &&
                this.getComps().equals(p.getComps());
    }
}

