package a2_2201040036;


import a2_2201040036.utils.NotPossibleException;

public class PC {
    private String model;
    private Integer year;
    private String manufacturer;
    private Set<String> comps;

    public PC(String model,Integer year,String manufacturer,Set<String> comps){
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.comps = comps;
    }

    public String getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Set<String> getComps() {
        return comps;
    }

    public void setModel(String model) {
        if(!isValidModel(model)){
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
        if(!isValidManufacturer(manufacturer)){
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

    public boolean isValidModel(String model) {
        return model != null && !model.isEmpty() && model.length() <= 20;
    }
    public boolean isValidYear(Integer year){
        return year >= 1984;
    }
    public boolean isValidManufacturer(String manufacturer){
        return manufacturer != null && !manufacturer.isEmpty() && manufacturer.length() <= 15;
    }
    public boolean isValidComps(Set<String> comps){
        return comps != null;
    }
    public String reportFormat(){
        StringBuilder sb = new StringBuilder();
        if(!this.getComps().isEmpty()){
            for(int j = 0; j < this.getComps().size();j++){
                sb.append(this.getComps().getElements().get(j));
                if(j != this.getComps().size() - 1){
                    sb.append(", ");
                }
            }
        }
        return sb.toString();
    }


    @Override
    public String toString() {
        return String.format("PC<%s, %d, %s, %s>",this.model,this.year,this.manufacturer,this.comps);
    }
//    @Override
//    public boolean equals(Object pc){
//
//    }

}

