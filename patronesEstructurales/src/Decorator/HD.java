package Decorator;

public class HD extends PlanDecorador{

    public HD (Plan plan) {
        super(plan);
    }

    @Override
    public String descripcion() {
        return plan.descripcion() + " + HD";
    }

    public double costo(){
        return plan.costo() + 500.0;
    }
}
