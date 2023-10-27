package demo.driver;

import demo.modelo.EmpleadoDTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import util.Empleado;

import java.util.List;

public class EmpleadoControlador {

    public static final SessionFactory ssf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();;

    public static void main(String[] args) {

        Empleado empleado = new Empleado();

        //Long emp01 = empleado.add("Olga2", "Cortés");
        empleado.deleteEmpleado(15L);
        //empleado.updateLastName(13L, "Cortés");

        empleado.listEmployees();

        ssf.close();
    }
}
