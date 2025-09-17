package Decorator;

public abstract class PlanDecorador implements Plan {
    protected Plan plan;

    public PlanDecorador (Plan plan){
        this.plan = plan;
    }

    @Override
    public String descripcion() {
        return plan.descripcion();
    }

    @Override
    public double costo() {
        return plan.costo();
    }

}
