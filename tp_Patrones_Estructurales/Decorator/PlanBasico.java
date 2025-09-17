package Decorator;

public class PlanBasico implements Plan{

    @Override
    public String descripcion(){
        return "Plan Básico";
    }

    @Override
    public double costo(){
        return 1000.0;
    }
}
