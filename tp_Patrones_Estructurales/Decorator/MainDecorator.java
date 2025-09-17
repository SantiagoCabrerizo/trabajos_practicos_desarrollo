package Decorator;

public class MainDecorator {
    public static void main(String[] args) {
        System.out.println("\n--------DECORATOR--------");
//        1. Componente (interface/abstracta) → Define la funcionalidad básica → Plan
//        2. Componente Concreto → Implementación real del objeto base → PlanBasico
//        3. Decorador abstracto → Tiene una referencia al objeto Componente y delega llamadas → PlanDecorador
//        4. Decoradores concretos → Agregan funcionalidades extra al objeto que envuelven → HD, UltraHD , Descargas Offline

        //Creamos un Plan Basico + HD + Descargas Offline
        Plan plan1 = new PlanBasico();
        plan1 = new HD(plan1);
        plan1 = new DescargasOffline(plan1);
        System.out.println("La primera suscripción incluye un: " + plan1.descripcion() + ", con un costo total de $" + plan1.costo());

        //Creamos un Plan Basico + Ultra HD + Descargas Offline
        Plan plan2 = new PlanBasico();
        plan2 = new UltraHD(plan2);
        plan2 = new DescargasOffline(plan2);
        System.out.println("La segunda suscripción incluye un: " + plan2.descripcion() + ", con un costo total de $" + plan2.costo());

        //Creamos un Plan Basico + Descargas Offline
        Plan plan3 = new PlanBasico();
        plan3 = new DescargasOffline(plan3);
        System.out.println("La tercera suscripción incluye un: " + plan3.descripcion() + ", con un costo total de $" + plan3.costo());


    }
}
