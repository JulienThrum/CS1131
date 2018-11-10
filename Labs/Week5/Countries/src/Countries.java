import java.util.ArrayList;

public class Countries {
    private String name;
    private int population;
    private double area;

    public Countries(String name, int population, double area) {
        this.name = name;
        this.population = population;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getDensity(Countries name) {
        return name.getPopulation()/name.getArea();
    }

    public double getLargestArea(ArrayList<Countries> countries) {
        double max = Double.MIN_VALUE;
        for(int i = 0; i < countries.size(); i++) {
            if(countries.get(i).getArea() > max) {
                max = countries.get(i).getArea();
            }
        }
        return max;
    }

    public double getLargestPopulation(ArrayList<Countries> countries) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < countries.size(); i++) {
            if(countries.get(i).getPopulation() > max) {
                max = countries.get(i).getPopulation();
            }
        }
        return max;
    }

    public double getLargestDensity(ArrayList<Countries> countries) {
        double max = Double.MIN_VALUE;
        for(int i = 0; i < countries.size(); i++) {
            if(countries.get(i).getDensity(countries.get(i)) > max) {
                max = countries.get(i).getDensity(countries.get(i));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ArrayList countries = new ArrayList<Countries>();
        countries.add(new Countries("United States", 380000000, 18980189));
        countries.add(new Countries("Canada", 150000000, 25000000));
    }
}
