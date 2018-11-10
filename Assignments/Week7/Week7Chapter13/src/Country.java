public class Country implements Comparable<Country>{
    private int area;
    private double grossDomesticProduct;
    private int population;


    @Override
    public int compareTo(Country a) {
        return this.getArea() - a.getArea();
    }

    public Country(int area, double grossDomesticProduct, int population) {
        this.area = area;
        this.grossDomesticProduct = grossDomesticProduct;
        this.population = population;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getGrossDomesticProduct() {
        return grossDomesticProduct;
    }

    public void setGrossDomesticProduct(double grossDomesticProduct) {
        this.grossDomesticProduct = grossDomesticProduct;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public static void main(String[] args) {
        Country a = new Country(12348, 34575548, 13548784);
        Country b = new Country(1345468, 134576784, 177948144);

        System.out.println(a.compareTo(b));
    }
}
